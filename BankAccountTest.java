import java.util.*;
import java.text.DecimalFormat;

public class BankAccountTest
{
	private static final int NACCOUNTS = 5;

	public static void main(String args[])
	{
	
		Scanner sc = new Scanner(System.in);
						
	// 1. Create Array of BankAccount Objects
		BankAccount[] accounts;
	    accounts = new BankAccount[NACCOUNTS];
		int accountNumber = 1000;
		int accountPIN = 9999;
		double accountBalance = 500.75;
		DecimalFormat df = new DecimalFormat("#.##");
		
		for(int i=0;i<accounts.length;i++)
		{
				accounts[i] = new BankAccount(accountNumber,accountPIN, accountBalance);
				accountNumber += 1000;
				accountPIN -= 1;
				accountBalance += 500.34;
		}
			
	// 2. Create Single BankAccount Object
	BankAccount singleAccount = new BankAccount();
		
	// 3. Using Loop, display account numbers and balances and verify PINs (array of BankAcount objects)
	for(int i=0;i<accounts.length;i++)
	{
		System.out.println("Account Number: " + accounts[i].getAccountNumber()+ " Balance: " +  df.format(accounts[i].getAccountBalance())+ "\n");
		System.out.println("Please Enter Your pin-number");
		int pin_Num = sc.nextInt();
		
		if(accounts[i].verifyPIN(pin_Num) == true)
		{
			System.out.println("PIN number correct!\n");
		}
		
		else
		{
			System.out.println("PIN number incorrect!\n");			
			
		}
			
	}
	// 4. Display default account number and balance and verify PIN (single BankAccount object)
		System.out.println("\nSingle BankAccount Object\n");
		System.out.println("Account Number: " + singleAccount.getAccountNumber()+ " Balance: " +  df.format(singleAccount.getAccountBalance())+ "\n");
		System.out.println("Please Enter Your pin-number");
		int pin_Num = sc.nextInt();
		
		if(singleAccount.verifyPIN(pin_Num) == true)
		{
			System.out.println("PIN number correct!\n");
		}
		
		else
		{
			System.out.println("PIN number incorrect!\n");			
		}
	
	// 5. Withdraw Funds from two accounts (array of objects and single object)
	System.out.println("Account "+accounts[2].getAccountNumber() + " has a balance of $" + df.format(accounts[2].getAccountBalance()));
	System.out.println("Enter the Amount to be Withdrawn: ");
	double withdrawAmount = sc.nextDouble();
	accounts[2].withdrawFunds(withdrawAmount);
	System.out.println("Account " + accounts[2].getAccountNumber() + " now has a balance of $" + df.format(accounts[2].getAccountBalance()));
	
	System.out.println("Account " + singleAccount.getAccountNumber()+" has a balance of $" + df.format(singleAccount.getAccountBalance()));
	System.out.println("Enter the Amount to be Withdrawn: ");
	withdrawAmount = sc.nextDouble();
	if (withdrawAmount > singleAccount.getAccountBalance())
	{
		System.out.println("Insufficient funds");
	}
	else
	{
		singleAccount.withdrawFunds(withdrawAmount);
		System.out.println("Account "+singleAccount.getAccountNumber()+" has a balance of $"+df.format(singleAccount.getAccountBalance()));
	}

	// 6. Reassign values using setters (array of objects & single object)
	accounts[1].setAccountNumber(1);
	accounts[1].setAccountPIN(1);
	accounts[1].setAccountBalance(1);
	System.out.println("Array object");
	System.out.println("Account: " + accounts[1].getAccountNumber() + " Balance: " + accounts[1].getAccountBalance());
	System.out.println("Please Enter Your pin-number");
	pin_Num = sc.nextInt();
	
	if(accounts[1].verifyPIN(pin_Num) == true)
	{
			System.out.println("PIN number correct!\n");
	}
	else
	{
			System.out.println("PIN number incorrect!\n");			
	}
		
	singleAccount.setAccountNumber(2);
	singleAccount.setAccountPIN(2);
	singleAccount.setAccountBalance(2);
	System.out.println("Single object");
	System.out.println("Account: " + singleAccount.getAccountNumber() + " Balance: " + singleAccount.getAccountBalance());
	System.out.println("Please Enter Your pin-number");
	pin_Num = sc.nextInt();
	
	if(singleAccount.verifyPIN(pin_Num) == true)
		{
			System.out.println("PIN number correct!\n");
		}
		
		else
		{
			System.out.println("PIN number incorrect!\n");			
		}

	}
}