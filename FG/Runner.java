import javax.swing.JFrame;
import java.util.Scanner;
public class Runner
{
    public static void main(String[] args)
    {
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter your name");
		String name = kb.next();
        JFrame frame = new JFrame("Formulas");
        FormulasGraphics fg = new FormulasGraphics(name);
        frame.add(fg);
		
		
		boolean user = true;
		while(user)
		{
		System.out.println("01- Area of a triangle");
		System.out.println("02- Area of a Square");
		System.out.println("03- Area of a Circle");
		System.out.println("04- Volume of a Cube");
		System.out.println("05- Volume of a Sphere");
		System.out.println("06- Volume of a Cone");
		System.out.println("07- Volume of a Cylinder");
		System.out.println("08- Surface Area of a Cube");
		System.out.println("09- Surface Area of a Sphere");
		System.out.println("10- Hypotenuse Length of a Right Triangle");
		int selection = kb.nextInt();
		double answer;
		switch(selection)    
		{
		case 1:
			System.out.println("Enter in a base");
			double base = kb.nextDouble();
			System.out.println("Enter ina height");
			double height = kb.nextDouble(); 
			answer = .5 * base * height;
			fg.processFormulas(selection, answer);break;
		case 2:
			System.out.println("enter the side length of your square");
			double length = kb.nextDouble();
			answer = Math.pow(length, 2);
			fg.processFormulas(selection, answer);break;
		case 3:
			System.out.println("enter the radius of your circle");
			double radius = kb.nextDouble();
			answer = 3.14 * Math.pow(radius, 2);
			fg.processFormulas(selection, answer);break;
		case 4:
			System.out.println("enter the side length of your cube");
			length = kb.nextDouble();
			answer = Math.pow(length, 3);
			fg.processFormulas(selection, answer);break;
		case 5:
			System.out.println("enter the radius of your sphere");
			radius = kb.nextDouble();
			answer = 4.0/3.0 * 3.14 * Math.pow(radius, 3);
			fg.processFormulas(selection, answer);break;
		case 6:
			System.out.println("enter the radius of your cone");
			radius = kb.nextDouble();
			System.out.println("enter the height of your cone");
			height = kb.nextDouble();
			answer = (1.0/3.0) * 3.14 * Math.pow(radius,2) * height;
			fg.processFormulas(selection, answer);break;
		case 7:
			System.out.println("enter the radius of your cylinder");
			radius = kb.nextDouble();
			System.out.println("enter the height of your cylinder");
			height = kb.nextDouble();
			answer = (3.14 * Math.pow(radius, 2))*height;
			fg.processFormulas(selection, answer);break;
		case 8:
			System.out.println("enter the side length of your cube");
			length = kb.nextDouble();
			answer = 6 * Math.pow(length, 2);
			fg.processFormulas(selection, answer);break;
		case 9:
			System.out.println("enter the radius of your sphere");
			radius = kb.nextDouble();
			answer = 4 * 3.14 * Math.pow(radius, 2);
			fg.processFormulas(selection, answer);break;
		case 10:
			System.out.println("side a=?");
			double a = kb.nextDouble();
			System.out.println("side b=?");
			double b = kb.nextDouble();
			answer = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
			fg.processFormulas(selection, answer);break;
		}
	
		if(selection > 10)
		{
			selection = 11;
			answer = 0;
			fg.processFormulas(selection, answer);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
		
		System.out.println("would you like to continue?(y/n)");
		
		if(kb.next().equals("y"))
		{
			user = true;
		}
		else
		{
			user = false;
		}
		
		fg.repaint();
		
		}
		
		
		
    }
}