/*
Patrick Leeper
Aaron Miller
Homework/Lab #5
Due Date: 11/15/17
leeper@psu.edu
agm5262@psu.edu
BankAccountTest.java

The purpose is to test of the BankAccount.java. 
It makes bank accounts, PINs, and balances. 
Then it prompts to withdraw funds from the first two bank accounts. 
Lastly, it lets the user change PIN for the first two accounts.
*/
import java.util.Scanner;

public class BankAccountTest
{
   public static void main(String[] args)
   {
   Scanner in = new Scanner(System.in);
   
   //Prompt user to enter PIN
   
   
   double defaultBalance = 500.75;
   BankAccount[] accounts = new BankAccount[5];
   
   //Loop array of Objects for BankAccount
   for(int i = 0; i < accounts.length; i++)
   {
      accounts[i] = new BankAccount((1000 + 1000 * i), 9999 - i, defaultBalance + 500.34 * i);
   }
   //Display array of Objects for BankAccount
   for(int i = 0; i < accounts.length; i++)
   {
       
      System.out.println(accounts[i].getAccountNumber());
      //Prompt user to enter PIN
      System.out.println("Input PIN: ");
      int uPIN = in.nextInt();
      System.out.println("");
      System.out.println(accounts[i].verifyPIN(uPIN));
      System.out.println(accounts[i].getAccountBalance());
      System.out.println("----------");
   }
   //Display Single BankAccount object *Dont think this is right*
   System.out.println("----------");
   
   System.out.println(accounts[0].getAccountNumber());
   //Prompt user to enter PIN
       System.out.println("Input PIN: ");
       int uPIN = in.nextInt();
       System.out.println("");
   System.out.println(accounts[0].verifyPIN(uPIN));
   System.out.println(accounts[0].getAccountBalance()); 
   System.out.println("----------\n");
      
   //Withdraw funds from two accounts     
   int wf = 0;
   for(int i = 0; i < 2; i++)
   {
      System.out.println("Enter a withdraw amount from the first and second account");
      int inputWD = in.nextInt();
   
      if(inputWD > accounts[i].getAccountBalance())
      {
   
      System.out.println("That will go into the negatives");
      }
      else
      {
      System.out.println("The new balance is " + accounts[i].withdrawFunds(inputWD));
      }   
   }
   //Reassign values
     
   for(int i = 0; i < 2; i++)
   {
   System.out.println("\n\nPlease enter new pin for account "+ accounts[i].getAccountNumber());
   int cPIN = in.nextInt();
   accounts[i].setAccountPIN(cPIN);
   System.out.println("Your new pin is: " + cPIN);
   }
   
   }
}   