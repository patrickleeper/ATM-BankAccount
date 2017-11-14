import java.util.Scanner;

public class BankAccountTest
{
   public static void main(String[] args)
   {
   Scanner in = new Scanner(System.in);
   System.out.println("Input PIN: ");
   int uPIN = in.nextInt();
   System.out.println("");
   
   double defaultBalance = 500.75;
   BankAccount[] accounts = new BankAccount[5];
   
   for(int i = 0; i < accounts.length; i++){
      accounts[i] = new BankAccount((1000 + 1000 * i), 9999 - i, defaultBalance + 500.34 * i);
   }
   
   for(int i = 0; i < accounts.length; i++){
      System.out.println(accounts[i].getAccountNumber());
      System.out.println(accounts[i].verifyPIN(uPIN));
      System.out.println(accounts[i].getAccountBalance());
   }
   
   //
   
   }
}   