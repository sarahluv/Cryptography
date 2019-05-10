/*******************************************************************************
Name: Sarah Redmon
Date: 3/5/19
Instructor: Ms. Tucker
Class: Frequency
Purpose: To count the occurences of each letter of the alphabet from an Excel file
*******************************************************************************
*/

/*------------------------------------------------------------------------------
    FEEDBACK FROM INSTRUCTOR:
    
    Nice work and explanation of the cipher but what your guess as to the 
    shift and how to decrypt.  I wanted specifics for this example.
------------------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Frequency
{
   public static void main (String[] args) throws IOException {
       //-----------------------------------------------------------------
       //  Initialize variables & string; set inFile to null
       //-----------------------------------------------------------------
       int[] count = new int[256];
       int c = 0;
       String line;
       
       BufferedReader inFile = null;

       try
       {
            //-----------------------------------------------------------------
            //  Bring in file to read and scan
            //-----------------------------------------------------------------
            inFile = new BufferedReader(new FileReader("Encrypted.csv"));
            
            //-----------------------------------------------------------------
            //  While there are lines to scan from,  change each line to uppercase
            //  For each char, if it's a letter then increment count array (save into array)
            //  Increment c each time for count
            //-----------------------------------------------------------------
            while ((line = inFile.readLine()) != null)
            {
		line = line.toUpperCase();
                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
		        count[ch - 'A']++;
                    }
                }
                c++;
            }
       }
       finally
       {
           //-----------------------------------------------------------------
           //  Close the file once done
           //-----------------------------------------------------------------
           if (inFile != null)
           {
                inFile.close();
           }
            
           //-----------------------------------------------------------------
           //  Display occurences for each 26 letters in printf
           //-----------------------------------------------------------------
           for (c = 0; c < 26; c++) {
               System.out.printf("%c occurs %d times\n", c + 'A', count[c]);
           }
       }
    }
}
