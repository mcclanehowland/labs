import java.awt.Color;
import java.awt.Graphics;
 

public class RainDrop
{
	double x, y;
	double speed;
	
	public RainDrop()
	{
		x = (int)(Math.random()*900) - 250;
		y = (int)(Math.random()*600);
		speed = 1 + Math.random()*4;
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect((int)x,(int)y,(int)((speed / 2)),4 * (int)(1 + (speed / 2.0)));
	}
	public void move()
	{
		y += speed;
		x += speed / 3;
		if(y > 600)
		{
			y = 0;
			x = (int)(Math.random()*800);
			speed = 1 + Math.random()*4;
		}
	}
	
}