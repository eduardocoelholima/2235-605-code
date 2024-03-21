package exam2;
import java.io.*;

public class FileOperation {
    public static void main( String[] args ) {
        try ( BufferedReader inputReader = new BufferedReader( new FileReader( "in.txt" ) );
              PrintWriter outputWriter = new PrintWriter( new FileWriter( "out.txt" ) );) {
            String line;
            while ( ( line = inputReader.readLine() ) != null ) {
                if (line.matches(".*"+args[0]+".*")) //1
                    System.out.println(line); //2
                outputWriter.println( line ); //3
            }
        }
        catch( Exception e ) { System.out.println(e); }
    }
}


// 1. Describe the functionality of the main method.
// Reades from in.txt, writes to out.txt, line by line, if line has the
// passed argument, prints to the terminal. All lines are copied to out.txt.

// 2. What is the line marked with the in-line comment "1" performing?
// Check if the word passed is present in the line

// 3. What is the line marked with the in-line comment "2" performing?
// Printing to the terminal (stdout)

// 4. What is the line marked with the in-line comment "3" performing?
// Printing to the output file out.txt
