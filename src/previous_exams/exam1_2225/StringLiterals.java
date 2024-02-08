package previous_exams.exam1_2225; //2

public class StringLiterals {
    public static String getString() {
        return "12";
    }

    public static void main( String args[] ) {
        String stringA = "1" + "2";
        String stringB = "12";
        int intA = 2;
        String stringC = "1" + "2";
        String stringD = "1" + intA;

        System.out.println("" + ( stringD == "1" + "2")  ); //1
        System.out.println("" + ( stringD == "12" )  ); //2
        System.out.println("" + ( stringC.equals( "" + 10 + 2 ) ) ); //3
        System.out.println("" + ( "1" + "2" == "12" ? "false" : "true" ) ); //5
        System.out.println("" + ( stringA == stringB)  ); //5
        System.out.println("" + ( stringD.equals( 1 + "2" ) ) ); //6
        System.out.println( stringC == getString()); //7
        System.out.println("" + "1" + "2" == "12" ); //8
    }
}

// Answer the following.

// 1. What is the output of this program?

// 2. Explain each line of the output.
