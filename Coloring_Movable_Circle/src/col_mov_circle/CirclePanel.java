package col_mov_circle;

//******************************************************************
//CirclePanel.java
//
//A panel with a circle drawn in the center and buttons on the
//bottom that move the circle.
//******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
	public class CirclePanel extends JPanel
	{
		private final int CIRCLE_SIZE = 50;
		private int x,y;
		private Color c;
		
		
		//---------------------------------------------------------------
		// Set up circle and buttons to move it.
		//---------------------------------------------------------------
		public CirclePanel(int width, int height)
		{
			// Set coordinates so circle starts in middle
			x = (width/2)-(CIRCLE_SIZE/2);
			y = (height/2)-(CIRCLE_SIZE/2);
			c = Color.green;
			
			// Need a border layout to get the buttons on the bottom
			this.setLayout(new BorderLayout());
			
			// Create buttons to move the circle
			JButton left = new JButton("Left");
			JButton right = new JButton("Right");
			JButton up = new JButton("Up");
			JButton down = new JButton("Down");
			
			//Create buttons to choose color
			JButton choose = new JButton ("Choose Color");
			
			// Create buttons to change the color
			JButton green = new JButton("Green");
			JButton yellow = new JButton("Yellow");
			JButton cyan = new JButton("Cyan");
			JButton orange = new JButton("Orange");
				
			green.setForeground(Color.green);
			green.setBackground(Color.black);
			yellow.setForeground(Color.YELLOW);
			yellow.setBackground(Color.black);
			cyan.setForeground(Color.cyan);
			cyan.setBackground(Color.black);
			orange.setForeground(Color.ORANGE);
			orange.setBackground(Color.black);
			
			// Add listeners to the buttons
			left.addActionListener(new MoveListener(-20,0));
			right.addActionListener(new MoveListener(20,0));
			up.addActionListener(new MoveListener(0,-20));
			down.addActionListener(new MoveListener(0,20));
			
			// Add listeners color to the buttons
			green.addActionListener(new ColorListener(0,255,0));
			yellow.addActionListener(new ColorListener(255,255,0));
			cyan.addActionListener(new ColorListener(0,255,255));
			orange.addActionListener(new ColorListener(255,191,10));
				
			//Add color chooser
			choose.addActionListener(new ColorListener(0,0,0));
			
			// Need a panel to put the buttons on or they'll be on
			// top of each other.
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(left);
			buttonPanel.add(right);
			buttonPanel.add(up);
			buttonPanel.add(down);
				
			JPanel buttonColor = new JPanel();
			buttonColor.add(green);
			buttonColor.add(yellow);
			buttonColor.add(cyan);
			buttonColor.add(orange);
			buttonColor.add(choose);
			
//			JPanel buttonChoose = new JPanel();
//			buttonChoose.add(choose);
//		
			
			// Add the button panel to the bottom of the main panel
			this.add(buttonPanel, "South");
			this.add(buttonColor, "North");
			
			
		}		
		
		//---------------------------------------------------------------
		// Draw circle on CirclePanel
		//---------------------------------------------------------------
		public void paintComponent(Graphics page)
		{ 
		super.paintComponent(page);
		page.setColor(c);
		page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
		}
		
		
		//---------------------------------------------------------------
		// Class to listen for button clicks that move circle.
		//---------------------------------------------------------------
		private class MoveListener implements ActionListener
		{
			private int dx;
			private int dy;
			//---------------------------------------------------------------
			// Parameters tell how to move circle at click.
			//---------------------------------------------------------------
			public MoveListener(int dx, int dy)
			{
				this.dx = dx;
				this.dy = dy;
			}
			//---------------------------------------------------------------
			// Change x and y coordinates and repaint.
			//---------------------------------------------------------------
			public void actionPerformed(ActionEvent e)
			{
				x += dx;
				y += dy;
				repaint();
			}
		}
			//---------------------------------------------------------------
			// Class to listen for color button clicks that change the color.
			//---------------------------------------------------------------
		private class ColorListener implements ActionListener
		{
			private int red;
			private int green;
			private int blue;
		
			public ColorListener(int r, int g, int b)
			{
				this.red = r;
				this.green = g;
				this.blue = b;
			}
			
			public void actionPerformed(ActionEvent e)
			{	
			if(red!=0 || green!=0 || blue!=0) {
				c = new Color(red,green,blue);
			}
			else{
				c = JColorChooser.showDialog(null,"Choose Color",c);
			}
			repaint();
				
				}
			}
		}
	