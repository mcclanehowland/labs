import java.awt.Graphics;
import java.awt.Color;
 
public class Box
{
    int x;
    int y;
    int width;
    int height;
	boolean visible;
    Color red;
 
     
     
    public Box()
    {
        x = (int)(Math.random()*750);
        y = (int)(Math.random()*550);
        width = 50;
        height = 50;
        red = new Color(255,0,0);   
		visible = true;
    }
     
 
     
    public void drawMe(Graphics g)
    {
		if(visible)
		{
			g.setColor(red);
			g.fillRect(x,y,width,height);
		}
        
         
    }
	public void checkHit(int mX, int mY)
	{
		if(mX >= x && mX <= x+width && mY >= y && mY <= y+height && visible)
		{
			visible = false;
		}
	}
         
 
}