import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;  
import java.awt.Color;
import java.awt.Graphics;

public class Animal
{
	BufferedImage animal;
	int ax,ay;
	int mx,my;
	public Animal()
	{
		ax = (int)(Math.random()*800);
		ay = (int)(Math.random()*300+300);
		mx = (int)(Math.random()*800);
		my = (int)(Math.random()*300+300);
	}
	public void drawMe(Graphics g)
	{
		try 
			{
				animal = ImageIO.read(new File("llama.png"));
			} 		
			catch (IOException e) 
			{	
			}
	g.drawImage(animal,ax,ay,null);
	}
	public void move()
	{
		
		if(ax < mx)
			ax++;
		if(ay < my)
			ay++;
		if(ax > mx)
			ax--;
		if(ay > my)
			ay--;
		if(ax == mx && ay == my)
		{
			mx = (int)(Math.random()*800);
			my = (int)(Math.random()*300+300);
		}
			
	}
	
}