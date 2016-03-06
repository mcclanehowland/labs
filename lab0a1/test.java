import java.util.Scanner;

public class test
{
	public static void main(String[] args)
	{
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
 
/*public class test
{
	public static void main(String[] args)
	{
		for(int e = 0; e < 30; e = e + 1)
		{
			System.out.print("*");
		}
		System.out.println("");
		for(int e = 0; e < 30; e = e + 1)
		{
			System.out.print("*");
		}
	System.out.println("");
		for(int f = 0; f < 7; f = f + 1)
		{
			System.out.println("**    \t\t\t    **");
		}
	for(int e = 0; e < 30; e = e + 1)
		{
			System.out.print("*");
		}
		System.out.println("");
		for(int e = 0; e < 30; e = e + 1)
		{
			System.out.print("*");
		}
	}
}*/

