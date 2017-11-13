import javax.swing.*;		
   
    public class BankAccount 
   {
   
      private int[] accountNumber;
      private int[] accountPIN;
      private double[] accountBalance;
      
      public BankAccount()
      {
      
      }
      
      public BankAccount(int[] accountNumber, int[] accountPIN, double[] accountBalance)
      {
         setAccountNumber(accountNumber);
         setAccountPIN(accountPIN);
         setAccountBalance(accountBalance);
         
         return;
      }
      
      public void setAccountNumber(int[] accountNumber)
      {
         accountNumber = new int[5];
         accountNumber[0] = 1000;
         accountNumber[1] = 2000;
         accountNumber[2] = 3000;
         accountNumber[3] = 4000;
         accountNumber[4] = 5000;
         return;
      }
      
      public void setAccountPIN(int[] accountPIN)
      {
         accountPIN = new int[5];
         accountPIN[0] = 9999;
         accountPIN[1] = 9998;
         accountPIN[2] = 9997;
         accountPIN[3] = 9996;
         accountPIN[4] = 9995;
         return;
      }
      
      public void setAccountBalance(double[] accountBalance)
      {
         accountBalance = new double[5];
         accountBalance[0] = 500.75;
         accountBalance[1] = 1001.09;
         accountBalance[2] = 1501.43;
         accountBalance[3] = 2001.77;
         accountBalance[4] = 2502.11;
         return;
      }
      
      public int[] getAccountNumber()
      {
         return accountNumber;
      }
      
      public double[] getAccountBalance()
      {
         return accountBalance;
      }
      
      public void verifyPIN(int[] accountPIN)
      {
         boolean verifyPIN;
      }
      
      public void withdrawFunds()
      {
         
      }
         
   }