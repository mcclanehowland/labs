import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;  
import java.awt.Color;
import java.awt.Graphics;

public class Enemy
{
	int x, y,pX,pY;
	int direction;
	int counter;
	int level;
	boolean left, up, down;
	boolean visible = true;
	boolean shoot;
	Sound sound = new Sound();

	int width, height;
	BufferedImage pepe;
	
	
	public Enemy(int level)
	{
		
		if(visible)
		{
			x = (int)(Math.random()*300+400);
			y = (int)(Math.random()*550);
			direction = (int)(Math.random()*2+1);
		}
		this.level = level;
		if(level <= 2)
		{
			height = 105;
			width = 60;
		}
		if(level == 3)
		{
			height = 180;
			width = 50;
		}
		
		
	}
	public void checkCollision(Projectile p)
	{
		
		if(visible && p.getVisible())
		{
			int pX = p.getX();
			int pY = p.getY();
			int pW = p.getWidth();
			int pH = p.getHeight();
			
			
			
			if(pX + pW >= x && pX <= x+width && pY+pH >= y && pY <= y + height)
			{
				//System.out.println("collided");
				visible = false;
				p.setVisible(false);
				Banish();
				sound.playSound3();
				
				
			}
			
		}
		
			
	}
	public void Banish()
	{
		x = 900;
		y = -50;
	}
	public boolean checkBounds()
	{
		if(x <= 0)
		{
			Banish();
			return true;
		}
		return false;
	}
	public void reset()
	{
		
		x = (int)(Math.random()*300+500);
		y = (int)(Math.random()*750);
		direction = (int)(Math.random()*2+1);
	}
	public boolean getVisible()
	{
		return visible;
	}
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	public void drawMe(Graphics g)
	{
		counter++;
		
		if(level == 3)
		{
			if(visible)
			{
				try 
			{
				pepe = ImageIO.read(new File("gorilla.png"));
			} 		
			catch (IOException e) {}
			g.drawImage(pepe,x,y,null);
			}
				
		}
		if(level <= 2)
		{
			if(visible)
			{
				try 
			{
				pepe = ImageIO.read(new File("monkey.png"));
			} 		
			catch (IOException e) {}
			g.drawImage(pepe,x,y,null);
		}
		
		}
		
	}
	public void move()
	{
		if(visible && (level == 1 || level == 3))
		{
			if(direction == 1)
				y--;
			else if(direction == 2)
				y++;
			x--;
			counter++;
			if(counter%(int)(Math.random()*50+50) == 0)
				direction = (int)(Math.random()*2+1);
			if(y <= 0)
				direction = 2;
			if(y >= 550)
				direction = 1;
		}
		if(visible && level == 2)
		{
			if(direction == 1)
				y -= 2;
			else if(direction == 2)
				y += 2;
			x -= 2;
			counter++;
			if(counter%(int)(Math.random()*50+50) == 0)
				direction = (int)(Math.random()*2+1);
			if(y <= 0)
				direction = 2;
			if(y >= 550)
				direction = 1;
		}
		
			
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
}