import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Card {
    private int value;
    private String suit;
    private String face;
    private boolean visible;

    public Card(int value, String suit, boolean visible) {
        this.value = value;
        this.suit = suit;
        this.visible = visible;
        if(value <= 10 && value != 0 && value != 1)
            face = ""+value;
        if(value > 10 || value == 0 || value == 1) {
            switch(value) {
                case 11: 
                    face = "Jack"; 
                    value = 10;
                    break;
                case 12:
                    face = "Queen"; 
                    value = 10;
                    break;
                case 0: 
                    face = "King"; 
                    value = 10;
                    break;
                case 1: 
                    face = "Ace";
                    value = 1;
                    break;
            }
        }
             
    }
    public String toString() {

        return face+" of "+suit;
    }
    public void draw(Graphics g,int x,int y) {
        if(value <= 10 && value != 0 && !face.equals("Queen") && !face.equals("King") && !face.equals("Jack") && !face.equals("Ace")) {
                    face = ""+value;
        }
        if(value > 10 || value == 0 || value == 1) {
            switch(face) {
                case "Jack": 
                    face = "Jack"; 
                    value = 10;
                    break;
                case "Queen":
                    face = "Queen"; 
                    value = 10;
                    break;
                case "King": 
                    face = "King"; 
                    value = 10;
                    break;
                case "Ace": 
                    face = "Ace";
                    value = 1;
                    break;
            }
        }
        
               g.setColor(Color.white);
        g.fillRoundRect(x,y,100,200,20,20);
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
            g.fillOval(x+30,y+60,30,30);
            g.fillOval(x+15,y+90,30,30);
            g.fillOval(x+45,y+90,30,30);
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
    public int getValue() {
        return value;
    }
    public boolean getVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
