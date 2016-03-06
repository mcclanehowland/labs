import java.util.Scanner;

public class Runner
{	
	public static void main(String[] args)
	{
		boolean user = true;
		String input = "";
		while(user == true)
		{
		try
		{
		
			Scanner kb = new Scanner(System.in);
		
			Formulas formula = new Formulas();
		
			System.out.println("01. Area of a Triangle");
			System.out.println("02. Area of a Square");
			System.out.println("03. Area of a Rectangle");
			System.out.println("04. Area of a Circle");
			System.out.println("05. Perimeter of a Square");
			System.out.println("06. Perimeter of an Equilateral Triangle");
			System.out.println("07. Perimeter of a Regular Pentagon");
			System.out.println("08. Perimeter of a Regular Octagon");
			System.out.println("09. Perimeter of a Regular Dodecagon");
			System.out.println("10. Perimeter of a Regular Nonagon");
			System.out.println("11. Force of an Object");
			System.out.println("12. Distance an Object has traveled");
			System.out.println("13. Velocity Given Displacement and Time");
			System.out.println("14. Distance Fallen in Free Fall Given Time");
			System.out.println("15. Acceleration given velocities and time");
		
			System.out.println("please enter the number of the formula you would like to use");
			int selection = kb.nextInt();
		
			if(selection == 1)
			{
				formula.triangleArea();
			}
			else if(selection == 2)
			{
				formula.squareArea();
			}
			else if(selection == 3)
			{
				formula.rectangleArea();
			}
			else if(selection == 4)
			{
				formula.circleArea();
			}
			else if(selection == 5)
			{
				formula.squarePerimeter();
			}
			else if(selection == 6)
			{
				formula.trianglePerimeter();
			}
			else if(selection == 7)
			{
				formula.pentagonPerimeter();
			}
			else if(selection == 8)
			{
				formula.octagonPerimeter();
			}
			else if(selection == 9)
			{
				formula.dodecagonPerimeter();
			}
			else if(selection == 10)
			{
				formula.nonagonPerimeter();
			}
			else if(selection == 11)
			{
				formula.force();
			}
			else if(selection == 12)
			{
				formula.distance();
			}
			else if(selection == 13)
			{
				formula.velocity();
			}
			else if(selection == 14)
			{
				formula.freeFall();
			}
			else if(selection == 15)
			{
				formula.acceleration();
			}
			if(selection > 15)
			{
				System.out.println("please enter a number from 1-15");
			}
			System.out.println("would you like to enter another formula? y/n");
			input = kb.next();
			if(input.equals("y"))
			{
				user = true;
			}
			else if(input.equals("n"))
			{
				user = false;
			}
			else
			{
				break;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("\n\n\n****please enter a number and try again****\n\n\n");
			
		}
			
		
		}
		System.out.println("thanks for using!");
	}
}