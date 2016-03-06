import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage; 
 
public class Background1
{
	int x;
	int y;
	
	Color brown;
	BufferedImage tree;
	
	public Background1(int x, int y)
	{
		this.x = x;
		this.y = y;
		brown = new Color(205,133,63);
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.black);
		try 
		{
			tree = ImageIO.read(new File("tree.png"));
		} 		
		catch (IOException e) 
		{	
		}
		
		g.drawImage(tree,x,y+5,null);
		
		for(int i = 0; i < 2000; i += 50)
		{
			g.drawLine(x-800+i,y+220,x-700+i,y+420);
		}
		for(int i = 0; i < 2000; i += 50)
		{
			g.drawLine(x-700+i,y+220,x-800+i,y+420);
		}

	}
	public void moveLeft()
	{
		x -= 20;
	}
	public void moveRight()
	{
		x += 20;
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