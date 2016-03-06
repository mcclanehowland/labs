import java.util.Scanner;
import javax.swing.JFrame;

public class BankRunner
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		//System.out.println("1- John, 2- Joe, 3- Jen");
		//int selection = kb.nextInt();
		
		
		Bank customer1 = new Bank("John", 1234, 100.00);
		Bank customer2 = new Bank("Joe", 4321, 1020.30);
		Bank customer3 = new Bank("Jen", 1111, 101.00);
		
		Bank currentCustomer = new Bank("name",6789,100);
		boolean user = true;
		boolean access = false;
		boolean select = false;
		String y = "";
	while(user)
	{
		
	
		System.out.println("1- John, 2- Joe, 3- Jen");
		int selection = kb.nextInt();
		if(selection == 1)
		{
			currentCustomer = customer1;
			
		}
		else if(selection == 2)
		{
			currentCustomer = customer2;
			
		}
		else if(selection == 3)
		{
			currentCustomer = customer3;
			
		}
		else
		{
		
		}
		
		
		System.out.println("please enter your pin");
		int pin = kb.nextInt();
		access = currentCustomer.checkPin(pin);
		
		
		
		
		
		System.out.println(access);
		user = currentCustomer.getUser();
		System.out.println(user);
		
		
		
		JFrame frame = new JFrame("ATM");
        Screen s = new Screen();
		
        frame.add(s);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
		
       
		
		if(access == true)
		{ 
			frame.setVisible(true);
			s.updateScreen(currentCustomer.getName(), currentCustomer.getBalance());
			while(user)
			{
			currentCustomer.viewProfile();
			
			System.out.println("1- Withdraw\n2- Deposit\n3- Update Name \n4- Exit");
			int action = kb.nextInt();
			switch(action)
			{
				case 1:
					System.out.println("how much would you like to withdraw?");
					double moneyout = kb.nextDouble();
					currentCustomer.withdraw(moneyout);
					s.updateScreen(currentCustomer.getName(), currentCustomer.getBalance());
					break;
				case 2:
					System.out.println("how much would you like to deposit?");
					double moneyin = kb.nextDouble();
					currentCustomer.deposit(moneyin);
					s.updateScreen(currentCustomer.getName(), currentCustomer.getBalance());
					break;
				case 3: 
					System.out.println("please enter your new name");
					String name = kb.next();
					currentCustomer.updateName(name);
					s.updateScreen(currentCustomer.getName(), currentCustomer.getBalance());
					break;
				case 4:
					select = false;
			}
				System.out.println("would you like to continue? y/n");
				if(kb.next().equals("n"))
				{
					break;
				}
				
			}
			
			
		}
		
	}
		
		
		

		
        
	}
}