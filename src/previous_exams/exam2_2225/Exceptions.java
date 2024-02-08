package exam2;

public class Exceptions {
	int[] intArray = {0};
	public void runAndThrows() throws RuntimeException {
		try {
			try {
				intArray[1] = 1;
				System.out.println(intArray[0]);
			}
			catch (RuntimeException e) { System.out.println("inner block"); }
			finally {
				intArray[1] = 1;
				System.out.println(intArray[0]);
			}
		}
		catch (Exception e) { System.out.println("outer block"); }
	}

	public Exceptions run() {
		intArray[0] = 1;
		intArray[1] = 2;
		return this;
	}


	public static void main (String[] args) throws Exception {
		try{ new Exceptions().run().runAndThrows(); }
		catch (Exception e) {} }
}

// 1. What will be the output of this program?

//inner block
//outer block


//2. If the commented line is uncommented, what will happen? Explain.

// An uncaught exception would halt the execution of the program (IndexOutOfBounds)

