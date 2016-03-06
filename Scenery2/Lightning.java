import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Lightning
{
	int x,start;
	public void strike(Graphics g)
	{
		g.setColor(Color.blue);
		
		g.drawLine(start,0,x,300);
		
		
		playSound();
		
	}
	public void reset()
	{
		start = (int)(Math.random()*800);
		x = (int)(Math.random()*800);
	}
	public void playSound()
    {
          
         try
         {
            URL url = this.getClass().getClassLoader().getResource("cat_screech2.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
         }
         catch (Exception exc)
         {
             exc.printStackTrace(System.out);
         }
    }
}