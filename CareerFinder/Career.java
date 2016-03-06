public class Career
{
	String firstName = "";
	String lastName = "";
	int age;
	
	public Career(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public void printCareer(String subject, String hobby, String food)
	{
		if(subject.equals("math") && hobby.equals("tv") && food.equals("steak"))
		{
			System.out.println("you will be a mathemetician");
		}
		if(subject.equals("math") && hobby.equals("reading") && food.equals("steak"))
		{
			System.out.println("you will be a librarian");
		}
		if(subject.equals("math") && hobby.equals("tv") && food.equals("sushi"))
		{
			System.out.println("you will be a teacher");
		}
		if(subject.equals("math") && hobby.equals("reading") && food.equals("sushi"))
		{
			System.out.println("you will be a writer");
		}
		if(subject.equals("english") && hobby.equals("tv") && food.equals("steak"))
		{
			System.out.println("you will be a wine taster");
		}
		if(subject.equals("english") && hobby.equals("tv") && food.equals("sushi"))
		{
			System.out.println("you will be a sake taster");
		}
		if(subject.equals("english") && hobby.equals("reading") && food.equals("steak"))
		{
			System.out.println("you will be a book publisher");
		}
		if(subject.equals("english") && hobby.equals("reading") && food.equals("sushi"))
		{
			System.out.println("you will be a historian");
		}
		if(subject.equals("science") && hobby.equals("tv") && food.equals("steak"))
		{
			System.out.println("you will be a bad scientist");
		}
		if(subject.equals("science") && hobby.equals("tv") && food.equals("sushi"))
		{
			System.out.println("you will be a mad scientist");
		}if(subject.equals("science") && hobby.equals("reading") && food.equals("steak"))
		{
			System.out.println("you will be a good scientist");
		}
		if(subject.equals("science") && hobby.equals("reading") && food.equals("sushi"))
		{
			System.out.println("you will be a research scientist");
		}
	}
	
	public void printInfo()
	{
		System.out.println(firstName+" "+lastName+" "+age);
	}

}