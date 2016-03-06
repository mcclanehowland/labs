import java.util.Scanner;

public class Formulas
{
	double pi = 3.14;
	double gravity = 9.8;
	double height, length, width, base, radius, area, perimeter, mass, acceleration, force, velocity, velocity2, time, distance, weight;
	
	
	
	
	Scanner keyboard = new Scanner(System.in);
	public void triangleArea()
	{
		System.out.println("please enter the height of your triangle");
		height = keyboard.nextDouble();
		System.out.println("please enter the base of your triangle");
		base = keyboard.nextDouble();
		area = 0.5 * height * base;
		System.out.println("the area of your triangle is: "+area);
	}
	public void squareArea()
	{
		System.out.println("enter the side length of your square");
		length = keyboard.nextDouble();
		area = length * length;
		System.out.println("the area of your square is: "+area);
	}
	public void rectangleArea()
	{
		System.out.println("enter the length of your rectangle");
		length = keyboard.nextDouble();
		System.out.println("Enter the width of your rectangle");
		width = keyboard.nextDouble();
		area = length * width;
		System.out.println("the area is: "+area);
	}
	public void circleArea()
	{
		System.out.println("please enter the radius of your circle");
		radius = keyboard.nextDouble();
		area = radius * radius * pi;
		System.out.println("the area of your circle is: "+area);
	}
	public void squarePerimeter()
	{
		System.out.println("enter the side length of your square");
		length = keyboard.nextDouble();
		perimeter = 4 * length;
		System.out.println("the perimeter of your square is: "+perimeter);
	}
	public void trianglePerimeter()
	{
		System.out.println("please enter the side length of your equilateral triangle");
		length = keyboard.nextDouble();
		perimeter = 3 * length;
		System.out.println("the perimeter is: "+perimeter);
	}
	public void pentagonPerimeter()
	{
		System.out.println("please enter the side length of your regular pentagon");
		length = keyboard.nextDouble();
		perimeter = 5 * length;
		System.out.println("the perimeter is: "+perimeter);
	}
	public void octagonPerimeter()
	{
		System.out.println("please enter the side length of your regular octagon");
		length = keyboard.nextDouble();
		perimeter = length * 8;
		System.out.println("the perimeter is: "+perimeter);
	}
	public void dodecagonPerimeter()
	{
		System.out.println("please enter the side length of a regular dodecagon");
		length = keyboard.nextDouble();
		perimeter = 12 * length;
		System.out.println("the perimeter is: "+perimeter);
	}
	public void nonagonPerimeter()
	{
		System.out.println("please enter the side length of your regular nonagon");
		length = keyboard.nextDouble();
		perimeter = length * 9;
		System.out.println("the perimeter is: "+perimeter);
	}
	public void force()
	{
		System.out.println("please enter the mass of your object");
		mass = keyboard.nextDouble();
		System.out.println("please enter the acceleration of your object");
		acceleration = keyboard.nextDouble();
		force = mass * acceleration;
		System.out.println("the force = "+force);
	}
	public void distance()
	{
		System.out.println("please enter the velocity of your object");
		velocity = keyboard.nextDouble();
		System.out.println("please enter the time your object was traveling");
		time = keyboard.nextDouble();
		distance = velocity * time;
	}
	public void velocity()
	{
		System.out.println("please enter the time");
		time = keyboard.nextDouble();
		System.out.println("please enter the displacement");
		distance = keyboard.nextDouble();
		velocity = distance / time;
		System.out.println("the velocity is: "+velocity);
	}
	public void freeFall()
	{
		System.out.println("please enter the time the object was falling (seconds)");
		time = keyboard.nextDouble();
		height = 0.5 * gravity * time * time * (-1);
		System.out.println("the object fell "+height+" meters");
	}
	public void acceleration()
	{
		System.out.println("please enter the initial velocity of the object (m/s)");
		velocity = keyboard.nextDouble();
		System.out.println("please enter the final velocity (m/s)");
		velocity2 = keyboard.nextDouble();
		System.out.println("please enter the time between initial and final velocities (seconds)");
		time = keyboard.nextDouble();
		acceleration = (velocity2 - velocity)/time;
		System.out.println("the acceleration was "+acceleration+" m/s");	}
}