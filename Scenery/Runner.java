import javax.swing.JFrame;
import java.util.Scanner;
 
public class Runner
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Scenery");
        Scanner kb = new Scanner(System.in);
         
        System.out.println("1-Day or 2-Night");
        int background = kb.nextInt();
		System.out.println("1-Cloudy or 2-Clear skies");
		int sky = kb.nextInt();
        Scenery sc = new Scenery(background, sky);
         
         
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
		
		sc.animate();
		
		
		
    }
 
}