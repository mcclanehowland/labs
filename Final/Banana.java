import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;  
import java.awt.Color;
import java.awt.Graphics;

public class Banana
{
	BufferedImage banana;
	BufferedImage comet;
	
	int x,y;
	int cX,cY;
	public Banana()
	{
		
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*600);
		cX = (int)(Math.random()*800);
		cY = -200;
	}
	public void drawMe(Graphics g)
	{
		try 
		{
			banana = ImageIO.read(new File("banana.png"));
		} 		
		catch (IOException e) 
		{	
		}
		
		g.drawImage(banana,x,y,null);
		//System.out.print("("+x+","+y+")");
	}
	public void drawComet(Graphics g)
	{
		try 
		{
			comet = ImageIO.read(new File("comet.png"));
		} 		
		catch (IOException e) 
		{	
		}
		g.drawImage(comet,cX,cY,null);
	}
	public void move()
	{
		cX -= 5;
		cY += 5;
		if(cX <= -100 || cY >= 800)
		{
			cX = (int)(Math.random()*800+1);
			cY = -200;
		}
	}
}