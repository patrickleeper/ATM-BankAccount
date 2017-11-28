// ATM Example
// ATMGUI.java

//*******************************************************
// program used to build a screen showing a msg area,
// input area, numbered keypad, vertical column of buttons,
// and an account dropdown box.
//********************************************************


   import javax.swing.*;
   import java.awt.*;    // container class located
   import java.awt.event.*;  // actionListener interface

    public class ATMGUI extends JFrame implements ActionListener
   {
      private Container contentPane;
	  private final static int NBUTTONS = 12;
      private JPanel northJPanel = new JPanel();
      private JPanel northDisplayJPanel = new JPanel();
      private JPanel northEnterJPanel = new JPanel();
      private JPanel southJPanel = new JPanel();
      private JComboBox accountBox;
      private JPanel eastButtonJPanel = new JPanel();
      private JPanel buttonJPanel = new JPanel();
      private JPanel keyPadJPanel = new JPanel(); 
      private JLabel prompt = new JLabel("Account Number:        ");
      //private JTextField inField = new JTextField(6);
      private JTextField enterField = new JTextField(15);
      private JTextArea display = new JTextArea(5,30);
      private JButton enterButton = new JButton   ("<html><font size=4>Enter</font></html>");  
      private JButton balanceButton = new JButton ("<html><font size=4>Balance</font></html>");
      private JButton withDrawButton = new JButton("<html><font size=4>Withdraw</font></html>");    
      private JButton doneButton = new JButton    ("<html><font size=4>Done</font></html>");
      private JButton buttons[];
      private String labels[] =
      {"1","2","3",
         "4","5","6",
         "7","8","9",
         " ","0"," "};				
  
 //---------------GUI----------------------------------------------------------        
   	  public ATMGUI(String title) 
      {
         buildGUI();
		 setLocation(200,150); // position window on screen (x,y)
         setTitle(title);
         setSize(600,500);  // width, height
         setVisible(true);  // makes the GUI appear in the window
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits JFRAME APPL.
      						 // uses a qualified name for a class constant
      
      } // end ATMAppletGUI
   // builds the necesary panels
       private void buildGUI()
      {
         contentPane = getContentPane();
		 buildNorthPanel();
         buildCenterPanel();
         buildSouthPanel();
      
         return;
      }// end buildGUI
      
		 // routine that builds a north panel and adds display to it
       private void buildNorthPanel()
      {
         northJPanel.setLayout(new BorderLayout(0,0));
         northDisplayJPanel.add(Box.createRigidArea(new Dimension(0,100)));
         northDisplayJPanel.add(display);
         northJPanel.add("North",northDisplayJPanel);
      
         display.setEditable(false);
         northEnterJPanel.add(enterField);
         northJPanel.add("South",northEnterJPanel);
         enterField.setEditable(false);
			
         add("North",northJPanel);
         display.append("Please select your account number");
         return;
      }// end buildNorthPanel
         	

		
   	  // builds center panel and adds several buttons along with an array of buttons
       private void buildCenterPanel()
      {
         buttonJPanel.add(Box.createRigidArea(new Dimension(20,250)));
         keyPadJPanel.setLayout(new GridLayout(4,3,0,0));
         buttons = new JButton[NBUTTONS];
         for (int k=0; k < buttons.length; k++)
         {
            buttons[k] = new JButton(labels[k]);
            buttons[k].addActionListener(this);
            keyPadJPanel.add(buttons[k]);
         } // end for
               	
            buttonJPanel.add(keyPadJPanel,"Center");
         
            eastButtonJPanel.setLayout(new BoxLayout(eastButtonJPanel,BoxLayout.Y_AXIS));
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(25,0)));
            
            enterButton.setEnabled(false);
            balanceButton.setEnabled(false);
            withDrawButton.setEnabled(false);
            
            eastButtonJPanel.add(enterButton);
            enterButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
            
            eastButtonJPanel.add(balanceButton);
            balanceButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
            
            eastButtonJPanel.add(withDrawButton);
            withDrawButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
            
            eastButtonJPanel.add(doneButton);
            doneButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));      
         
            buttonJPanel.add("East",eastButtonJPanel); 
         
            add("Center",buttonJPanel);
         return;
      }// end buildCenterPanel
         	
       private void buildSouthPanel()   // builds south panel where user will select their account
      {
         //JPanel southPanel;			
         //JLabel accountLabel;
      
         //southPanel = new JPanel();   
         //accountLabel = new JLabel("Account Number: ");  // lookup these
         accountBox = new JComboBox();
         accountBox.setMaximumRowCount(3);
         
         loadAccounts();
         accountBox.addActionListener(this);
         
         southJPanel.add(prompt);
         southJPanel.add(accountBox);                            
      
         contentPane.add("South", southJPanel); // adding input panel to north area
      
         return;
      } // end buildSouthPanel      
 //---------------END GUI-------------------------------------------------------    

      private void loadAccounts()
      {
         BankAccount[] accounts = new BankAccount[5];
         String accountNumber[] = new String[5];
         for (int i=0; i<accountNumber.length; i++)
         { 
            double defaultBalance = 500.75;         
            accounts[i] = new BankAccount((1000 + 1000 * i), 9999 - i, defaultBalance + 500.34 * i);
            accountNumber[i] = String.valueOf(accounts[i].getAccountNumber());
            accountBox.addItem(accountNumber[i]);
         }
         
         return;
      }//end loadAccounts
      
   
            
     /* private void populateAccount()
      {

         String accountNumber[] = new String[5];
         for (int i=0; i<accountNumber.length; i++)
         {
            accountNumber[i] = String.valueOf(accounts[i].getAccountNumber());
            accountBox.addItem(accountNumber[i]);
         }
         return;
      }
            
      private void loadAccount()
      {
         for (int i=0; i<accounts.length; i++)
         { 
            double defaultBalance = 500.75;         
            accounts[i] = new BankAccount((1000 + 1000 * i), 9999 - i, defaultBalance + 500.34 * i);
         }

         
         return;
      }*/
      
 //---------------ACTION PERFORMED-----------------------------------------------     
      public void actionPerformed(ActionEvent e)  
      {
         String accountNumberString;
         if(e.getSource() == accountBox)
         {
              accountBox.setEnabled(false);
              display.setText("");
              enableKeypad();
              doneButton.setEnabled(true);
              display.setText("Please type in your PIN number.");
              accountNumberString = String.valueOf(accountBox.getSelectedItem());
         }//end ComboBox AP
         
         else if(e.getSource() == balanceButton)
         {
               display.setText("Test 1.");  
         }//end Balance Button AP
         
         else if(e.getSource() == withDrawButton)
         {
               display.setText("Test 2.");  
         }//end Withdraw Button AP
         
         else if(e.getSource() == doneButton)
         {
               resetGUI();  
         }//end Withdraw Button AP
         
         else if(e.getSource() == enterButton)
         {
            //int p = Integer.parseInt(accountNumberString.toString());
            enterField.setText("");
            display.setText("Test enter");
            /*loop through bank account array, get the account number of the
             bank account object and compare to the accountNumber*/

/*
            if(accountNumber == bankAccount[k].getAccountNumber())
            {
               if(bankAccount[k].verifyPIN(Integer.parseInt(userPin)))
               {
               display.setText("");
               enterField.setText("");
               enterButton.setEnabled(false);
               disableKeypad();
               balanceButton.setEnabled(true);
               withDrawButton.setEnabled(true);
               display.setText("Welcome to ATM Banking.");
               }
               else
               {
               enterField.setText("");
               //set userPIN = ""
               display.setText("PIN is incorrect. Please re-enter PIN");
               }
            }
 */            
         }//end Enter Button AP
         
         else
         {       
               String keyLabel = ((JButton)e.getSource()).getText();
               zeroToNineJButtonActionPerformed(keyLabel);
               enterButton.setEnabled(true);                       
         }//end Key Pad AP
         
         
         return;
      }	
 //---------------END ACTION PERFORMED-----------------------------------------------     
     
      private void enableKeypad()
      {
           for (int i=0; i < buttons.length; i++)
         {
            buttons[i].setEnabled(true);
         }
         
         return;
      }//end enabledKeypad
      
      private void disableKeypad()
      {
           for (int i=0; i < buttons.length; i++)
         {
            buttons[i].setEnabled(false);
         }
         
         return;
      }//end disabledKeypad
      
      private void zeroToNineJButtonActionPerformed(String num)
      {
         String userPin = num;
         enterField.setText(enterField.getText() + num);
         
         return;
      }//end zeroToNineJButtonActionPerformed

     private void resetGUI() // doneButton is the reset button
     {
         display.setText("");
         enterField.setText("");
         enterButton.setEnabled(false);
         balanceButton.setEnabled(false);
         accountBox.setEnabled(true);
         disableKeypad();
         return;
     }
      
      
   }