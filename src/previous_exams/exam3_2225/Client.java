package exam3;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        try ( Socket socket = new Socket("localhost", 12345);
              PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
              BufferedReader in = new BufferedReader(
                      new InputStreamReader( socket.getInputStream()));) {
              BufferedReader stdIn = new BufferedReader( new InputStreamReader( System.in));
//            in.readLine().equals("begin");                                                    //1
            while(true) {
                out.println(stdIn.readLine());
                System.out.printf("Server Response: %s%n", in.readLine());
            }
        } catch (IOException e) {}
    }
}

// 1. Describe what this program does.

//1. Takes input from client
//2. returns double of that input
//3. repeat forever

// 2. If we remove the statement with the in-line comment "1", what will happen?

// Client will receive previous response (offset by 1).

// 3. If multiple clients connect to the server at the same time, will the server be able to accept more than 1 connection? Why?

// Yes, the server will create a thread for each connection.

// 4. A socket is created when a connection is established, and stores a port at the server side and a port at the client side. In this program, what port is being used in the server side? What port is being used in the client side?

// S: 12345
// C: Assigned by the operating system
