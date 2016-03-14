import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class MediumCar extends Automobile {
    public MediumCar(Color bodyColor,int x,int y) {
        super(bodyColor,x,y);
    }
   	public void drawFrame(Graphics g) {
		g.setColor(bodyColor);
		g.fillRect(x,y,width,height);
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
        g.setColor(Color.black);
        g.fillPolygon(xArray,yArray,4);
        g.setColor(Color.yellow);
        g.fillOval(x+width-5,y+1,8,8);

	}
	@Override
    public void drawWheels(Graphics g) {
        super.drawWheels(g);
        g.setColor(Color.white);
		g.fillOval(x+9,(int)(y+height-3.5),7,7);
		g.fillOval(x+54,(int)(y+height-3.5),7,7);
    }
}
