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
	}
	public void drawWheels(Graphics g) {	
		g.setColor( Color.black );
		g.fillOval(x+5,y+10, 15, 15);
		g.fillOval(x+50,y+10, 15, 15);
	}
}
