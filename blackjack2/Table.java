import javax.swing.JPanel;
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
import java.util.ArrayList;

public class Table extends JPanel implements ActionListener{

    JButton hit;
    JButton newGame;
    JButton stand;
    
    private ArrayList<Card> cards;
    private ArrayList<Card> playerCards;
    private ArrayList<Card> dealerCards;
    
    private int offset = 0;
    private int pointOffset = 0;
    private int cardNum; 
    private String event;
    private boolean playing = false;
    private boolean dealer = false;
    private boolean ifWin = false;
    private boolean ifLose = false;
    private boolean ifTie = false;
    private int counter;
    private int sum;
    private int lose;
    private int win;
    private int dealerSum;
    private int displayedDealerSum;

    public Table() {
        setLayout(null); //set layout
        cards = new ArrayList<Card>();
        playerCards = new ArrayList<Card>();
        dealerCards = new ArrayList<Card>();

        cards.add(new Card(1,"Ace","Clubs",false));
        cards.add(new Card(2,"2","Clubs",false));
        cards.add(new Card(3,"3","Clubs",false));
        cards.add(new Card(4,"4","Clubs",false));
        cards.add(new Card(5,"5","Clubs",false));
        cards.add(new Card(6,"6","Clubs",false));
        cards.add(new Card(7,"7","Clubs",false));
        cards.add(new Card(8,"8","Clubs",false));
        cards.add(new Card(9,"9","Clubs",false));
        cards.add(new Card(10,"10","Clubs",false));
        cards.add(new Card(10,"Jack","Clubs",false));
        cards.add(new Card(10,"Queen","Clubs",false));
        cards.add(new Card(10,"King","Clubs",false));
        cards.add(new Card(1,"Ace","Diamonds",false));
        cards.add(new Card(2,"2","Diamonds",false));
        cards.add(new Card(3,"3","Diamonds",false));
        cards.add(new Card(4,"4","Diamonds",false));
        cards.add(new Card(5,"5","Diamonds",false));
        cards.add(new Card(6,"6","Diamonds",false));
        cards.add(new Card(7,"7","Diamonds",false));
        cards.add(new Card(8,"8","Diamonds",false));
        cards.add(new Card(9,"9","Diamonds",false));
        cards.add(new Card(10,"10","Diamonds",false));
        cards.add(new Card(10,"Jack","Diamonds",false));
        cards.add(new Card(10,"Queen","Diamonds",false));
        cards.add(new Card(10,"King","Diamonds",false));
        cards.add(new Card(1,"Ace","Hearts",false));
        cards.add(new Card(2,"2","Hearts",false));
        cards.add(new Card(3,"3","Hearts",false));
        cards.add(new Card(4,"4","Hearts",false));
        cards.add(new Card(5,"5","Hearts",false));
        cards.add(new Card(6,"6","Hearts",false));
        cards.add(new Card(7,"7","Hearts",false));
        cards.add(new Card(8,"8","Hearts",false));
        cards.add(new Card(9,"9","Hearts",false));
        cards.add(new Card(10,"10","Hearts",false));
        cards.add(new Card(10,"Jack","Hearts",false));
        cards.add(new Card(10,"Queen","Hearts",false));
        cards.add(new Card(10,"King","Hearts",false));
        cards.add(new Card(1,"Ace","Spades",false));
        cards.add(new Card(2,"2","Spades",false));
        cards.add(new Card(3,"3","Spades",false));
        cards.add(new Card(4,"4","Spades",false));
        cards.add(new Card(5,"5","Spades",false));
        cards.add(new Card(6,"6","Spades",false));
        cards.add(new Card(7,"7","Spades",false));
        cards.add(new Card(8,"8","Spades",false));
        cards.add(new Card(9,"9","Spades",false));
        cards.add(new Card(10,"10","Spades",false));
        cards.add(new Card(10,"Jack","Spades",false));
        cards.add(new Card(10,"Queen","Spades",false));
        cards.add(new Card(10,"King","Spades",false));

        hit = new JButton("Hit");
        hit.setBounds(0,520,200,60);
        hit.addActionListener(this);

        stand = new JButton("Stand");
        stand.setBounds(0,580,200,60);
        stand.addActionListener(this);

        newGame = new JButton("New Game");
        newGame.setBounds(0,640,200,60);
        newGame.addActionListener(this);
        add(newGame);
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
        dealerSum = 0; //calculate initial dealer sum
        int dealerAce = 0;
        for(Card each : dealerCards) {
            if(each.getValue() == 1) 
                dealerAce++; //are there any aces? how many?
            dealerSum += each.getValue();
        }
        for(int i = 1; i <= dealerAce;i++) { //add aces up
            if(dealerSum + 10 <= 21) {
                dealerSum += 10;
            }
        }
        displayedDealerSum = 0; //calculate initial displayed dealer sum, aces calculated in final displayed dealer sum
        for(Card each : dealerCards) {
            if(each.getVisible() && !each.getDealer()) {
                displayedDealerSum += each.getValue();
            }
        }
        sum = 0; //calculate initial player sum
        int playerAce = 0;
        for(Card each : playerCards) {
            if(each.getValue() == 1) {
                playerAce++; //aces
            }
            sum += each.getValue();
        }
        for(int i = 1; i <= playerAce;i++) { //add the aces up
            if(sum + 10 <= 21) {
                sum += 10;
            }
        }
//logic begins
        if(sum > 21) { //player busts
            playSound("boo");
            dealerCards.get(1).setDealer(false);
            lose++; 
            ifLose = true; //will display "you lose"
            playing = false;
            removeAll();
            add(newGame);
        }
        if(dealerSum > 21) { //dealer busts
            playing = false;
            dealerCards.get(1).setDealer(false);
            playSound("cymbals");
            if(!ifLose) //if you did not lose, you won (not needed, but the need may arise)
                ifWin = true;
            removeAll();
            add(newGame);
            win++; 
        }
        if(sum == 21) { //blackjack!!! game is over and dealer does not go
            playSound("cymbals");
            dealerCards.get(1).setDealer(false);
            playing = false;
            removeAll();
            add(newGame);
        }
        /*
        dealerSum = 0; //calculate final dealerSum, because the game might be over and the card values may have changed. Not needed for this but is needed for the displayed dealer sum.
        dealerAce = 0;
        for(Card each : dealerCards) {
            if(each.getValue() == 1) 
                dealerAce++;
            dealerSum += each.getValue();
        }
        for(int i = 1; i <= dealerAce;i++) {
            if(dealerSum + 10 <= 21) {
                dealerSum += 10;
            }
        }*/
        displayedDealerSum = 0;
        int displayedDealerAce = 0; 
        for(Card each : dealerCards) {
            if(each.getVisible() && !each.getDealer()) {
                displayedDealerSum += each.getValue();
                if(each.getValue() == 1) {
                    displayedDealerAce++;
                }
            }
        }
        for(int i = 1; i <= displayedDealerAce;i++) {
            if(displayedDealerSum+ 10 <= 21) {
                displayedDealerSum += 10;
            }
        }
        /*
        sum = 0;
        playerAce = 0;
        for(Card each : playerCards) {
            if(each.getValue() == 1) {
                playerAce++;
            }
            sum += each.getValue();
        }
        for(int i = 1; i <= playerAce;i++) {
            if(sum + 10 <= 21) {
                sum += 10;
            }
        }
        */
        g.setColor(Color.black);
        g.drawString("Total: "+sum,350,600);
        g.drawString("Dealer Total: "+displayedDealerSum,450,600);
        g.drawString("Wins: "+win,350,640);
        g.drawString("Losses: "+lose,350,680);
        g.drawString("Player Cards:",10,50);
        g.drawString("Dealer Cards:",10,250);

        int x = 150;
        int y = 50;
        for(Card each : playerCards) {
            if(each.getVisible()) {
                each.drawMe(g,x,y);
                x += 110;
            }
        }
        x = 150;
        y = 260;
        for(Card each : dealerCards) {
            if(each.getVisible()) {
                each.drawMe(g,x,y);
                x += 110;
            }
        }
        g.setColor(Color.black);
        if(ifWin) {
            g.drawString("You Win",500,500);
        }
        if(ifLose) {
            g.drawString("You lose",500,500);
        }
        if(ifTie) {
            g.drawString("You Tie",500,500);
        }
    }
    public void shuffle() {
        for(int i = 0; i < cards.size();i++) {
            int swap = (int)(Math.random()*cards.size());
            Card temp = cards.get(i);
            cards.set(i,cards.get(swap));
            cards.set(swap,temp);
        }
    }
    public void playSound(String sound) {
       try {
            URL url = this.getClass().getClassLoader().getResource(sound+".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
       }
       catch (Exception exc) {
             exc.printStackTrace(System.out);
       } 
    }
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == newGame) {
             dealer = false;
             shuffle();
             playerCards.clear();
             dealerCards.clear();
             cardNum = 3;
                 playerCards.add(cards.get(0));
                 playerCards.get(0).setVisible(true);
                 playerCards.add(cards.get(1));
                 playerCards.get(1).setVisible(true);
                 dealerCards.add(cards.get(2));
                 dealerCards.get(0).setVisible(true);
                 dealerCards.add(cards.get(3));
                 dealerCards.get(1).setVisible(true);
                 dealerCards.get(1).setDealer(true);
             removeAll();
             add(hit);
             add(stand);
             playing = true; 
             ifWin = false; //displaying if you won, lost, or tied
             ifLose = false;
             ifTie = false;
             sum = 0; //reset sum
         }
         if(e.getSource() == hit && sum < 21) { //hit
             playSound("chime_up");
             cardNum++; //card index in deck
             playerCards.add(cards.get(cardNum));
             playerCards.get(playerCards.size()-1).setVisible(true);
             sum += playerCards.get(playerCards.size()-1).getValue(); //add card value to sum
         }
         if(e.getSource() == stand && sum <= 21) {
             while(dealerSum < 17) {
                 cardNum++;
                 dealerCards.add(cards.get(cardNum));
                 dealerCards.get(dealerCards.size()-1).setVisible(true);
                 dealerSum += dealerCards.get(dealerCards.size()-1).getValue();
                 repaint();
             }
             dealer = true;
             if(dealerSum > sum && dealerSum <= 21) {
                 playSound("boo");
                 dealerCards.get(1).setDealer(false);
                 ifLose = true;
                 lose++;
             }
             if(dealerSum < sum || dealerSum > 21) {
                 playSound("cymbals");
                 dealerCards.get(1).setDealer(false);
                 ifWin = true;
                 win++;
             }
             if(dealerSum == sum) {
                 playSound("exit_cue_y");
                 ifTie = true;
             }
             dealerCards.get(1).setDealer(false);
             playing = false;
             playSound("exit_cue_y");
             removeAll();
             add(newGame);
             sum = 0;
         }
         repaint();
    }
}

