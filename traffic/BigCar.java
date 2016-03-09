import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class BigCar extends Automobile {

    public BigCar() {
        super(new Color(0,0,250),100,100);
    }
    public void drawFrame(Graphics g) {
        //override larger size frame with windows and lights
    }
    public void drawWheels(Graphics g) {
        //more detailed big wheels
    }
}
