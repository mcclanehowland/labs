import java.awt.Color;
import java.awt.Graphics;
 

public class Object
{
	double x, y;
	double speed;
	
	public Object()
	{
		x = (int)(Math.random()*900) - 250;
		y = (int)(Math.random()*600);
		speed = 1 + Math.random()*4;
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect((int)x,(int)y,(int)(speed/2.0),1 * (int)(1 + (speed / 2.0)));
		g.setColor(Color.green);
		g.fillRect((int)(x+speed/2),(int)(y+speed/2),(int)(speed/2.0),1 * (int)(1 + (speed / 2.0)));
	}
	public void move()
	{
		
		x -= speed;
		if(x < 0)
		{
			y = (int)(Math.random()*600);
			x = 800;
			speed = 1 + Math.random()*4;
		}
	}
	
}