import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class SportsCar extends MediumCar{
    public SportsCar(Color bodyColor,int x,int y) {
        super(bodyColor,x,y);
    }
    public void drawFrame(Graphics g) {
        //overrides and draws two door frame
        super.drawMe(g);
    }
}
