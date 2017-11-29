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
   import java.awt.Font;

    public class ATMGUI extends JFrame implements ActionListener
   {
      private Container contentPane;
      private JPanel northJPanel = new JPanel();
      private JPanel southJPanel = new JPanel();
      private JComboBox namesComboBox;
      private JPanel eastButtonJPanel = new JPanel();
      private JPanel centerJPanel = new JPanel();
      private JTextArea prompt = new JTextArea(4,30);
      private JTextField inField = new JTextField(6);
      private JTextField targetNumber = new JTextField(5);
      private JLabel targetLabel = new JLabel("Target Number: ");
      private JTextArea display = new JTextArea(20,50);
      private JButton dealButton = new JButton   ("Deal");  
      private JButton checkButton = new JButton ("Check");
      private JButton buttons[];			
   
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
         targetLabel.setFont(new Font("", Font.PLAIN, 20));
         northJPanel.add(targetLabel);
         northJPanel.add(targetNumber);
         targetNumber.setEditable(false);
			
         add("North",northJPanel);
        // display.append("Please select your account number");
         return;
      }// end buildNorthPanel
         	

		
   	  // builds center panel and adds several buttons along with an array of buttons
       private void buildCenterPanel()
      {
         centerJPanel.setBorder(BorderFactory.createTitledBorder("Choose your numbers and operators!"));
               	         
         add("Center",centerJPanel);
         return;
      }// end buildCenterPanel
         	
     	
   //  routine that builds south panel and adds a combobox to it
       private void buildSouthPanel()
      {
         southJPanel.add(Box.createRigidArea(new Dimension(0,50)));
         southJPanel.add(prompt);
         prompt.append("this is the prompt textarea");
         
         eastButtonJPanel.setLayout(new BoxLayout(eastButtonJPanel,BoxLayout.Y_AXIS));
         eastButtonJPanel.add(Box.createRigidArea(new Dimension(25,0)));
         eastButtonJPanel.add(dealButton);
         dealButton.addActionListener(this);
         eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
         eastButtonJPanel.add(checkButton);
         checkButton.addActionListener(this);
         eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));

         southJPanel.add("East",eastButtonJPanel); 
       
         add("South",southJPanel);
         return;
      }// end buildSouthPanel
   
   
    // not needed yet
       public void actionPerformed( ActionEvent e )
      {
      }
   }// end class