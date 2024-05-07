package exam3.exam3_2235;
import java.io.*;
import java.lang.reflect.GenericDeclaration;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 11111); //1
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));) {
            String inputLine;
            while((inputLine = in.readLine()) != null) System.out.println(inputLine);
        } catch (IOException e) { System.out.println("exception"); }
    }
}

// Assume you run the Server and then the Client a single time, and no network errors occur.
// 1. What is the output of the Client class when run?

//begin
//1
//2
//3
//end

// 2. What is the output of the Server class when run?

// nothing

// 3. If multiple clients connect to the server at the same time, will the server be able to accept more than 1 connection? Why?

// yes, a thread is created each time a client connects

// 4. What would happen if you change the port to 22222, in the line marked with in-line comment "//1"?

// The client would try to connect to a port that is different than the one the server is listening on

