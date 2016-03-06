import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;  
 
public class MainCharacter
{
	int x;
	int y;
	BufferedImage character;
	
	Color blue;
	
	public MainCharacter(int x, int y)
	{
		this.x = x;
		this.y = y;
		blue = new Color(0,0,255);
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void drawMe(Graphics g, boolean right)
	{
		if(right)
		{
			try 
			{
				character = ImageIO.read(new File("man.png"));
			} 		
			catch (IOException e) 
			{	
			}
		}
		else if(right == false)
		{
			try 
			{
				character = ImageIO.read(new File("manreflection.png"));
			} 		
			catch (IOException e) 
			{	
			}
		}
		g.drawImage(character,x,y-70,null);
		
		//g.setColor(blue);
		//g.fillOval(x,y,50,50);
	}
	public void sleep(int time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
 
}