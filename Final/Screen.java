import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Font;

 
 
public class Screen extends JPanel implements KeyListener
{
 
    BufferedImage buffered;
    Projectile p1;
	boolean up, down;
    Ship s1;
	boolean shoot = false;
	int counter, counter2;
	
	int bX = 800;
	int bY = (int)(Math.random()*600);
	int laserNum;
	Projectile[] lasers;
	Sound sound;
	int sx, sy;
	Enemy[] e1 = new Enemy[3];
	Enemy[] e2 = new Enemy[10];
	Enemy boss = new Enemy(3);
	int health = 100;
	int bossHealth = health;
	Font font = new Font("Arial",Font.PLAIN,50);
	Font small = new Font("Arial",Font.PLAIN,10);
 	Object[] o = new Object[1000];
	Banana[] bananas = new Banana[100];
	Banana banana = new Banana();
	Banana banana2 = new Banana();
	
	int lives = 3;
	
	
	int level = 1;
     
    public Screen()
    {
        sound = new Sound();
        s1 = new Ship(50,300);
        p1 = new Projectile(50,300);

		lasers = new Projectile[50];
		for(int i = 0; i < lasers.length;i++)
		{
			lasers[i] = new Projectile(50,-100);
		}
		for(int i = 0; i < o.length;i++)
		{
			o[i] = new Object();
		}
		for(int i = 0; i < e1.length;i++)
		{
			e1[i] = new Enemy(1);
		}
		for(int i = 0; i < e2.length;i++)
		{
			e2[i] = new Enemy(2);
		}
		int j = 0;
		int k = 0;
		for(int i = 0; i < bananas.length;i++)
		{
			bananas[i] = new Banana();
				
		}
        //sets keylistener
        setFocusable(true);
        addKeyListener(this);
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
		gBuff.setFont(font);
		if(level == 1)
			gBuff.setColor(Color.black);
		else if(level == 2)
			gBuff.setColor(Color.cyan);
		else if(level == 3)
			gBuff.setColor(Color.magenta);
		else
			gBuff.setColor(Color.green);
        gBuff.fillRect(0, 0, 800, 600);
		gBuff.setColor(Color.red);
        gBuff.drawString("Lives: "+lives,350,100);
		gBuff.drawString("Level: "+level,350,150);
		
		
		for(Object each : o)
		{
			each.drawMe(gBuff);//background
		}
		if(level == 1)//level 1
		{
			for(Enemy each : e1)
			{
				each.drawMe(gBuff);
				if(lives <= 0)
				{
					each.reset();
					each.setVisible(true);
					lives = 3;	
				}
				
			}
			int sum = 0;
			for(Enemy each : e1)
			{
				sum += each.getX();
				if(sum%(e1.length*900) == 0)
				{
					
					level++;
					for(Enemy each1 : e2)
					{
						each1.reset();
						each1.setVisible(true);
					}
				}
			}
		
			
			
		}
		if(level == 2)
		{
			gBuff.setColor(Color.blue);
			gBuff.fillOval(bX,bY,100,200);
			banana.drawComet(gBuff);
			for(Enemy each : e2)
			{
				each.drawMe(gBuff);
			}
			
			int sum = 0;
			for(Enemy each : e2)
			{
				sum += each.getX();
				if(sum%(e2.length*900) == 0 && lives > 0)
				{
					
					level++;
					bossHealth = health;
					boss.reset();
					boss.setVisible(true);
					
				}
			}
			if(lives  <= 0)
			{
				level = 1;
				for(Enemy each : e1)
				{
					each.reset();
					each.setVisible(true);
				}
			}
				
		}
		if(level == 3)
		{
			
			boss.drawMe(gBuff);
			gBuff.setColor(Color.green);
			gBuff.setFont(small);
			gBuff.drawString("Health: "+bossHealth,boss.getX(),boss.getY()-20);
			banana2.drawComet(gBuff);
			banana.drawComet(gBuff);
			if(lives  <= 0)
			{
				level = 1;
				for(Enemy each : e1)
				{
					each.reset();
					each.setVisible(true);
				}
			}
				
		}
		if(level >= 4)
		{
			counter2++;
			//you won
			gBuff.drawString("press enter to play again",350,350);
			if(counter2 %50 == 0)
				sound.playSound4();
			for(int i = 0; i < 800;i += 30)
			{
				for(int j = 0; j < 600;j  += 30)
				{
					gBuff.setFont(small);
					gBuff.setColor(Color.yellow);
					gBuff.drawString("YOU WIN",i,j);
					
				}
			}
			for(Banana each : bananas)
			{
				each.drawMe(gBuff);
			}
			
		}
		
        
			
		if(lives > 0)
			s1.drawMe(gBuff);
		if(lives <= 0)
		{
			gBuff.setColor(Color.orange);
			s1.drawMe(gBuff);
		}
			
        //Draw Projectile
		
			
		
        p1.drawMe(gBuff);
		for(Projectile each : lasers)
		{
			each.drawMe(gBuff);
		}
        
        //draw the buffered image
        g.drawImage(buffered, 0, 0, null);
 
    } 
	public void sleep(int time)
	{
		try {
                Thread.sleep(time);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
	}
	public boolean Collision1(int x1,int y1,int height1,int width1, int x2, int y2, int height2, int width2)
	{
		if(x1 <= x2+width2 && x1 >= x2 && y1 <= y2 + height2 && y1 >= y2)
			return true;
		return false;
	}
	
	public void collision()
	{
		if(level == 1)
		{
			for(Enemy each : e1)
			{
				
				for(Projectile p : lasers)
				{
					each.checkCollision(p);
				}
				if(s1.checkCollision(each))
				{
					lives--;
					sound.playSound2();
					for(Enemy each1 : e1)
					{
						if(each1.getVisible() == true)
						{
							each1.reset();
							each1.setVisible(true);
						}
						
					}
				}
				if(each.checkBounds())
				{
					each.setVisible(false);
					lives--;
					s1.setY(300);
					for(Enemy each1 : e1)
					{
						if(each1.getVisible() == true)
						{
							each1.reset();
							each1.setVisible(true);
						}
						
					}
					
				}
			}
			
		}
		if(level == 2)
		{
			for(Enemy each : e2)
			{
				
				for(Projectile p : lasers)
				{
					each.checkCollision(p);
				}
				if(s1.checkCollision(each))
				{
					lives--;
					sound.playSound2();
					for(Enemy each1 : e2)
					{
						if(each1.getVisible() == true)
						{
							each1.reset();
							each1.setVisible(true);
						}
						
					}
				}
				if(each.checkBounds())
				{
					each.setVisible(false);
					lives--;
					s1.setY(300);
					for(Enemy each1 : e2)
					{
						if(each1.getVisible() == true)
						{
							each1.reset();
							each1.setVisible(true);
						}
						
					}
				}
			}
		}
		if(level == 3)
		{
			if(boss.getX() <= -20)
			{
				lives--;
				sound.playSound5();
				boss.setVisible(true);
				
				boss.reset();
			}
			for(Projectile p : lasers)
			{
				if(p.getX() >= boss.getX() && p.getX() <= boss.getX()+boss.getWidth() && p.getY() >= boss.getY() && p.getY() <= boss.getY()+boss.getHeight())
				{
					sound.playSound3();
					bossHealth--;
					p1.setX(s1.getX());
					p1.setY(s1.getY());
					p1.setVisible(false);
					p.setVisible(false);
					if(bossHealth <= 0)
					{
						level++;
						boss.setVisible(false);
						boss.setX(900);
						boss.setY(-50);
					}
					
					
				}
			}
			
			if(s1.checkCollision(boss))
			{
				//System.out.println("ship hit");
				lives--;
				sound.playSound2();
				s1.setY(300);
				
				if(lives <= 0)
				{
					level = 1;
					for(Enemy each2 : e1)
					{
						each2.reset();
						each2.setVisible(true);
					}
				}
				else
				{
					boss.reset();
				}
			}
		}
		/*for(Enemy each : e1)
		{
			/*if(Collision1(each.getX(),each.getY(),50,50,s1.getX(),s1.getY(),50,50))
			{
				//System.out.println("ship hit");
				lives--;
				sound.playSound2();
				s1.setY(300);
				for(Enemy each1 : e1)
				{
					if(each1.getVisible() == true)
					{
						each1.reset();
						each1.setVisible(true);
					}
				}
				
			}
			if(each.getX() <= s1.getX()+50 && each.getX() >= s1.getX() && each.getY() <= s1.getY()+50 && each.getY() >= s1.getY())
			{
				//System.out.println("ship hit");
				lives--;
				sound.playSound2();
				s1.setY(300);
				for(Enemy each1 : e1)
				{
					if(each1.getVisible() == true)
					{
						each1.reset();
						each1.setVisible(true);
					}
				}
				
			}
			if(each.getX() <= 0)
			{
				lives--;
				sound.playSound5();
				each.setVisible(false);
				each.setX(900);
				each.setY(-50);
			}
			for(Projectile p : lasers)
			{
				if(p.getX() >= each.getX() && p.getX() <= each.getX()+50 && p.getY() >= each.getY() && p.getY() <= each.getY()+80)
				{
					sound.playSound3();
					each.setVisible(false);
					each.setX(900);
					each.setY(-50);
					p.setVisible(false);
					
				}
			}
			
		}
		for(Enemy each : e2)
		{
			if(each.getX() <= 0)
			{
				lives--;
				sound.playSound5();
				each.setVisible(false);
				each.setX(900);
				each.setY(-50);
			}
			for(Projectile p : lasers)
			{
				if(p.getX() >= each.getX() && p.getX() <= each.getX()+50 && p.getY() >= each.getY() && p.getY() <= each.getY()+80)
				{
					sound.playSound3();
					each.setVisible(false);
					each.setX(900);
					each.setY(-50);
					p.setVisible(false);
				}
			}
			
			if(each.getX() <= s1.getX()+50 && each.getX() >= s1.getX() && each.getY() <= s1.getY()+50 && each.getY() >= s1.getY())
			{
				//System.out.println("ship hit");
				lives--;
				sound.playSound2();
				s1.setY(300);
				for(Enemy each1 : e2)
				{
					if(each1.getVisible() == true)
					{
						each1.reset();
						each1.setVisible(true);
					}
				}
				if(lives <= 0)
				{
					for(Enemy each2 : e1)
					{
						each2.reset();
						each2.setVisible(true);
					}
				}
			}
		}
		if(level == 3)
		{
			if(boss.getX() <= -20)
			{
				lives--;
				sound.playSound5();
				boss.setVisible(true);
				
				boss.reset();
			}
			for(Projectile p : lasers)
			{
				if(p.getX() >= boss.getX() && p.getX() <= boss.getX()+50 && p.getY() >= boss.getY() && p.getY() <= boss.getY()+80)
				{
					sound.playSound3();
					bossHealth--;
					p1.setX(s1.getX());
					p1.setY(s1.getY());
					p1.setVisible(false);
					p.setVisible(false);
					if(bossHealth <= 0)
					{
						level++;
						boss.setVisible(false);
						boss.setX(900);
						boss.setY(-50);
					}
					
					
				}
			}
			
			if(boss.getX() <= s1.getX()+50 && boss.getX() >= s1.getX() && boss.getY() <= s1.getY()+50 && boss.getY() >= s1.getY())
			{
				//System.out.println("ship hit");
				lives--;
				sound.playSound2();
				s1.setY(300);
				
				if(lives <= 0)
				{
					level = 1;
					for(Enemy each2 : e1)
					{
						each2.reset();
						each2.setVisible(true);
					}
				}
				else
				{
					boss.reset();
				}
			}
		}*/
		
			
		repaint();
	}
    public void animate()
    {
         
        while(true)
        {
			bX--;
			if(bX <= -100)
			{
				bX = 800;
				bY = (int)(Math.random()*550);
			}
			counter++;
			banana.move();
			banana2.move();
            //wait for .01 second
			
			sleep(10);
			if(shoot && counter%2 == 0)
			{
				sound.playSound();
				laserNum = (laserNum+1)%lasers.length;
				lasers[laserNum].setVisible(true);
				lasers[laserNum].setX(s1.getX());
				lasers[laserNum].setY(s1.getY());
				//System.out.println("shoot");
			}
			p1.moveRight();
			for(Projectile each : lasers)
			{
				each.moveRight();
			}
			if(down == true)
				s1.moveDown();
			if(up == true)
				s1.moveUp();
			for(Object each : o)
			{
				each.move();
			}
			if(level == 1)
			{
				for(Enemy each : e1)
				{
					each.move();
				}
			}
			if(level == 2)
			{
				for(Enemy each : e2)
				{
					each.move();
				}	
			}
			if(level == 3)
			{
				boss.move();
			}
			

			/*for(Enemy each : e1)
			{
				each.checkCollision(p1);
			}*/
			collision();
            //repaint the graphics drawn
            repaint();
        }
 
    }
     
    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
 
 
        //key code
        //http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes
        int key = e.getKeyCode();
		//System.out.println(key);
        if (key == 38)//Up Arrow
        {
            up = true; 
			down = false;
        }
        else if (key == 40)//Down Arrow
        {
            down = true;
			up = false;
        }
		
        if(key == 32)//spacebar
		{
			/*p1.setVisible(true);
			p1.setY(s1.getY()+20);
			p1.setX(s1.getX());
			sound.playSound();*/
			shoot = true;
		
			
			
			
			
		}
		
		else if(key == 75)
		{
			level++;
			if(level == 2)
			{
				for(Enemy each : e2)
				{
					each.reset();
					each.setVisible(true);
				}
			}
			if(level == 3)
			{
				boss.reset();
				boss.setVisible(true);
				bossHealth = health;
			}
			
			
		}
		
		else if(key == 10 && level >= 4)
		{
			level = 1;
			lives = 3;
			for(Enemy each : e1)
			{
				each.reset();
				each.setVisible(true);
			}
		}
        repaint();
 
    }
	public int getBossHealth()
	{
		return bossHealth;
	}
    public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if(key == 38)
			up = false;
		if(key == 40)
			down = false;
		if(key == 32)
			shoot = false;
		
		
	}
    public void keyTyped(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(key == 32)
		{
			System.out.println("typed");
			sound.playSound();
			laserNum = (laserNum+1)%lasers.length;
			lasers[laserNum].setVisible(true);
			lasers[laserNum].setX(s1.getX());
			lasers[laserNum].setY(s1.getY());
		}
	}
}
