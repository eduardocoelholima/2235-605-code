package exam3.exam3_2235;
import java.net.*;
import java.io.*;

class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) { this.socket = socket; }

    public void run() {
        try ( PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
              Reader in = new BufferedReader(new InputStreamReader( socket.getInputStream()));
              BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));) {
            String[] msgs = {"begin","1","2","3","end"};
            for (String msg : msgs) out.println(msg);
            socket.close();
        } catch (IOException e) {}
    }
}

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(11111)) {
            while (true) { new ServerThread(serverSocket.accept()).start(); }
        } catch (IOException e) {}
    }
}
