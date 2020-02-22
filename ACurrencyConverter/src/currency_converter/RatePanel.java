package currency_converter;

//******************************************************************
//RatePanel.java
//
//Panel for a program that converts different currencies to
//U.S. Dollars
//******************************************************************
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.*;
public class RatePanel extends JPanel
{ 
	
	private double[] rate; // exchange rates
	 private String[] currencyName;
	 private JLabel result;
	 private JTextField tfield;
	 private JComboBox combo;
	 // ------------------------------------------------------------
	 // Sets up a panel to convert cost from one of 6 currencies
	 // into U.S. Dollars. The panel contains a heading, a text
	 // field for the cost of the item, a combo box for selecting
	 // the currency, and a label to display the result.
	 // ------------------------------------------------------------
	 public RatePanel ()
	 {
	 JLabel title = new JLabel ("How much is that in dollars?");
	 title.setAlignmentX (Component.CENTER_ALIGNMENT);
	 title.setFont (new Font ("Consolas", Font.BOLD, 20));
	 this.setLayout(new GridBagLayout());
	 GridBagConstraints gbc = new GridBagConstraints();  
	 gbc.fill = GridBagConstraints.CENTER;  
	
	 // Set up the arrays for the currency conversions
	 currencyName = new String[] {"Select the currency..",
	 "European Euro", "Canadian Dollar",
	 "Japanese Yen", "Australian Dollar",
	 "Indian Rupee", "Mexican Peso"};
	 rate = new double [] {0.0, 1.2103, 0.7351,
	 0.0091, 0.6969,
	 0.0222, 0.0880};
	 setPreferredSize (new Dimension (300,400));
	 setBackground(Color.black);
	 combo = new JComboBox(currencyName);
	 tfield = new JTextField(10);
	 tfield.setSize(100, 500);
	 result = new JLabel ();
	 result.setFont(new Font ("Consolas",Font.PLAIN, 20));
	 title.setForeground(Color.white);
	 
	 result.setForeground(Color.white);
	 this.add (title);
	 this.add (combo);
	 add (tfield);
	 tfield.addActionListener(new ComboListener());
	 combo.addActionListener(new ComboListener());
	 this.add (result);
	 
	gbc.fill = GridBagConstraints.HORIZONTAL;  
	 gbc.gridx = 0;  
	 gbc.gridy = 0;  
	 add(title,gbc);
	gbc.fill = GridBagConstraints.HORIZONTAL;  
	 gbc.ipady = 10;  
	 gbc.gridx = 0;  
	 gbc.gridy = 1;  
	 add(combo,gbc);
	 gbc.ipady = 10;  
	 gbc.gridx = 0;  
	 gbc.gridy = 2;
	 add(tfield,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;  
	 gbc.gridx = 0;  
	 gbc.gridy = 3;
	 add(result,gbc);
	 
	
	 
	 
	 

	 } 
	// ******************************************************
	 // Represents an action listener for the combo box.
	 // ******************************************************
	 private class ComboListener implements ActionListener
	 {
	 // --------------------------------------------------
	 // Determines which currency has been selected and
	 // the value in that currency then computes and
	 // displays the value in U.S. Dollars.
	 // --------------------------------------------------
		 
	 public void actionPerformed (ActionEvent event)
	 {	
		 		Double value=null;
		 		DecimalFormat dec = new DecimalFormat("#.##");
		 		try {	
				value =Double.parseDouble(tfield.getText());
				
				}
		 		catch(Exception E){
		 			result.setText("Error");
		 		}
		 		
		 		try {				
		 			int index = combo.getSelectedIndex();	
					result.setText(value+" in "+currencyName[index]+" "+ dec.format((rate[index]*value)));
		 		}catch(Exception E){
		 			result.setText("Error");
		 		}
		 		
		 
	 }
	 
	 }
	} 

