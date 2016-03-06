import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
 
public class Background2
{
	int x;
	int y;
	BufferedImage mountain;
	
	public Background2(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void drawMe(Graphics g)
	{
		
		try 
		{
			mountain = ImageIO.read(new File("mountain (1).png"));
		} 		
		catch (IOException e) 
		{	
		}
			g.drawImage(mountain,x,y,null);
	}
	public void moveLeft()
	{
		x -= 5;
	}
	public void moveRight()
	{
		x += 5;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
}