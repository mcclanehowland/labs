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
        int[] xArray = new int[4];
        int[] yArray = new int[4];
        xArray[0] = x+10;
        yArray[0] = y;
        xArray[1] = x+25;
        yArray[1] = y-10;
        xArray[2] = x+45;
        yArray[2] = y-10;
        xArray[3] = x+55;
        yArray[3] = y;
        g.fillPolygon(xArray,yArray,4);
    }
}
