import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
 
public class Scenery extends JPanel
{
 
    BufferedImage buffered;
 
    Color white;
	boolean twinkle, strike;
	int time = 0;
	RainDrop[] rain;
	Animal[] animals;
	Object[] objects;
	Star[] stars;
	int counter;
    Lightning l;
	 
    public Scenery()
    {
		l = new Lightning();
		l.reset();
        rain = new RainDrop[600];
		for(int i = 0; i < rain.length;i++)
		{
			rain[i] = new RainDrop();
		}
        //setup the color
        white = new Color(255,255,255);
		animals = new Animal[30];
		for(int i = 0; i < animals.length;i++)
		{
			animals[i] = new Animal();
		}
		objects = new Object[10];
		for(int i = 0; i < objects.length;i++)
		{
			objects[i] = new Object();
		}
		stars = new Star[100];
		for(int i = 0; i < stars.length;i++)
		{
			stars[i] = new Star();
		}
	
    }
     
    public Dimension getPreferredSize() 
    {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
 
     
        //Create Buffered
        if( buffered == null )
        {
            buffered = (BufferedImage)(createImage( getWidth(), getHeight() ) );
        }
         
        //Create a temporary graphics buffered to draw
        Graphics gBuff = buffered.createGraphics();
    
        //draw white background
        gBuff.setColor(Color.cyan);
        gBuff.fillRect(0,0,800,600);
		gBuff.setColor(Color.black);
        gBuff.fillRect(0,300,800,300);
		if(strike)
		{
			l.strike(gBuff);
		}
		for(Star each : stars)
		{
			each.drawMe(gBuff);
			if(twinkle == true)
				each.twinkle();
		}
		for(Object each : objects)
		{
			each.drawMe(gBuff);
		}
		for(Animal each : animals)
		{
			each.drawMe(gBuff);
		}
		for(RainDrop each : rain)
		{
			each.drawMe(gBuff);
		}
	
        //Draw the buffered image on to the main screen
        g.drawImage(buffered,0,0,null);
         
    }
 
    public void animate()
    {
        while(true)
        {
            //wait for .01 second
            sleep(10);
			for(RainDrop each : rain)
			{
				each.move();
			}
            for(Animal each : animals)
			{
				each.move();
			}
			counter++;
			if(counter%10 == 0)
				twinkle = true;
			else
				twinkle = false;
			if(counter%150 < 20 && counter%150 >= 0)
				strike = true;
			else 
			{
				l.reset();
				strike = false;
			}
				
            //repaint the graphics drawn
            repaint();
        }
 
    }
    public void sleep(int time)
	{
		try {
                Thread.sleep(time);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
	}
     
}