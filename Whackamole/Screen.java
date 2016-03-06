import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
 
public class Screen extends JPanel implements MouseListener
{
    Box[] boxList;
 
	
    public Screen()
    {
		
        boxList = new Box[100];
        for(int i=0; i<boxList.length; i++)
        {
            boxList[i] = new Box();
        }
		addMouseListener(this);
    }
 
    public Dimension getPreferredSize()
    {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
 
    public void paintComponent(Graphics g)
    {
        //draw background
        g.setColor(Color.white);
        g.fillRect(0,0,800,600);
 
        //Draw Box
        for(Box each : boxList)
            each.drawMe(g);
             
    }
	public void mousePressed(MouseEvent e)
	{
		for(Box each : boxList)
		{
			each.checkHit(e.getX(),e.getY());
		}
		repaint();
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
 
 
 
     
     
     
}