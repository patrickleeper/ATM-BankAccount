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
            System.out.println("That was the correct PIN");
         }
         else
         {
            verifyPIN = false;
            System.out.println("That was not the correct PIN");
         }
         return verifyPIN;   
      }
      
      public void withdrawFunds(int wFunds)
      {
         this.accountBalance -= wFunds;
      }
         
   }