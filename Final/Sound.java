import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Sound
{
	int x,start;
	/*public void strike(Graphics g)
	{
		g.setColor(Color.blue);
		
		g.drawLine(start,0,x,300);
		
		
		playSound();
		
	}*/
	public void reset()
	{
		start = (int)(Math.random()*800);
		x = (int)(Math.random()*800);
	}
	public void playSound()
    {
          
         try
         {
            URL url = this.getClass().getClassLoader().getResource("cannon_x.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
         }
         catch (Exception exc)
         {
             exc.printStackTrace(System.out);
         }
    }
	public void playSound2()
    {
          
         try
         {
            URL url = this.getClass().getClassLoader().getResource("boing_x.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
         }
         catch (Exception exc)
         {
             exc.printStackTrace(System.out);
         }
    }
	public void playSound3()
    {
          
         try
         {
            URL url = this.getClass().getClassLoader().getResource("boom_x.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
         }
         catch (Exception exc)
         {
             exc.printStackTrace(System.out);
         }
    }
	public void playSound4()
    {
          
         try
         {
            URL url = this.getClass().getClassLoader().getResource("cymbals.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
         }
         catch (Exception exc)
         {
             exc.printStackTrace(System.out);
         }
    }
	public void playSound5()
    {
          
         try
         {
            URL url = this.getClass().getClassLoader().getResource("floop2_x.wav");
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