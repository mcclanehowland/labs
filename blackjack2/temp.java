/*import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Table extends JPanel implements ActionListener{

    JButton hit;
    JButton newGame;
    JButton stand;
    JButton ai;
    JButton stop;
    
    private Card[] cards;
    
    private int offset = 0;
    private int pointOffset = 0;
    private int cardNum; 
    private int points = 20;
    private int sum;
    private String event;
    private boolean playing = true;
    private boolean bot = false;
    private int counter;

    public Table() {
        setLayout(null); //set layout
        ai = new JButton("Start");
        ai.setBounds(100,800,100,30);
        ai.addActionListener(this);
        add(ai);
        stop = new JButton("Stop");
        stop.setBounds(100,830,100,30);
        stop.addActionListener(this);
        add(stop);
        cards = new Card[52];
        int counter = 1;
        for(int i = 0; i < cards.length;i++) {
            if(i < 13)
                cards[i] = new Card(counter%13,"Clubs",false);
            else if(i < 26) 
                cards[i] = new Card(counter%13,"Spades",false);
            else if(i < 39) 
                cards[i] = new Card(counter%13,"Diamonds",false);
            else if(i < 52)
                cards[i] = new Card(counter%13,"Hearts",false);
            counter++;
        }
        hit = new JButton("Hit");
        hit.setBounds(0,620,200,60);
        hit.addActionListener(this);

        stand = new JButton("Stand");
        stand.setBounds(0,680,200,60);
        stand.addActionListener(this);

        newGame = new JButton("New Game");
        newGame.setBounds(0,740,200,60);
        newGame.addActionListener(this);
        add(newGame);
    }
    public void print() {
        for(Card each : cards) {
            System.out.println(each);
        }
        System.out.println();
    }
    public Dimension getPreferredSize() {
        return new Dimension(1000,800); //size
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0,0,1000,800);
        Font font = new Font("Arial",Font.PLAIN,20);
        g.setFont(font);
        g.setColor(Color.black);
        if(bot)
            ai(g);
        playing();
        int x = 50;
        int y = 50;
        for(int i = 0; i < cardNum;i++) {
            cards[i].setVisible(true);
        }
        sum = 0;
        for(Card each : cards) {
            if(x >= 1450) {
                x = 50;
                y += 220;
            }

            if(each.getVisible()) { 
                each.draw(g,x,y);
                x += 110;
                if(each.getValue() == 1 && sum + 11 <= 21)
                    sum += 11;
                else
                    sum += each.getValue();
            }
           
        }
        if(sum > 21) {
            playing = false;
            if(!bot)
                playSound("boo");
            playing();
        }
        if(sum == 21) {
            playing = false;
            if(!bot)
                playSound("cymbals");
            playing();
        }
        g.setColor(Color.green);
        g.fillRect(0,600,1000,400);
        g.setColor(Color.black);
        g.drawString("Total: "+sum,400,400);
        g.drawString("Points: "+points,400,450);
    }
    public void shuffle() {
        for(int i = 0; i < cards.length;i++) {
            int swap = (int)(Math.random()*cards.length);
            Card temp = cards[i];
            cards[i] = cards[swap];
            cards[swap] = temp;
        }
    }
    public void playSound(String sound) {
       try
         {
            URL url = this.getClass().getClassLoader().getResource(sound+".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
         }
         catch (Exception exc)
         {
             exc.printStackTrace(System.out);
         } 
    }

    public void playing() {
        if(!playing) {
             removeAll();
             add(newGame);
             if(sum <= 21) {
                 switch(sum) {
                    case 16:
                        points += 1;
                        break;
                    case 17: 
                        points += 1;
                        break;
                    case 18: 
                        points += 1;
                        break;
                    case 19:
                        points += 2;
                        break;
                    case 20: 
                        points += 3;
                        break;
                    case 21:
                        points += 5;
                        break;
                 }
             }
        }
    }
     public void ai(Graphics g) {

        if(sum < 16) {
             if(cardNum < cards.length)
                cardNum += 1;
                repaint();
        }
        if(sum >= 16) {
             playing = false;
             repaint();
             shuffle();
             playing();
             points -= 1;
             cardNum = 2;
             for(int i = 0; i < cards.length;i++) {
                 cards[0].setVisible(true);
                 cards[1].setVisible(true);
                 cards[i].setVisible(false);
             }
             removeAll();
             add(hit);
             add(stand);
             add(stop);
             add(ai);
             playing = true;

             
        }
        counter++;
        if(counter%1 == 0) {
            g.setColor(Color.magenta);
            g.fillRect(counter%1500+offset,points%1000,1,1);
            if(counter%1500 == 0) {
                offset += 10;
            }

        }
                repaint();
    }
    public void sleep(int time) {
        try {
            Thread.sleep(time);                 
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == newGame && points > 0) {
             shuffle();
             points -= 1;
             cardNum = 2;
             for(int i = 0; i < cards.length;i++) {
                 cards[0].setVisible(true);
                 cards[1].setVisible(true);
                 cards[i].setVisible(false);
             }
             removeAll();
             add(hit);
             add(stand);
             add(ai);
             add(stop);
             playing = true;
         }
         if(e.getSource() == hit && sum < 21) {
             if(cardNum < cards.length)
                cardNum += 1;
             playSound("chime_up");
         }
         if(e.getSource() == stand && sum <= 21) {
             playing = false;
             playSound("exit_cue_y");
         }
         if(e.getSource() == ai) {
             add(stop);
             bot = true;
         }
         if(e.getSource() == stop) {
             bot = false;
             remove(stop);
         }
         add(stop);


            repaint();
    }
}

*/
