import java.io.*;
import java.net.*;

public class Server{
    
    private BufferedReader socketIn;
    private PrintWriter socketOut;
    private ServerSocket serverSocket;
    private Socket aSocket;
    
    public Server() {
        try {
            serverSocket = new ServerSocket(9090);
            System.out.println("Game Server is now running.");
            aSocket = serverSocket.accept();
            socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void communicate(){
        
        while (true) {
            try {
                
                String line = socketIn.readLine();
                
            } catch (IOException e) {
                System.err.println(e.getStackTrace());
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Server serv = new Server();
        serv.communicate();
    }
    
}
