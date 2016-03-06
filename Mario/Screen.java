import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
 
 
public class Screen extends JPanel implements KeyListener
{
 
    BufferedImage buffered;
	BufferedImage character;
	MainCharacter mc;
	Background1 b1;
	Background2 b2;
	boolean right = true;
	boolean j = false;
	boolean user = true;
	
	int speed = 8;
	int key;
	int cx,cy;
	
    public Screen()
    {
         mc = new MainCharacter(395,350);
		 b1 = new Background1(100,180);
		 b2 = new Background2(400,230);
		 
		 addKeyListener(this);
		 setFocusable(true);
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
		gBuff.setColor(Color.cyan);
		gBuff.fillRect(0,0,800,600);
		
		gBuff.setColor(Color.red);
		gBuff.fillRect(0,400,800,200);
		
		
		b2.drawMe(gBuff);
		b1.drawMe(gBuff);
		mc.drawMe(gBuff,right); //draw main character
		
		checkX();
        //draw the buffered image on to the main screen
        g.drawImage(buffered, 0, 0, null);
    } 
	public void checkX()
	{
		if(b1.getX() > 800)
		{
			b1.setX(-200);
		}
		if(b2.getX() > 800)
		{
			b2.setX(-230);
		}
		if(b1.getX() < -200)
		{
			b1.setX(800);
		}
		if(b2.getX() < -250)
		{
			b2.setX(800);
		}
		repaint();
	}
	public void keyPressed(KeyEvent evt)
	{
		key = evt.getKeyCode();
		
		if(key == 39)
		{
			right = true;
			b1.moveLeft();
			b2.moveLeft();
		}
		else if(key == 37)
		{
			right = false;
			b1.moveRight();
			b2.moveRight();
		}
		if(key == 32)
		{
			j = true;
		}
		repaint();
	}
	public void animate()
	{
		while(user)
		{
			int num = mc.getY();
			speed = 10;
			if(j)
			{
				int i = 0;
				while(num > 250)
				{
					mc.setY(num);
					num -= speed;
					sleep(20);
					repaint();
					i++;
					if(i%2 == 0 && speed > 2)
					{ 
						speed -= 1;
					}
				}
				while(num < 351)
				{
					mc.setY(num);
					num += speed;
					sleep(20);
					repaint();
				}
			}
		
			j = false;
			
			repaint();
		}
	}
	public void sleep(int time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
	public boolean getDirection()
	{
		return right;
	}
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}
 

}