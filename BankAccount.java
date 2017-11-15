/*
Patrick Leeper
Aaron Miller
Homework/Lab #5
Due Date: 11/15/17
leeper@psu.edu
agm5262@psu.edu
BankAccount.java

The purpose is use getters, setters, verify PINs, withdraw funds.
*/
import javax.swing.*;		
   
    public class BankAccount 
   {
   
      private int accountNumber;
      private int accountPIN;
      private double accountBalance;
      
      public BankAccount()
      {
         accountNumber = 0;
         accountPIN = 0;
         accountBalance = 0.00;
         return;
      }
      
      public BankAccount(int number, int pin, double balance)
      {
         setAccountNumber(number);
         setAccountPIN(pin);
         setAccountBalance(balance);
         
         return;
      }
      
      public void setAccountNumber(int number)
      {
         accountNumber = number;
         return;
      }
      
      public void setAccountPIN(int pin)
      {
         accountPIN = pin;
         return;
      }
      
      public void setAccountBalance(double balance)
      {
         accountBalance = balance;
         return;
      }
      
      public int getAccountNumber()
      {
         return accountNumber;
      }
      
      public double getAccountBalance()
      {
         return accountBalance;
      }
      
      public boolean verifyPIN(int pin)
      {
         boolean verifyPIN;
      
         if(this.accountPIN == pin)
         {
            verifyPIN = true;
            System.out.println("That was the correct. PIN was " + pin);
         }
         else
         {
            verifyPIN = false;
            System.out.println("That was not the correct PIN");
         }
         return verifyPIN;   
      }
      
      public double withdrawFunds(int wf)
      {
         accountBalance = accountBalance - wf;
         return accountBalance;
      }
         
   }