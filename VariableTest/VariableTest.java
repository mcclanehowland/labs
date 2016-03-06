import java.util.Scanner;

public class VariableTest
{
	public static void main(String[] args)
	{
		//Triangle
		System.out.println("Area of a Triangle");
		int height = 18;
		int base = 2;
		int area = height * base / 2;
		System.out.println("area = height * base / 2");
		System.out.println("length = " + height + " base = " + base);
		System.out.println("area = " + area);
		
		//Square
		System.out.println("\n Area of a Square");
		int sideLength = 4;
		area = sideLength * sideLength;
		System.out.println("Area = Side Length squared");
		System.out.println("Side Length = " + sideLength );
		System.out.println("Area = " + area);
		
		//Perimeter of a square
		System.out.println("\n Perimeter of a square");
		sideLength = 4;
		int perimeter = sideLength * 4;
		System.out.println("Perimeter = side length * 4");
		System.out.println("Side length = " + sideLength);
		System.out.println("perimeter = " + perimeter);
		
		//Perimeter of a triangle
		System.out.println("\nPerimeter of a triangle");
		base = 2;
		sideLength = 4;
		perimeter = base + sideLength + sideLength;
		System.out.println("perimeter = base + sideLength + sideLength");
		System.out.println("Side Length = " + sideLength + " Base = " + base);
		System.out.println("perimeter = " + perimeter);
		
		//Area of a trapezoid
		System.out.println("\nArea of a trapezoid");
		height = 8;
		int longSide = 4;
		int shortSide = 2;
		int LplusS = longSide + shortSide;
		area = height * LplusS / 2;
		System.out.println("Area = height * long Side + short Side / 2");
		System.out.println("height = " + height + " long side = " + longSide + " Short side = " + shortSide);
		System.out.println("Area = " + area);
		
		//Part 2
		System.out.println("\nPart 2");
		
		//Area of a regular pentagon A = 1.720a2, in which a is one of the sides.
		System.out.println("\n area of a regular pentagon");
		double constant = 1.720;
		double side = 5;
		double Area = constant * side * 2;
		System.out.println("Area = 1.720 * side length * 2");
		System.out.println("side length = " + side);
		System.out.println("area = " + Area);
		
		//Area of a regular hexagon A = 2.598a2, in which a is one of the sides.
		System.out.println("\n Area of a regular hexagon");
		constant = 2.598;
		side = 7;
		Area = constant * side * 2;
		System.out.println("Area =  2.598 * side length * 2");
		System.out.println("Side = " + side);
		System.out.println("Area = " + Area);
		
		//Area of a regular octagon A = 4.828a^2
		System.out.println("\nArea of a regular octagon");
		constant = 4.828;
		side = 8;
		Area = constant * side * side;
		System.out.println("Area = 4.828 * side * side");
		System.out.println("side = " + side);
		System.out.println("Area = " + Area);
		
		//Area of a circle
		System.out.println("\nArea of a circle");
		double pi = 3.14;
		double radius = 4;
		Area = pi * radius * radius;
		System.out.println("Area = pi * radius * radius");
		System.out.println("radius = " + radius);
		System.out.println("Area = " + Area);
		
		//Circumference of a circle
		System.out.println("\nCircumference of a circle");
		radius = 8;
		double Circumference = radius * 2 * pi;
		System.out.println("Circumference = pi * radius * 2");
		System.out.println("radius = " + radius);
		System.out.println("Circumference = " + Circumference);
		
		//part 3
		System.out.println("\nPart 3");
		char[] hello = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33};
		for (int i = 0; i < 12; i++)
		{
			System.out.print(hello[i]);
		}
		
		//part4
		System.out.println("\n\nPart 4");
		boolean one = false;
		System.out.println("one " + one);
		boolean two = true;
		System.out.println("two " + two);
		boolean three = false;
		System.out.println("three " + three);
		boolean four = true;
		System.out.println("four " + four);
		
		//Challenge
		
		//Area
		
		System.out.println("\nArea of a circle");
		Scanner rad = new Scanner(System.in);
		System.out.println("Please enter the radius of your circle as an integer");
		radius = rad.nextInt();
		System.out.println("Area = pi * radius * radius");
		System.out.println("Radius = " + radius);
		Area = pi * radius * radius;
		System.out.println("Area = " + Area);
		
		//Circumference
		
		System.out.println("\nCircumference of a Circle");
		Scanner circ = new Scanner(System.in);
		System.out.println("Please enter the radius of your circle as a double");
		radius = circ.nextDouble();
		System.out.println("Circumference = pi * radius * 2");
		System.out.println("radius = " + radius);
		System.out.println("Circumference = " + Circumference); //Circumference defined pt 2
	
	}
}




