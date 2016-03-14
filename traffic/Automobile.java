import java.awt.Graphics;
import java.awt.Color;

public class Automobile {

	public Color bodyColor;
	public int x = 100;
	public int y = 100;
	public int width;
	public int height;
    public int speed = 1;
	
	
	public Automobile(Color bodyColor, int x, int y) {

		this.bodyColor = bodyColor;
		this.x = x;
		this.y = y;
		this.width = 70;
		this.height = 20;
	}
	public void drawMe(Graphics g) {
		
		this.drawFrame(g);
		this.drawWheels(g);
	}
	public void drawFrame(Graphics g) {
		g.setColor(bodyColor);
		g.fillRect(x,y,width,height);
	}
	public void drawWheels(Graphics g) {	
		g.setColor( Color.black );
		g.fillOval(x+5,(int)(y+height-7.5), 15, 15);
		g.fillOval(x+50,(int)(y+height-7.5), 15, 15);
	}
    public void move() {
        x += speed;
        if(x > 800) {
            x = 0-width;
        }
    }
	
}
