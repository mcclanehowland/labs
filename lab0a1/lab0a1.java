import java.util.Scanner;

public class lab0a1 
{
	public static void main(String[] args)
	{
	//McClane Howland p4
	//Part I
		System.out.println("Part I\n");										
		System.out.println("++++++++++++++++++++++++++++\n++++++++++++++++++++++++++++");
	
		for(int x = 0; x < 7; x++)
			{
				System.out.println("+++\t\t\t +++");
			}
	
		System.out.println("+++ \t  CompSci  \t +++");
	
		for(int x = 0; x < 7; x++)
			{
				System.out.println("+++\t\t\t +++");
			}
	
		System.out.println("++++++++++++++++++++++++++++\n++++++++++++++++++++++++++++");
		
		//Part II
		
		System.out.println("\nPart 2\n");
		System.out.println("  /\\\t       /\\\n //\\\\\t      //\\\\\n//  \\\\\"'''''\"//  \\\\");
		
		for(int a = 0; a < 19; a++)
			{
				System.out.print("@");
			}
		System.out.println();
		System.out.println("@'''''''\''\''''''''@");	  
		System.out.println("@'   #       #   '@");
		System.out.println("@'   \\   v   /   '@");
		System.out.println("@'      ---      '@");
		System.out.println("@'''''''''''''''''@");
		
		
		for(int a = 0; a < 19; a++)
			{
				System.out.print("@");
			}
		//Part III
		System.out.println("\n\nPart 3\n");
		for(int b = 0; b < 2; b++) //H					  E				  L	 x 2		O
			{
				System.out.println("HHHHH\t     HHHHH\tEEEEEEEEEEEEE\tLLLL\t\tLLLL\t\tOOOOOOOOOOO");
			}
		for(int b = 0; b < 4; b++)
			{
				System.out.println("HHHHH\t     HHHHH\tEEEE\t\tLLLL\t\tLLLL\t\tOOOO   OOOO");
			}
		for(int c = 0; c < 2; c++)
			{
				System.out.println("HHHHHHHHHHHHHHHHHH\tEEEEEEEEEEEEE\tLLLL\t\tLLLL\t\tOOOO   OOOO");
			}
		for(int b = 0; b < 5; b++) //H
			{
				System.out.println("HHHHH\t     HHHHH\tEEEE\t\tLLLL\t\tLLLL\t\tOOOO   OOOO");
		
			}
		for(int b = 0; b < 2; b++) //H
			{
				System.out.println("HHHHH\t     HHHHH\tEEEEEEEEEEEEE\tLLLLLLLLLLLLL\tLLLLLLLLLLLLL\tOOOOOOOOOOO");
		
			}
		//Challenge
		System.out.println("\nChallenge\n");



		Scanner width = new Scanner(System.in);
		System.out.println("enter the width of your rectangle, minimun 2");
		int myWidth = width.nextInt();
		Scanner height = new Scanner(System.in);
		System.out.println("Enter the height of your rectangle");
		int myHeight = height.nextInt();
		
		for(int e = 1; e <= myWidth; e++)
			{
				System.out.print("*");
			}
		
		System.out.println("");
			
			for(int f = 1; f <= myHeight; f++)
			{
				System.out.print("*");
				for(int space = 0; space < myWidth - 2; space++) 
				{
					System.out.print(" ");
				}
				System.out.print("*");
				System.out.println("");
			}
		for(int e = 1; e <= myWidth; e++)
			{
				System.out.print("*");
			}
			
			
		
		}
	}