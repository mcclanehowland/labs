import java.util.Scanner;

public class Bank
{
	String name = "";
	int pin;
	int pinNum = 0;
	double balance;
	boolean access = false;
	boolean user = true;
	
	Scanner kb = new Scanner(System.in);
	
	
	
	public Bank(String name, int pin, double balance)
	{
		
		this.pin = pin;
		this.balance = balance;
		this.name = name;
		
	}
	
	public String getName()
	{
		return name;
	}
	public double getBalance()
	{
		return balance;
	}
	public void deposit(double moneyin)
	{
		balance += moneyin;
	}
	public void withdraw(double moneyout)
	{
		balance -= moneyout;
		
	}
	public int getpinNum()
	{
		return pinNum;
	}
	public boolean checkPin(int pin)
	{
		while(pinNum < 3)
		{
			if(this.pin == pin)
			{
				access = true;
				break;
			}
			pinNum++;
			System.out.println("try again");
			pin = kb.nextInt();
			
		}
		return access;
	}
	public boolean getUser()
	{
		if(pinNum == 3)
		{
			user = false;
		}
		return user;
	}
	public int pinNum()
	{
		return pinNum;
	}
	public void updateName(String name)
	{
		this.name = name;
	}
	public void viewProfile()
	{
		getName();
		getBalance();
		System.out.println(name);
		System.out.println(balance);
	}
	
	
}