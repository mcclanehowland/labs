import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class SUV extends BigCar {
    public SUV(Color bodyColor,double x, double y){
        super(bodyColor,x,y);
        speed = 0.9+Math.random()*0.2;
    }
    public void drawFrame(Graphics g) {
        super.drawFrame(g);
        g.setColor(Color.black);
        g.drawRect((int)x+30,(int)y+10,20,height-12);
        g.drawRect((int)x+50,(int)y+10,20,height-12);
        g.setColor(Color.yellow);
        g.fillOval((int)x+width-5,(int)y+10,10,10);

        //4 door frame
    }
}
