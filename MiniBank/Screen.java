import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Screen extends JPanel
{
	String name = "";
	double balance = 0;
	
	public Dimension getPreferredSize()
    {
        return new Dimension(800,600);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
		Font font = new Font("Chalkboard", Font.PLAIN, 50);
		g.setColor(Color.blue);
		g.fillRect(0,0,800,600);
		g.setColor(Color.green);
		g.fillRect(0,0,700,500);
		g.setColor(Color.white);
		g.fillRect(0,0,600,400);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString(name,100,100);
		g.drawString(""+balance,100,200);
	}
	public void updateScreen(String name, double balance)
	{
		this.name = name;
		this.balance = balance;
		repaint();
	}
}