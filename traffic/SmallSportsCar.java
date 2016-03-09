import java.awt.Graphics;
import java.awt.Color;

public class SmallSportsCar extends SmallCar {
    public SmallSportsCar(Color bodyColor,int x,int y) {

        super(bodyColor,x,y);
        speed = 2;

    }
    @Override 
    public void drawFrame(Graphics g) {

        super.drawFrame(g); //original frame
        //add the front
        g.setColor(bodyColor);
        //p1
        int[] xArray = new int[3];
        int[] yArray = new int[3];
        xArray[0] = x+width;
        yArray[0] = y;
        xArray[1] = x+width;
        yArray[1] = y+height;
        xArray[2] = x+width+15;
        yArray[2] = y+height;
        g.fillPolygon(xArray,yArray,3);

	}
	
}
