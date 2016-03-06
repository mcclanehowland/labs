import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.Random;

public class Screen extends JPanel implements MouseListener, KeyListener
{
	Random r = new Random();
	int x,y,a;
	int interval;
	int num;
	int spacex = 0;
	int spacey = 350;
	int starNum = 250;
	int xspeed = 3;
	int yspeed = 3;
	int state1;
	int state2 = 1;
	int state3;
	int cometx = 850;
	int comety = 0;
	int manx = r.nextInt(300)+1;
	int many = -300;
	int manxspeed = r.nextInt(5)+1;
	int manyspeed = r.nextInt(5)+1;
	int mousex,mousey;
	int cx = 350;
	int cy = 350;
	int alienx = 350;
	int alieny = 350;
	int[] starx = new int[starNum];
	int[] stary = new int[starNum];
	boolean user = true;
	
	int cometAngle = r.nextInt(9)+1;
	private BufferedImage bufferedImage;
	Color water = new Color(17,140,235);
	
	public Screen()
	{
		setPosition();
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
		
		gbuffered.setColor(Color.BLACK);
		gbuffered.fillRect(0, 0, 800, 600);
		for(int i = 0; i < starNum; i++)
		{
			gbuffered.setColor(Color.white);
			gbuffered.fillRect(starx[i],stary[i],10,10);
		}
		drawComet(gbuffered);
		drawShip(gbuffered);
		drawAlien(gbuffered);
		drawMan(gbuffered);

		g.drawImage(bufferedImage, 0, 0, null);	
	}
	public void drawMan(Graphics g)
	{
		g.setColor(Color.white);
		int xpoints2[] = {manx+15,manx+15,manx+10,manx+10,manx,manx,manx+65,manx+65,manx+55,manx+55,manx+50,manx+50,manx+35,manx+35,manx+30,manx+30};
		int ypoints2[] = {many+500,many+435,many+435,many+460,many+460,many+420,many+420,many+460,many+460,many+435,many+435,many+500,many+500,many+470,many+470,many+500};
		int npoints2 = 16;
		g.fillPolygon(xpoints2, ypoints2, npoints2);
		g.setColor(Color.yellow);
		g.fillOval(manx+15,many+390,30,30);
		g.setColor(Color.red);
		g.fillRect(manx,many+450,10,5);
		g.fillRect(manx+55,many+450,10,5);
		g.fillRect(manx+15,many+487,15,10);
		g.fillRect(manx+35,many+487,15,10);
	}
	public void drawComet(Graphics g)
	{
		//trails
		g.setColor(Color.orange);
		for(int i = 5;i < 105; i += 5)
		{
			
			g.drawLine(cometx+i,comety+50,cometx+300,comety-600);
		}
		
		//body
		g.setColor(Color.GRAY);
		g.fillOval(cometx,comety,100,100);
		
		//dimples
		g.setColor(Color.black);
		g.fillOval(cometx+20,comety+30,20,20);
		g.fillOval(cometx+40,comety+40,15,15);
		g.fillOval(cometx+60,comety+80,10,10);
		g.fillOval(cometx+70,comety+60,25,25);
		g.fillOval(cometx+70,comety+18,10,10);
		g.fillOval(cometx+20,comety+30,20,20);
		g.fillOval(cometx+40,comety+20,15,15);
		g.fillOval(cometx+60,comety+90,10,10);
		g.fillOval(cometx+15,comety+50,25,25);
		g.fillOval(cometx+20,comety+19,10,10);
	}
	public void drawShip(Graphics g)
	{
		int[] xpoints = {spacex, spacex + 50, spacex + 25,spacex};
		int[] ypoints = {spacey + 200, spacey + 200,spacey + 250,spacey+200};
		int npoints = 4;
		g.setColor(Color.green);
		g.fillRect(spacex,spacey,50,200);
		g.setColor(Color.blue);
		g.fillRect(spacex-25,spacey+100*state2+state1,50,100);
		g.fillRect(spacex+25,spacey+100*state2+state1,50,100);
		g.setColor(Color.red);
		g.fillRect(spacex-50,spacey+150*state2+state1+state3,50,50);
		g.fillRect(spacex+50,spacey+150*state2+state1+state3,50,50);
		g.fillRect(spacex-60,spacey+120*state2+state1,20,110);
		g.fillRect(spacex+90,spacey+120*state2+state1,20,110);
		//g.setColor(Color.orange);
		//g.fillPolygon(xpoints,ypoints,npoints);
	}
	public void drawAlien(Graphics g)
	{
		g.setColor(Color.green);
		
		g.fillOval(alienx-15,alieny-70,50,70);
		g.setColor(Color.black);
		g.fillOval(alienx-5,alieny-50,10,20);
		g.fillOval(alienx+20,alieny-50,10,20);
		g.fillRect(alienx,alieny-20,20,5);
		g.setColor(Color.gray);
		g.fillOval(alienx-90,alieny,200,50);
		g.setColor(Color.white);
		g.drawArc(alienx-40,alieny-85,100,180,0,180);
		
		g.drawLine(alienx,alieny,mousex,mousey);
		//g.drawLine(spacex,spacey,manx+10,many+420);
		//g.drawLine(alienx,alieny,spacex,spacey);
		//g.drawLine(manx+10,many+420,alienx,alieny);
		//g.drawLine(manx+10,many+420,cometx+50,comety+50);
		//g.drawLine(alienx,alieny,cometx+50,comety+50);
		//g.drawLine(spacex,spacey,cometx+50,comety+50);
		
	}
	public void setPosition()
	{
		for(int i = 0; i < starx.length; i++)
		{
			starx[i] = r.nextInt(800);
			stary[i] = r.nextInt(600);
		}
	}
	public void animate()
	{
		while(user)
		{
			if(spacex >= 800)
			{
				xspeed *= -1;
				yspeed *= -1;
				state1 = 100;
				state2 = -1;
				state3 = 50;
			}
			if(spacex < -50)
			{
				xspeed *= -1;
				yspeed *= -1;
				state1 = 0;
				state2 = 1;
				state3 = 0;
			}
			if(comety > 1000 || cometx < -150)
			{
				comety = -50;
				cometx = r.nextInt(800);
				cometAngle = r.nextInt(9)+1;
				repaint();
			}
			if(manx < 0 || manx > 750)
			{
				manxspeed *= -1;
			}
			if(many < -400 || many > 100)
			{
				manyspeed *= -1;
			}
			if(mousex > alienx)
			{
				alienx += 2;
			}
			if(mousex < alienx)
			{
				alienx -= 2;
			}
			if(mousey < alieny)
			{
				alieny -= 2;
			}
			if(mousey > alieny)
			{
				alieny += 2;
				
			}
			
			
			
			manx += manxspeed;
			many += manyspeed;
			spacex += xspeed;
			spacey -= yspeed;
			cometx--;
			comety += cometAngle;
			repaint();
			sleep(10);
			
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
	public void mousePressed(MouseEvent e)
	{
		mousex = e.getX();
		mousey = e.getY();
	}
	public void keyPressed(KeyEvent evt)
	{
		int key = evt.getKeyCode();
	}
	public void mouseReleased(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
	
	public void mouseClicked(MouseEvent e){}
	
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}
	/*try 
	{
		Thread.sleep(2500);
	} 
    catch(InterruptedException ex) 
	{
		Thread.currentThread().interrupt();
	}*/
}