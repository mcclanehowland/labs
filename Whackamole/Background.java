import java.awt.Graphics;
import java.awt.Color;

public class Background
{
	int x1 = 300;
	int x2 = 400;
	int x3 = 500;
	int x4 = 400;
	int y1 = 300;
	int y2 = 400;
	int y3 = 300;
	int y4 = 200;
	int speed = 4;
	int centerx;
	int centery;
	boolean up = true;
	boolean down = false;
	boolean left = false;
	boolean right = true;
	
	public Background(int centerx, int centery)
	{
		this.centerx = centerx;
		this.centery = centery;
	}
	public void setCenter(int x, int y)
	{
		centerx = x;
		centery = y;
	}
	public void setSpeed(int s)
	{
		if(s > 0)
		{
			up = false;
			down = true;
			left = false;
			right = true;
		}
		if(s < 0)
		{
			up = true;
			down = false;
			left = true;
			right = false;
		}
		speed = Math.abs(s)%20;
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawLine(x1,y1,x2,y2);
		g.drawLine(x2,y2,x3,y3);
		g.drawLine(x3,y3,x4,y4);
		g.drawLine(x4,y4,x1,y1);
		
		/*g.drawLine(x1,y1,800,600);
		g.drawLine(x2,y2,800,600);
		g.drawLine(x3,y3,800,600);
		g.drawLine(x1,y1,800,0);
		g.drawLine(x2,y2,800,0);
		g.drawLine(x3,y3,800,0);
		g.drawLine(x1,y1,0,0);
		g.drawLine(x2,y2,0,0);
		g.drawLine(x3,y3,0,0);
		g.drawLine(x1,y1,0,600);
		g.drawLine(x2,y2,0,600);
		g.drawLine(x3,y3,0,600);*/
		g.drawLine(x4,y4,centerx,centery);
		g.drawLine(x3,y3,centerx,centery);		
		g.drawLine(x2,y2,centerx,centery);
		g.drawLine(x1,y1,centerx,centery);
		
	}
	public void reset()
	{
		x1 = 300;
		x2 = 400;
		x3 = 500;
		x4 = 400;
		y1 = 300;
		y2 = 400;
		y3 = 300;
		y4 = 200;
		speed = 4;
		centerx = 400;
		centery = 300;
		up = true;
		down = false;
		left = false;
		right = true;
	}
	public void move()
	{
		if(up && y4 > 0)
		{
			y1 -= speed;
			y2 -= speed;
			y3 -= speed;
			y4 -= speed;
			//centery -= (int)(Math.random()*2+1);
		}
		if(down && y2 < 600)
		{
			y1 += speed;
			y2 += speed;
			y3 += speed;
			y4 += speed;
			//centery += (int)(Math.random()*2+1);
		}
		if(left && x1 > 0)
		{
			x1 -= speed;
			x2 -= speed;
			x3 -= speed;
			x4 -= speed;
			//centerx -= (int)(Math.random()*2+1);
		}
		if(right && x3 < 800)
		{
			x1 += speed;
			x2 += speed;
			x3 += speed;
			x4 += speed;
			//centerx += (int)(Math.random()*2+1);
		}
		if(x1 <= 0 || centerx <= 0)
		{
			left = false;
			right = true;
		}
		if(x3 >= 800 || centerx >= 800)
		{
			left = true;
			right = false;
		}
		if(y2 >= 600 || centery >= 600)
		{
			up = true;
			down = false;
		}
			
		if(y4 <= 0 || centery <= 0)
		{
			down = true;
			up  = false;
		}
			
	}
}