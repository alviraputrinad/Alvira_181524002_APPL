package reading_from_and_writing_text_files;

// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
 // --------------------------------------------------------------------
 // Reads student data (name, semester hours, quality points) from a
 // text file, computes the GPA, then writes data to another file
 // if the student is placed on academic warning.
 // --------------------------------------------------------------------
 public static void main (String[] args)
 {
	 int creditHrs; // number of semester hours earned
	 double qualityPts; // number of quality points earned
	 double gpa; // grade point (quality point) average
	 String line, name;
	 String inputName = "student.dat";
	 String outputName = "warning.dat";
	 File myObj = new File("D:\\student.dat");
	 try
	 {
	 // Set up scanner to input file
	 Scanner scan = new Scanner(myObj);
	 // Set up the output file stream
     PrintWriter outFile = new PrintWriter("D:\\warning.dat");
	 // Print a header to the output file
	 outFile.println ();
	 outFile.println ("Students on Academic Warning");
	 outFile.println ();
	 // Process the input file, one token at a time

     while (scan.hasNextLine()) {
    	name= scan.next();
       creditHrs = scan.nextInt();
       qualityPts = scan.nextDouble();
       gpa = qualityPts/creditHrs;
       if((gpa<1.5 && creditHrs<30)||(gpa<1.75 && creditHrs<60)||(gpa<2.0)) {
    	   System.out.println(name);
			outFile.println(name+" "+creditHrs+" "+gpa);
			
       }
       
       
	 // Get the credit hours and quality points and
	 // determine if the student is on warning. If so,
	 // write the student data to the output file.
	 }
	 // Close output file
     outFile.close();
	 }
	 catch (FileNotFoundException exception)
	 {
		 System.out.println ("The file " + inputName + " was not found.");
	 }
	 catch (IOException exception)
	 {
		 System.out.println (exception);
	 }
	 catch (NumberFormatException e)
	 {
		 System.out.println ("Format error in input file: " + e);
	 }
 }
} 