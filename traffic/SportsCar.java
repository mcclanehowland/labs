import java.awt.Graphics;
import java.awt.Color;

public class SportsCar extends MediumCar {
    public SportsCar(Color bodyColor,double x,double y) {
        super(bodyColor,x,y);
        speed = 3;
        height = 15;
    }
    @Override 
    public void drawFrame(Graphics g) {
        super.drawFrame(g);
        int[] xArray = new int[3];
        int[] yArray = new int[3];
        xArray[0] = (int)x+width;
        yArray[0] = (int)y;
        xArray[1] = (int)x+width;
        yArray[1] = (int)y+height;
        xArray[2] = (int)x+width+15;
        yArray[2] = (int)y+height;
        g.setColor(bodyColor);
        g.fillPolygon(xArray,yArray,3);

        xArray = new int[4];
        yArray = new int[4];
        xArray[0] = (int)x+10;
        yArray[0] = (int)y;
        xArray[1] = (int)x+25;
        yArray[1] = (int)y-10;
        xArray[2] = (int)x+45;
        yArray[2] = (int)y-10;
        xArray[3] = (int)x+55;
        yArray[3] = (int)y;
        g.setColor(Color.black);
        g.fillPolygon(xArray,yArray,4);
        g.drawRect((int)x+30,(int)y,20,height);
    }
}
