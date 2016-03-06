import java.util.Scanner;

public class Runner
{
	public static void main(String[] args)
	{
		boolean user = true;
		while(user == true)
		{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String firstName = kb.next();
		System.out.println("please enter your last name");
		String lastName = kb.next();
		System.out.println("please enter your age");
		int age = kb.nextInt();
		
		
		System.out.println("please enter your favorite subject: math, english, or science");
		String subject = kb.next();
		System.out.println("please enter your favorite hobby: tv or reading");
		String hobby = kb.next();
		System.out.println("please enter your favorite food: sushi or steak");
		String food = kb.next();
		
		
		Career c = new Career(firstName, lastName, age);
		//c.printInfo();
		
		c.printCareer(subject, hobby, food);
		System.out.println("would you like to try again, "+firstName+" y/n?");
		String userInput = kb.next();
		if(userInput.equals("y"))
		{
			user = true;
		}
		else
		{
			user = false;
			System.out.println("see you next time, "+firstName);
		}
		}
	}
}