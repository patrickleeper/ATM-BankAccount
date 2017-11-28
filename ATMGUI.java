   import javax.swing.*;
   import java.awt.*;    // container class located
   import java.awt.event.*;  // actionListener interface.

//
// ATMGUI Class used to define the JFrame and set up the actionlister feature
//
    public class ATMGUI extends JFrame implements ActionListener
   {
      private Container contentPane; 
      private JTextArea outArea;
      private JTextField inField;
      private JButton numbersButton[];
      private JButton enterOptionButton;
      private JButton balanceOptionButton;
      private JButton withdrawOptionButton;
      private JButton doneOptionButton;
      private JComboBox accountBox;
      private final static int NBUTTONS = 12;
      private final static int OBUTTONS = 4;
      private String nlabels[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", ""};
      private String olabels[] = {"Enter", "Balance", "Withdraw", "Done"};
    //  private String acctNumbers[] = {"1000", "2000", "3000", "4000", "5000"};
      private JButton buttons[];
      private JButton obuttons[];

              
       public ATMGUI(String title) 
      {
         buildGUI();
         setLocation(200,150); // position window on screen (x,y)
         setTitle(title);
         setSize(600,500);  // width, height
         setVisible(true);  // makes the GUI appear in the window
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits JFRAME APPL.
      						 // uses a qualified name for a class constant
      
      } // GuessTheNumberGUI 
   
   
       private void buildGUI()		// designed to build the contentpane with panels
      {
         contentPane = getContentPane();
         buildNorthPanel();
         buildCenterPanel();
         buildSouthPanel();
         return;
      
      } // end buildGUI()
   
       private void buildNorthPanel()	
      {                                
         JPanel northPanel;
         JPanel nPanel;			
         JPanel sPanel;    
          
      
         northPanel = new JPanel(); // instantiation
         nPanel = new JPanel();        
         sPanel = new JPanel(); 
         outArea = new JTextArea(10,40);
         inField = new JTextField(5);
         outArea.setText("Please choose your account number.");
         outArea.setEditable(false);
         inField.setEditable(false);                            
      
         nPanel.add(outArea);
         sPanel.add(inField);
         northPanel.add(nPanel);
         northPanel.add(sPanel);
         northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));      
      
         contentPane.add("North", northPanel); // adding input panel to north area
      
         return;
      } // end buildNorthPanel()
   
       private void buildCenterPanel()   
      {
         JPanel centerPanel;
         JPanel numbersPanel;
         JPanel optionsPanel;
         
         buttons = new JButton[NBUTTONS]; 
         obuttons = new JButton[OBUTTONS];        
         centerPanel = new JPanel();
         numbersPanel = new JPanel();
         optionsPanel = new JPanel();
         
         for (int i=0; i < buttons.length; i++)
         {
            buttons[i] = new JButton(nlabels[i]);
            buttons[i].setEnabled(false);
            buttons[i].addActionListener(this);
            numbersPanel.add(buttons[i]);
         }
        
         for (int i=0; i < obuttons.length; i++)
         {
            obuttons[i] = new JButton(olabels[i]);
            obuttons[i].setEnabled(false);
            obuttons[i].addActionListener(this);
            optionsPanel.add(obuttons[i]);
         }
         
         numbersPanel.add(Box.createRigidArea(new Dimension(5,0)));
         numbersPanel.setLayout(new GridLayout(5,4));
         
         /*enterOptionButton = new JButton("Enter");
         balanceOptionButton = new JButton("Balance");
         withdrawOptionButton = new JButton("Withdraw");
         doneOptionButton = new JButton("Done");                        
                  
                  
         optionsPanel.add(enterOptionButton);
         optionsPanel.add(Box.createRigidArea(new Dimension(0,5)));
         optionsPanel.add(balanceOptionButton);
         optionsPanel.add(Box.createRigidArea(new Dimension(0,5)));
         optionsPanel.add(withdrawOptionButton);
         optionsPanel.add(Box.createRigidArea(new Dimension(0,5)));
         optionsPanel.add(doneOptionButton);*/
         
         optionsPanel.setLayout(new BoxLayout(optionsPanel,BoxLayout.Y_AXIS));
                  
         centerPanel.add(numbersPanel);
         centerPanel.add(optionsPanel);
         
         contentPane.add("Center", centerPanel); 
               
         return;
      } // end buildCenterPanel
   
       private void buildSouthPanel()   // builds south panel where user will select their account
      {
         JPanel southPanel;			
         JLabel accountLabel;
      
         southPanel = new JPanel();   
         accountLabel = new JLabel("Account Number: ");  // lookup these
         accountBox = new JComboBox();
         accountBox.setMaximumRowCount(3);
         
         loadAccounts();
         accountBox.addActionListener(this);
         
         southPanel.add(accountLabel);
         southPanel.add(accountBox);                            
      
         contentPane.add("South", southPanel); // adding input panel to north area
      
         return;
      } // end buildSouthPanel
      
      
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
      }
      
   
            
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
      
      
      public void actionPerformed(ActionEvent e)  
      {
         String accountNumberString;
         if(e.getSource() == accountBox)
         {
              accountBox.setEnabled(false);
              outArea.setText("");
              enableKeypad();
              obuttons[3].setEnabled(true);
              outArea.setText("Please type in your PIN number.");
              accountNumberString = String.valueOf(accountBox.getSelectedItem());
         }
         else
         {       
               String keyLabel = ((JButton)e.getSource()).getText();
               zeroToNineJButtonActionPerformed(keyLabel);
               obuttons[0].setEnabled(true);                       
         }
         
         
         return;
      }// end action preformed	
      
      private void enableKeypad()
      {
           for (int i=0; i < buttons.length; i++)
         {
            buttons[i].setEnabled(true);
         }
         
         return;
      }
      
      private void disableKeypad()
      {
           for (int i=0; i < buttons.length; i++)
         {
            buttons[i].setEnabled(false);
         }
         
         return;
      }
      
      private void zeroToNineJButtonActionPerformed(String num)
      {
         String userPin = num;
         inField.setText(inField.getText() + num);
         
         return;
      }

      
      
   }