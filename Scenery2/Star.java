import java.awt.Color;
import java.awt.Graphics;

public class Star
{
	int sx,sy;
	int size = 10;
	public Star()
	{
		sx = (int)(Math.random()*800);
		sy = (int)(Math.random()*290);
	}
	public void drawMe(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(sx,sy,size,size);
		
	}
	public void twinkle()
	{
		if(size == 10)
			size -= 5;
		else if(size == 5)
			size += 5;
	}
}