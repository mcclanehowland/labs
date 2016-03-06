import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class FormulasGraphics extends JPanel 
{
    int type; 
	double answer;
	String name = "";
	
	public FormulasGraphics(String name)
	{
		this.name = name;
	}
    public Dimension getPreferredSize()
    {
        return new Dimension(800,600);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
		Color green = new Color(59,101,61);
		Font font = new Font("Chalkboard", Font.PLAIN, 50);
		boolean user = true;
	
		g.setColor(green);
		g.fillRect(0,0,800,600);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString(name, 10, 50);

		switch (type)
		{
		case 1:
			g.drawString("Area of a Triangle", 100,100);
			g.drawString("Answer: "+answer, 100, 200);break;
		case 2:
			g.drawString("Area of a Square",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 3:
			g.drawString("Area of a Circle",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 4:
			g.drawString("Volume of a Cube",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 5:
			g.drawString("Volume of a Sphere",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 6:
			g.drawString("Volume of a Cone",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 7:
			g.drawString("Volume of a Cylinder",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 8:
			g.drawString("Surface Area of a Cube",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 9:
			g.drawString("Surface Area of a Sphere",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 10: 
			g.drawString("Hypotenuse of a Right Triangle",100,100);
			g.drawString("Answer: "+answer,100,200);break;
		case 11:
			g.drawString("Please enter a number less ",100,100);
			g.drawString("than 10",100,150);
			
		}
		
	
    }
	public void processFormulas(int type, double answer)
	{
		this.type = type;
		this.answer = answer;
		repaint();
	}
	
}