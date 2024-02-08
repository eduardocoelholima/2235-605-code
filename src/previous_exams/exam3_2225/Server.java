package exam3;
import java.net.*;
import java.io.*;

class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) { this.socket = socket; }

    public void run() {
        try ( PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
              BufferedReader in = new BufferedReader(
                      new InputStreamReader( socket.getInputStream()));) {
            String inputLine;
            out.println("begin");
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("bye")) break;
                out.println(2*Integer.parseInt(inputLine));
                System.out.println("got"+inputLine);
            }
            socket.close();
        } catch (IOException e) {}
    }
}

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) { new ServerThread(serverSocket.accept()).start(); }
        } catch (IOException e) {}
    }
}
