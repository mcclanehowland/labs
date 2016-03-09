import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;


public class Screen extends JPanel {
	
    private ArrayList<Automobile> cars; //main arraylist of cars

	public Screen() {
        /*roads are positioned at 
            (0,100)
            (0,400)
            place cars at 
            (x,120)
            (x,170) ?
            (x,420)
            (x,470) ?
        */
        cars = new ArrayList<Automobile>();
        cars.add(new SmallCar(Color.cyan,0,120));
	}
	
	public Dimension getPreferredSize() {
		Dimension windowSize = new Dimension(800,600);
		return windowSize;
	}
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//draw background
		g.setColor( Color.white );
		g.fillRect(0,0,800,600);
		
		//draw cars
        drawRoad(g,0,100);
        drawRoad(g,0,400);
        for(Automobile each : cars) {
            each.drawMe(g);
        }
	}
    public void drawRoad(Graphics g,int x,int y) {
        g.setColor(Color.gray);
        g.fillRect(x,y,800,100);
        g.setColor(Color.yellow);
        for(int i = x;i < 800;i += 60) {
            g.fillRect(i,y+45,30,10);
        }
    }
    public void animate() {
        while(true) {
            sleep(1000/60);
            for(Automobile each : cars) {
                each.move();
            }
            repaint();
        }
    }
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

