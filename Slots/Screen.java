import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class Screen extends JPanel implements MouseListener, KeyListener
{
	
	SlotMachine m;
	boolean animate = false;
	private BufferedImage bufferedImage;
	int x,y;
	int lx = 500;
	int ly = 200;
	
	
	public Screen()
	{
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		m = new SlotMachine(100);
	}
    public Dimension getPreferredSize()
    {
        return new Dimension(800,600);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
		
		if(bufferedImage==null)
        bufferedImage = (BufferedImage)(createImage(getWidth(),getHeight())); 
		Graphics gbuffered = bufferedImage.createGraphics(); 
		gbuffered.setColor(Color.cyan);
		gbuffered.fillRect(0, 0, 800, 600);
		
		m.drawMe(gbuffered);
		buttons(gbuffered);
		
		g.drawImage(bufferedImage, 0, 0, null);		
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
	public void buttons(Graphics g)
	{
		g.setColor(Color.blue);
		g.draw3DRect(50,500,50,50,true);
		g.drawString("1",60,530);
		g.draw3DRect(150,500,50,50,true);
		g.drawString("5",170,540);
		g.draw3DRect(250,500,50,50,true);
		g.drawString("10",260,530);
		g.draw3DRect(lx,ly,50,50,true);
		g.drawString("play",lx+20,ly+20);
		
	}
	public void animate()
	{
		while(true)
		{
			if(animate)
			{
				for(int i = 0;i < 250; i++)
				{
					sleep(5); //move the play button
					if(i < 125)
						ly += 2;
					if(i >= 125)
						ly -= 2;
					repaint();
				}
				animate = false;
			}
		}
	}
	public void mousePressed(MouseEvent e)
	{
		x = e.getX();
		y = e.getY(); //check if the mouse cursor is in the area
		if(x >= 50 && x <= 100 && y >= 500 && y <= 550)
			m.bet(1);
		if(x >= 150 && x <= 200 && y >= 500 && y <= 550)
			m.bet(5);
		if(x >= 250 && x <= 300 && y >= 500 && y <= 550)
			m.bet(10);
		if(x >= 500 && x <= 550 && y >= 200 && y <= 250)
		{
			m.play();
			animate = true;
		}
		repaint();
	}
	public void keyPressed(KeyEvent evt)
	{
		int key = evt.getKeyCode();
		//System.out.println(key);
		if(key == 49)
			m.bet(1);
		if(key == 50)
			m.bet(5);
		if(key == 51)
			m.bet(10);
		if(key == 32)
		{
			m.play();
			animate = true;
		}
		repaint();
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}
}