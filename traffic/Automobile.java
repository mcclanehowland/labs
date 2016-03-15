import java.awt.Graphics;
import java.awt.Color;

public class Automobile {

	public Color bodyColor;
	public double x;
	public double y;
    public double Y;
	public int width;
	public int height;
    public double speed = 1;
    private boolean exitUp = false;
    private boolean exitDown = false;
	
	
	public Automobile(Color bodyColor, double x, double y) {

		this.bodyColor = bodyColor;
		this.x = x;
		this.y = y;
        Y = y;
		this.width = 70;
		this.height = 20;
	}
	public void drawMe(Graphics g) {
		
		this.drawFrame(g);
		this.drawWheels(g);
	}
	public void drawFrame(Graphics g) {
		g.setColor(bodyColor);
		g.fillRect((int)(x),(int)(y),width,height);
	}
	public void drawWheels(Graphics g) {	
		g.setColor( Color.black );
		g.fillOval((int)(x+5),(int)(y+height-7.5), 15, 15);
		g.fillOval((int)(x+50),(int)(y+height-7.5), 15, 15);
	}
    public void move() {
        x += speed;
        if(exitDown) {
                y -= speed/3.0 ;
        }
        if(exitUp) {
            y += speed/3.0;
        }
        if(x > 800) {
            x = 0-width;
            y = Y;
            exitDown = false;
            exitUp = false;
        }
        if(x > 275 && x < 300 && y > 100 && y < 200 && (int)(Math.random()*100)%(int)(Math.random()*100+1)==0) {
            exitUp = true;
        }
        else if(x > 275 && x < 300 && y > 400 && y < 500 && (int)(Math.random()*1000)%(int)(Math.random()*1000+1)==0) {
            exitDown = true;
        }
    }
	
}
