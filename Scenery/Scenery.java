import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.Random;

public class Scenery extends JPanel
{
    int background, sky;
	int a = 1;
	int trunkx = 35;
	int leafx = 0;
	int suny = 1;
	int sunx = 1;
	int grassx = 1;
	boolean animation = true;
	
	
	
	
     
    public Scenery(int background, int sky)
    {
        this.background = background;
		this.sky = sky;
    }
 
    public Dimension getPreferredSize()
    {
        return new Dimension(800, 600);
    }
     
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
         
		
		
        Color darkBlue = new Color(24, 42, 132);
        Color lightBlue = new Color(108, 206, 209);
		Color brown = new Color(101, 71, 12);
		Color darkGreen = new Color(27, 122, 7);
		Color sunset = new Color(96, 85, 196);
		Color sunrise = new Color(215, 182, 16);
		Color skin = new Color(249, 240, 198);

        //Draw day
        if(background == 1)
        {
            g.setColor(lightBlue);
            g.fillRect(0,0,800,600);
			
        }
        //Draw night
        else if(background == 2)
		{
			g.setColor(darkBlue);
            g.fillRect(0,0,800,600);
			suny = 600;
			
		
		}
		//Draw sunset (hopefully)
		else if(background == 3)
        {
            g.setColor(darkBlue);
			g.fillRect(0,0,800,600);
			
        }
		//draw sunrise
		else if(background == 4)
		{
			g.setColor(sunrise);
			g.fillRect(0,0,800,600);
		}
		
		g.setColor(Color.yellow);
		g.fillOval(sunx, suny, 100, 100);
		
		if(sky == 1)
		{
			g.setColor(Color.white);
			g.fillOval(0, 50, 125, 100);
			g.fillOval(50, 10, 125, 100);
			g.fillOval(100, 50, 125, 100);
			
			g.fillOval(275, 75, 125, 100);
			g.fillOval(325, 35, 125, 100);
			g.fillOval(375, 75, 125, 100);
			
			g.fillOval(550, 55, 125, 100);
			g.fillOval(600, 15, 125, 100);
			g.fillOval(650, 55, 125, 100);
		}
		else
		{
			
		}
		
		
		
		trunkx = 35;
		leafx = 0;
		for(a = 0; a < 8; a++)
		{
			
			g.setColor(brown);
			g.fillRect(trunkx, 375, 30, 125);
			
			trunkx = trunkx + 120;
			
			g.setColor(darkGreen);
			g.fillOval(leafx, 325, 100, 100);
			leafx = leafx + 120;
		}
		
		g.setColor(Color.green);
		g.fillRect(0, 500, 800, 100);
		
		a = 1;
		g.setColor(darkGreen);
		grassx = 0;
		while(a < 700)
		{
			g.fillRect(grassx, 490, 4, 10);
			grassx = grassx + 10;
			a++;
			
		}
	
		
		
		
		int xpoints[] = {100, 100, 300, 300, 200, 100};
		int ypoints[] = {300, 500, 500, 300,  200, 300};
		int npoints = 5;
		g.setColor(Color.gray);
		g.fillPolygon(xpoints, ypoints, npoints);
		
		g.setColor(Color.black);
		g.fillRect(150, 400, 50, 100);
		
		g.fillRect(250, 200, 25, 75);
		
		
		int zpoints[] = {100, 200, 300};
		int apoints[] = {300, 200, 300};
		npoints = 3;
		g.fillPolygon(zpoints, apoints, npoints);
		
		g.setColor(darkGreen);
		g.fillRect(450, 450, 10, 50);
		g.setColor(Color.pink);
		g.fillOval(430, 430, 30, 30);
		g.fillOval(445, 415, 30, 30);
		g.fillOval(460, 430, 30, 30);
		g.fillOval(445, 445, 30, 30);
		
		g.setColor(Color.yellow);
		g.fillOval(450, 435, 20, 20);
		
		
		g.fillRect(550, 440, 200, 55);
		
		g.setColor(Color.black);
		g.fillOval(565, 475, 50, 50);
		g.fillOval(690, 475, 50, 50);
		g.fillRect(730, 440, 20, 20);
		
		int carxpoints[] = {565, 600, 650, 690};
		int carypoints[] = {445, 400, 400, 445};
		int carnum = 4;
		g.fillPolygon(carxpoints, carypoints, carnum);
		
		g.setColor(Color.yellow);
		g.fillRect(625, 400, 10, 45);
		g.fillRect(600, 400, 60, 10);
		
		
		
		g.setColor(brown);
		g.fillRect(400, 375, 30, 125);

		g.setColor(darkGreen);
		g.fillOval(365, 325, 100, 100);
		
		g.setColor(darkGreen);
		g.fillRect(330, 375, 6, 125);
		
		g.setColor(Color.yellow);
		int[] sunflowerx = {340,310,315};
		int[] sunflowery = {375,400,350};
		g.fillPolygon(sunflowerx, sunflowery,3);
		
		
		//person
		g.setColor(skin); 
      int xpoints2[] = {500,500,495,495,485,485,550,550,540,540,535,535,520,520,515,515};
      int ypoints2[] = {500,435,435,460,460,420,420,460,460,435,435,500,500,470,470,500};
      int npoints2 = 16;
      g.fillPolygon(xpoints2, ypoints2, npoints2);
	  g.fillOval(500,390,30,30);
		
		
			
	}
	
	public void animate()
    {
        while(animation == true)
        {
			
            try 
			{
                Thread.sleep(5);
            } 
			catch(InterruptedException ex) 
			{
                Thread.currentThread().interrupt();
            }
 
           
		  if(suny <= 600)
		  {
			  suny++;
			  
			 if(suny > 599)
			 {
				 background = 3;
				 repaint();
				//System.out.println(background);
				//System.out.println(suny);
				  try 
				  {
						Thread.sleep(2500);
			      } 
				  catch(InterruptedException ex) 
				  {
						Thread.currentThread().interrupt();
				  }
				  
			 }
			  
			  
			  
			 
		  }
		  if(suny > 600)
		  {
			 
				 
			  for(int up = 600; up >= 1; up--)
			  {
				  
				  suny--;
				  
				try 
				{
					Thread.sleep(5);
				} 
				catch(InterruptedException ex) 
				{
					Thread.currentThread().interrupt();
				}
				repaint();
				if(suny > 500)
				{
					background = 4;
				}
				if(suny < 500)
				{
					background = 1;
				}
				if(suny == 1) //stay in daytime
				{
					try 
					{
						Thread.sleep(5000);
					} 
					catch(InterruptedException ex) 
					{
						Thread.currentThread().interrupt();
					}
				}
			  }
		  }
		  
		  
		  
           
            repaint();
        }
		
 
    }
	
	
	
}