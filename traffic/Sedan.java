import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Sedan extends MediumCar {

    public Sedan(Color bodyColor,double x,double y) {
        super(bodyColor,x,y);
        speed = 1+Math.random()*1;

    }
    @Override
    public void drawFrame(Graphics g) {
        //4 door frame, use super.draw(g) to draw frame and then ddraw four door frame;
        super.drawFrame(g);
        g.setColor(Color.black);
        g.drawRect((int)x+20,(int)y,15,20);
        g.drawRect((int)x+35,(int)y,15,20);
    }
}
