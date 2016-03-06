import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;  
import java.awt.Color;
import java.awt.Graphics;
 
public class Ship
{
    int x;
    int y;
    
	BufferedImage ship;
    int width;
    int height;
     
	boolean visible;
    Color blue;
     
    public Ship(int x, int y)
    {
         
        this.x = x;
        this.y = y;
         
        this.width = 50;
        this.height = 50;
         
        this.blue = new Color(0,0,255);
         
 
    }
     
	
    public void drawMe(Graphics g)
    {
		
        try 
		{
			ship = ImageIO.read(new File("banana.png"));
		} 		
		catch (IOException e) {}
		g.drawImage(ship,x,y,null);
    }
    public boolean checkCollision(Enemy e)
	{
		int eX = e.getX();
		int eY = e.getY();
		int eW = e.getWidth();
		int eH = e.getHeight();
		
		if(eX + eW >= x && eX <= x+eW && eY+eH >= y && eY <= y + eH)
		{
			
			return true;
		}
		return false;
	}
    public void moveUp()
    {
		if(y >= 10)
			y -= 5;
    }
     
    public void moveDown()
    {
		if(y <= 540)
			y += 5;
    }
     
    public int getX()
    {
        return x;
    }
     
    public int getY()
    {
        return y;
    }
	public void setY(int y)
	{
		this.y = y;
	}
 
 
}