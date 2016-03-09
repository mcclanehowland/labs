import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class MediumCar extends Automobile {
    public MediumCar() {
        super(new Color(0,0,200),100,400);
    }
    public void drawFrame(Graphics g) {
        //lights and windows
    }
    public void drawWheels(Graphics g) {
        //more detailed wheels (hubcap)
    }
}
