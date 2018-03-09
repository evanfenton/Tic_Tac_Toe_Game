import java.io.*;
import java.net.*;

public class Client {
    
    private Socket socket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;
    private BufferedReader stdIn;
    
    public Client(String serverName, int portNumber){
        try {
            
            socket = new Socket(serverName, portNumber);
            socketIn= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOut= new PrintWriter(socket.getOutputStream(), true);
            stdIn= new BufferedReader(new InputStreamReader(System.in));
            
        }catch(IOException e){
            
            System.err.println(e.getStackTrace());
        }
        
    }
    
    public void communicate(){
        
    }
    
    public static void main(String [] args){
        Client player= new Client("localHost", 9090);
        player.communicate();
    }
    
}
