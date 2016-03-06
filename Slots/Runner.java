import javax.swing.JFrame;
import java.util.Scanner;

public class Runner
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Slots");
        Screen s = new Screen();
        frame.add(s);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(s);
		s.addMouseListener(s);
		
		s.animate();
	}
}