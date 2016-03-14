import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;


public class Screen extends JPanel {
	
    private ArrayList<Automobile> cars; //main arraylist of cars
    private Color darkGreen = new Color(9,84,9);

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
        //add sports cars

        cars.add(new SportsCar(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),110));
        cars.add(new SportsCar(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),160));
        cars.add(new SportsCar(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),110));
        cars.add(new SportsCar(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),410));
        cars.add(new SportsCar(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),460));
        //add sedans
        cars.add(new Sedan(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),110));
        cars.add(new Sedan(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),160));
        cars.add(new Sedan(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),110));
        cars.add(new Sedan(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),410));
        cars.add(new Sedan(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),460));

        cars.add(new SUV(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),110));
        cars.add(new SUV(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),160));
        cars.add(new SUV(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),110));
        cars.add(new SUV(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),410));
        cars.add(new SUV(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),460));
        
        cars.add(new Truck(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),120));
        cars.add(new Truck(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),170));
        cars.add(new Truck(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),120));
        cars.add(new Truck(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),420));
        cars.add(new Truck(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250)),(int)(Math.random()*800),470));

	}
	
	public Dimension getPreferredSize() {
		Dimension windowSize = new Dimension(800,600);
		return windowSize;
	}
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//draw background
        g.setColor(darkGreen);
		g.fillRect(0,0,800,600);
		
        //off ramps
        int[] xPoints = {250,350,850,750};
        int[] yPoints = {400,450,350,250};
        g.setColor(Color.gray);
        g.fillPolygon(xPoints,yPoints,xPoints.length);
        int[] x2Points = {250,350,800,850};
        int[] y2Points = {200,150,250,350};
        g.fillPolygon(x2Points,y2Points,xPoints.length);

        drawRoad(g,0,100);
        drawRoad(g,0,400);
		//draw cars
                for(Automobile each : cars) {
            each.drawMe(g);
        }
	}
    public void drawRoad(Graphics g,int x,int y) {
        g.setColor(Color.gray);
        g.fillRect(x,y,800,100);
        g.setColor(Color.white);
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

