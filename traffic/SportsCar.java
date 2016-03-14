import java.awt.Graphics;
import java.awt.Color;

public class SportsCar extends MediumCar {
    public SportsCar(Color bodyColor,int x,int y) {
        super(bodyColor,x,y);
        speed = 2;
        height = 15;
    }
    @Override 
    public void drawFrame(Graphics g) {
        super.drawFrame(g);
        int[] xArray = new int[3];
        int[] yArray = new int[3];
        xArray[0] = x+width;
        yArray[0] = y;
        xArray[1] = x+width;
        yArray[1] = y+height;
        xArray[2] = x+width+15;
        yArray[2] = y+height;
        g.setColor(bodyColor);
        g.fillPolygon(xArray,yArray,3);

        xArray = new int[4];
        yArray = new int[4];
        xArray[0] = x+10;
        yArray[0] = y;
        xArray[1] = x+25;
        yArray[1] = y-10;
        xArray[2] = x+45;
        yArray[2] = y-10;
        xArray[3] = x+55;
        yArray[3] = y;
        g.setColor(Color.black);
        g.fillPolygon(xArray,yArray,4);
        g.drawRect(x+30,y,20,height);
    }
}
