import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
 
 
 
public class Screen extends JPanel 
{
 
    BufferedImage buffered;
    CropField1 cf1;
	CropField2 cf2;
	CropField3 cf3;
	boolean user = true;
	int counter = 1;
	int background = 0;
	int x;
	int y;
	int moonX;
	int moonY;
	double moonTheta;
	double moonTime = 0.6;
	double theta;
	double time = 0.6;
	Color brown = new Color(205,133,63);
    public Screen()
    {
        //sets up the instance variables        
		cf1 = new CropField1(5,300);
		cf2 = new CropField2(290,300);
		cf3 = new CropField3(575,300);
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
     
        //Clear everything
        //This draws the white box
		if(background == 0) //night/day
			gBuff.setColor(Color.cyan);
		if(background == 1)
			gBuff.setColor(Color.black);
        
		gBuff.fillRect(0, 0, 800, 600); //background
		gBuff.setColor(Color.yellow); //sun
		gBuff.fillOval(x+380,y+550,100,100);
		
		gBuff.setColor(Color.gray); //moon
		gBuff.fillOval(moonX+380,moonY+550,100,100);
		gBuff.setColor(brown);
        gBuff.fillRect(0,200,800,400);
		cf1.drawMe(gBuff);
		cf2.drawMe(gBuff);
		cf3.drawMe(gBuff);
		g.setColor(Color.blue);
		drawText(gBuff);
		
		
        //draw the buffered image on to the main screen
        g.drawImage(buffered, 0, 0, null);
 
    } 
	public void drawText(Graphics g)
	{
		g.drawString("Day: "+cf1.getCounter(),350,100);
	}
    public void animate()
    {
       
        while(true)
        {
			counter++;
			
			if(counter % 2 == 0)
			{
				background = 0;
				
				cf1.grow(); 
				cf2.grow();
				cf3.grow();
				for(int i = 0; i < 20;i++)
				{
					sleep(50);
					
					time += 0.015;
					theta = 2 * Math.PI * time;
					x = (int) (500 * Math.cos(theta));
					y = (int) (500 * Math.sin(theta));
					repaint();
					
				}
				time = 0.6;
			}
			else if(counter % 2 != 0)
			{
				background = 1;
				repaint();
				for(int i = 0; i < 20; i++)
				{
					sleep(50);
					
					moonTime += 0.015;
					moonTheta = 2 * Math.PI * moonTime;
					moonX = (int) (500 * Math.cos(moonTheta));
					moonY = (int) (500 * Math.sin(moonTheta));
					repaint();
					
				}
				moonTime = 0.6;
			}
	
            repaint();
        }

    }
	
	
		
		
	
	public void sleep(int time)
	{
		try{
                Thread.sleep(time);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
	}
     
}