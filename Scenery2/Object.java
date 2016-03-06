import java.awt.Color;
import java.awt.Graphics;

public class Object
{
	int x,y;
	//int x = 300;
	//int y = 300;
	public Object()
	{
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*200+400);
	}
	public void drawMe(Graphics g)
	{
		int[] xpoints = {x-1,    x-1,    x-5,   x-44,   x-45,   x-39,   x-21,   x-11, x+7,    x+11,    x+30,    x+49,    x+66,    x+79,    x+89,    x+89, x+84,    x+77,    x+68,    x+55,    x+40,    x+27};
		int[] ypoints = {y+0,     y+0,   y-84,  y-120,  y-165,  y-182,  y-199,  y-204, y-208,  y-212,  y-217,  y-214,  y-201,  y-187,  y-175,  y-157,y-139,  y-123,  y-104,   y-93,   y-84,   y-82};
		g.setColor(Color.green);
		g.fillPolygon(xpoints,ypoints,22);
	}
}