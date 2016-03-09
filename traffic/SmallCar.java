import java.awt.Graphics;
import java.awt.Color;

public class SmallCar extends Automobile {
    public SmallCar(Color bodyColor,int x,int y) {
        super(bodyColor,x,y);
        
        width = 35;
        height = 15;
    }
    @Override //if the name matches, otherwise it will throw an error
    public void drawWheels(Graphics g) {
        //overriding the parent drawMe
        g.setColor(Color.black);
        g.fillOval(x+3,y+9,10,10);
        g.fillOval(x+20,y+9,10,10);
    }
}
