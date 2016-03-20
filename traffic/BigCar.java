import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class BigCar extends Automobile {

    public BigCar(Color bodyColor,double x,double y) {
        super(bodyColor,x,y);
    }
    public void drawFrame(Graphics g) {
        //override larger size frame with windows and lights
        width = 90;
        height = 30;
        super.drawFrame(g);
        g.setColor(Color.black);
        g.fillRect((int)(x+4),(int)(y+4),width/2,height/2);
        g.fillRect((int)x+52,(int)(y+4),width/3,height/2);
            }
    public void drawWheels(Graphics g) {
        //more detailed big wheels
        g.setColor(Color.black);
        g.fillOval((int)x+10,(int)y+height-10,20,20);
        g.fillOval((int)x+60,(int)y+height-10,20,20);
        g.setColor(Color.white);
        g.fillOval((int)x+14,(int)y+height-6,12,12);
        g.fillOval((int)x+64,(int)y+height-6,12,12);
    }
}
