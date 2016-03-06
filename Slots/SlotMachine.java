import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class SlotMachine
{
	
	int num1,num2,num3;
	int bet;
	int winnings;
	int balance;
	boolean one = true;
	
	public SlotMachine(int balance)
	{
		this.balance = balance;
	}
	public void drawMe(Graphics g)
	{
		g.setFont(new Font("Arial",Font.PLAIN,30));
		g.setColor(Color.green);
		g.fill3DRect(200,200,300,300,true);
		g.setColor(Color.red);
		g.fill3DRect(225,225,50,50,true);
		g.fill3DRect(325,225,50,50,true);
		g.fill3DRect(425,225,50,50,true);
		g.setColor(Color.red);
		g.drawString("Bet: "+bet,100,100);
		g.drawString("Balance: "+balance,100,125);
		g.drawString("Winnings: "+winnings,100,150);
		g.setColor(Color.black);
		g.drawString(""+num1,250,250);
		g.drawString(""+num2,350,250);
		g.drawString(""+num3,450,250);
	}
	public void bet(int bet)
	{
		if(balance >= bet && one)
		{
			this.bet = bet;
			balance -= bet;
			one = false;
			winnings = 0;
		}
	}
	public void play()
	{
		if(bet > 0)
		{
			num1 = (int)(Math.random()*9+1);
			num2 = (int)(Math.random()*9+1);
			num3 = (int)(Math.random()*9+1);
			
			if(num1 == 7 && num2 == 7 && num3 == 7)
				winnings = bet*100;
			else if(num1 == num2 && num1 == num2 && num2 == num3)
				winnings = bet*5;
			else if(num1 == num2 || num1 == num3 || num2 == num3)
				winnings = bet*2;

			balance += winnings;
		}
		bet = 0;
		one = true;
	}
}