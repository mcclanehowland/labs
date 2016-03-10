import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Sedan extends MediumCar {

    public Sedan(Color bodyColor,int x,int y) {
        super(bodyColor,x,y);

    }
    public void drawFrame(Graphics g) {
        //4 door frame, use super.draw(g) to draw frame and then ddraw four door frame;
        super.drawFrame(g);
        g.setColor(Color.black);
        g.drawRect(x+20,y,15,20);
        g.drawRect(x+35,y,15,20);
    }
}
