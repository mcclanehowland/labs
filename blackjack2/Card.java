import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Card {
    private int value;
    private String suit;
    private String face;
    private boolean visible;
    private boolean dealer;

    public Card(int value, String face, String suit, boolean visible) {
        this.value = value;
        this.suit = suit;
        this.visible = visible;
        this.face = face; 
    }
    public String toString() {

        return face+" of "+suit;
    }
    public void drawMe(Graphics g,int x,int y) {
        g.setColor(Color.white);
        g.fillRoundRect(x,y,100,200,20,20);
        if(dealer) {
            g.setColor(Color.blue);
            g.fillRoundRect(x+10,y+10,80,180,20,20);
            g.setColor(Color.white);
            for(int i = x+10; i < x+100; i += 8) {
                    g.drawLine(i,x+10,x+10,y+180);
                    g.drawLine(i,x+10,x+90,y+180);
            }
        }
        if(!dealer) {
            if(suit.equals("Diamonds")) {
                g.setColor(Color.red);
                int[] xcoordinates = {x+30,x+55,x+80,x+55,x+30};
                int[] ycoordinates = {y+80,y+140,y+80,y+20,y+80};
                g.fillPolygon(xcoordinates,ycoordinates,5);
            }
            else if(suit.equals("Hearts")) {
                g.setColor(Color.red);
                int[] xcoordinates = {x+30,x+80,x+55,x+30};
                int[] ycoordinates = {y+80,y+80,y+140,y+80};
                g.fillPolygon(xcoordinates,ycoordinates,4);
                g.fillOval(x+30,y+60,25,25);
                g.fillOval(x+55,y+60,25,25);

            }
            else if(suit.equals("Clubs")) {
                g.setColor(Color.black);
                g.fillOval(x+30,y+70,30,30);
                g.fillOval(x+16,y+90,30,30);
                g.fillOval(x+44,y+90,30,30);
                g.fillRect(x+40,y+110,10,30);
            }
            else if(suit.equals("Spades")) {
                g.setColor(Color.black);
                int[] xcoordinates = {x+30,x+60,x+90,x+30};
                int[] ycoordinates = {y+100,y+50,y+100,y+100};
                g.fillPolygon(xcoordinates,ycoordinates,4);
                g.fillRect(x+50,y+70,20,60);
            }
            g.drawString(face,x+5,y+30);
            if(face.equals("King") || face.equals("Queen") || face.equals("Ace") || face.equals("Jack"))
                g.drawString(face,x+40,y+180);
            else 
                g.drawString(face,x+80,y+170);
        }
        //System.out.println(face+" of "+suit+" drawn");
    }
    public int getValue() {
        return value;
    }
    public boolean getVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }
    public boolean getDealer() {
        return dealer;
    }


}

