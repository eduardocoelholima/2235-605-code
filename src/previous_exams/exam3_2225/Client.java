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

// 2. If we remove the statement with the in-line comment "1", what will happen?

// 3. If multiple clients connect to the server at the same time, will the server be able to accept more than 1 connection? Why?

// 4. A socket is created when a connection is established, and stores a port at the server side and a port at the client side. In this program, what port is being used in the server side? What port is being used in the client side?

