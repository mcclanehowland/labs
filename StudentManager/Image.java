import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;  
import java.awt.Color;
import java.awt.Graphics;

public class Image
{
	BufferedImage banana;
		
	public Image()
	{
		
	}
	public void drawMePNG(Graphics g, String name,int x, int y)
	{
		try 
		{
			banana = ImageIO.read(new File(name+".png"));
		} 		
		catch (IOException e) 
		{	
		}
		
		g.drawImage(banana,x,y,null);
		//System.out.print("("+x+","+y+")");
	}
    public void drawMeJPEG(Graphics g, String name)
    {
        		try 
		{
			banana = ImageIO.read(new File(name+".png"));
		} 		
		catch (IOException e) 
		{	
		}
		
    }


}
