package exceptions.exceptions2;

public class TryCatch {

 public int tryCatchFinally() {
	int i = 0;
	try {
		i = 1;
		System.out.println("a: " + i );
		try {
			i = 2;
			int x = 1/0;
			return i;		
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(1);
		} finally {
//			int x = 1/0;
			System.out.println(2);
			++i;
			return 0;
		}
	} catch (Exception e) {
		int x = 1/0;
		e.printStackTrace();
		System.out.println(3);

	} finally {
		System.out.println(4);
		return ++i; // Danger, Will Robinson: return in the finally-block bypass the uncaught exception
	}
  }
  public static void main(String[] args) {
	System.out.println("Rvalue " + new TryCatch().tryCatchFinally() );
 }
}
