import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Truck extends BigCar {
    public Truck(Color bodyColor,double x,double y) {
        super(bodyColor,x,y);
        speed = 0.55+Math.random()*0.2;
    }
    public void drawFrame(Graphics g) {
        //two door frame with bed
        g.setColor(bodyColor);
        g.fillRect((int)x,(int)y,50,20);
        g.fillRect((int)x+50,(int)y-10,30,30);
        g.setColor(Color.black);
        g.drawRect((int)x+60,(int)y,18,19);
        g.fillRect((int)x+52,(int)y-9,25,13);
    }
}
