import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try {
            Socket socket = new Socket(serverAddress, PORT);
            while(true) {
                Scanner read=new Scanner(System.in);
                System.out.println("Imput the command:");
                String client_imput=read.next();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                out.println(client_imput);
                if(client_imput.equals("exit"))
                    break;
                String answer=in.readLine();
                System.out.println(answer);
                if(client_imput.equals("stop"))
                    break;
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " +e);
        }
    } }