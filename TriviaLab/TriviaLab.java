import java.util.Scanner;
import java.util.Random;

public class TriviaLab
{
	public static void main(String[] args)
	{
		int score = 0;
		Scanner keyboard = new Scanner(System.in);
		Random numgenerator1 = new Random();
		Random numgenerator2 = new Random();
		Random numgenerator3 = new Random();
		
		System.out.println("Choose 'Math' or 'Geography'");
		String category = keyboard.nextLine();
		//math
		if(category.equals("Math"))
		{
			
			int length1 = numgenerator1.nextInt(10) + 1;
			System.out.println("what is the area of a square with side lengths "+length1);
			int answer = keyboard.nextInt();
			if(answer == length1 * length1)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			length1 = numgenerator1.nextInt(10) + 1;
			int length2 = numgenerator2.nextInt(10) + 1;
			System.out.println("What it the area of a rectangle with side lengths "+length1+" and "+length2);
			answer = keyboard.nextInt();
			if(answer == length1 * length2)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			length1 = numgenerator1.nextInt(10) + 1;
			length2 = numgenerator2.nextInt(10) + 1;
			int length3 = numgenerator3.nextInt(10) + 1;
	
			System.out.println("What is the volume of a box with side lengths of " + length1+", "+length2+", and "+length3);
			answer = keyboard.nextInt();
			if(answer == length1 * length2 * length3)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			
			length1 = numgenerator1.nextInt(10) + 1;
			
			System.out.println("what is the volume of a cube with side length "+length1);
			answer = keyboard.nextInt();
			if(answer == length1 * length1 * length1)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			
			length1 = numgenerator1.nextInt(10) + 1;
			System.out.println("What is the perimeter of a square with side length "+length1);
			answer = keyboard.nextInt();
			if(answer == length1 * 4)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			
			length1 = numgenerator1.nextInt(10) + 1;
			length2 = numgenerator2.nextInt(10) + 1;
			System.out.println("What is the perimeter of a rectangle with side lengths "+length1 + " and "+length2);
			answer = keyboard.nextInt();
			if(answer == (2*length1) + (2*length2))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			length1 = numgenerator1.nextInt(10) + 1;
			System.out.println("What is the perimeter of an equilateral triangle with side lengths of "+length1);
			answer = keyboard.nextInt();
			if(answer == length1 * 3)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			length1 = numgenerator1.nextInt(10)+1;
			System.out.println("What is the perimeter of a regular octagon with side lengths of "+length1);
			answer = keyboard.nextInt();
			if(answer == length1 * 8)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			length1 = numgenerator1.nextInt(10)+1;
			System.out.println("What is the area of a regular pentagon with sidelengths of "+length1);
			answer = keyboard.nextInt();
			if(answer == length1 * 5)
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			length1 = numgenerator1.nextInt(10)+1;
			System.out.println("What is the perimeter of a regular hexagon with side lengths of "+length1);
			answer = keyboard.nextInt();
			if(answer == length1 * 6)
				{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("your score is: " +score+ "/10");
		}
		//geography
		if(category.equals("Geography"))
		{
			System.out.println("What is the capital of California?");
			String capital = keyboard.nextLine();
			if(capital.equals("Scaramento"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("what is the capital of New Mexico?");
			capital = keyboard.nextLine();
			if(capital.equals("Santa Fe"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What is the Capital of Alabama?");
			capital = keyboard.nextLine();
			if(capital.equals("Montgomery"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What is the capital of Ohio?");
			capital = keyboard.nextLine();
			if(capital.equals("Columbus"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What country is North of the USA?");
			String country = keyboard.nextLine();
			if(country.equals("Canada"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What country is the Great Wall of China in?");
			country = keyboard.nextLine();
			if(country.equals("China"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What is the capital of France?");
			capital = keyboard.nextLine();
			if(capital.equals("Paris"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What is the capital of Russia?");
			capital = keyboard.nextLine();
			if(capital.equals("Moscow"))
				{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("what is the capital of New Jersey?");
			capital = keyboard.nextLine();
			if(capital.equals("Trenton"))
			{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("What is the capital of Wyoming?");
			capital = keyboard.nextLine();
			if(capital.equals("Cheyenne"))
				{
				score++;
				System.out.println("good job");
			}
			else
			{
				System.out.println("Sorry wrong answer");
			}
			System.out.println("your score is: "+score+"/10");
			
		
		
		}
	}
}