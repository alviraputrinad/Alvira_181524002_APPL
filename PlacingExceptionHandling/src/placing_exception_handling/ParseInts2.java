package placing_exception_handling;
//
//Reads a line of text and prints the integers in the line.
//
//****************************************************************
	import java.util.Scanner;
	
	public class ParseInts2
	{
		public static void main(String[] args)
		{
			int val, sum=0;
			Scanner scan = new Scanner(System.in);
			String line;
			System.out.println("Enter a line of text");
			Scanner scanLine = new Scanner(scan.nextLine());
			
			while (scanLine.hasNext())
			{	
				try {

				val = Integer.parseInt(scanLine.next());
				sum += val;
				}
				catch(NumberFormatException ex) {
				scanLine.hasNext();	
				}
			}
			
			System.out.println("The sum of the integers on this line is " + sum);
		}
} 