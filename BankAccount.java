import javax.swing.*;		
   
    public class BankAccount 
   {
   
      private int accountNumber;
      private int accountPIN;
      private double accountBalance;
      
      public BankAccount()
      {
         int number = accountNumber;
         int pin = accountPIN;
         double balance = accountBalance;
         
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
         
         return;
      }
      
      public void setAccountPIN(int pin)
      {
         
         return;
      }
      
      public void setAccountBalance(double balance)
      {
         
         return;
      }
      
      public int getAccountNumber()
      {
         return number;
      }
      
      public double getAccountBalance()
      {
         return balance;
      }
      
      public boolean verifyPIN(int pin)
      {
         
         return pin;   
      }
      
      public void withdrawFunds()
      {
         
      }
         
   }