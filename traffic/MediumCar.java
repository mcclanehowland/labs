import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class MediumCar extends Automobile {
    public MediumCar(Color bodyColor,double x,double y) {
        super(bodyColor,x,y);
    }
   	public void drawFrame(Graphics g) {
		g.setColor(bodyColor);
		g.fillRect((int)x,(int)y,width,height);
        int[] xArray = new int[4];
        int[] yArray = new int[4];
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
        g.setColor(Color.yellow);
        g.fillOval((int)x+width-5,(int)y+1,8,8);

	}
	@Override
    public void drawWheels(Graphics g) {
        super.drawWheels(g);
        g.setColor(Color.white);
		g.fillOval((int)x+9,(int)((int)y+height-3.5),7,7);
		g.fillOval((int)x+54,(int)((int)y+height-3.5),7,7);
    }
}
