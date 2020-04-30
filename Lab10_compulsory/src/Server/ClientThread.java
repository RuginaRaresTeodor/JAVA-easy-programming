package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

class ClientThread extends Thread {
    private final ServerSocket serverSocket;
    private Socket socket ;
    public ClientThread (Socket socket, ServerSocket serverSocket)
    { this.socket = socket ;
      this.serverSocket = serverSocket; }
    public void run () {
        try {

            while(true) {

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if(request.equals("stop")) {
                    String answer ="Server stopped by client";
                    out.println(answer);
                    
                    out.flush();
                    serverSocket.close();
                }
                else
                {
                    String answer="Server received the request";
                    out.println(answer);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        } }
}
