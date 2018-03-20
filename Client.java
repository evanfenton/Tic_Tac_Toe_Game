import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Client{

    private BufferedReader socketIn;
    private BufferedReader stdIn;
    private PrintWriter socketOut;
    private ClientFrame frame;
    private ButtonListener [] buttonListeners;

    public Client(String serverName, int portNumber){

        Socket socket;
        frame= new ClientFrame();
        
        buttonListeners= new ButtonListener[9];
        
        for(int i=0; i<9; i++){
            buttonListeners[i]= new ButtonListener(i, frame, socketOut);
        }
        
        try{

            socket= new Socket(serverName, portNumber);
            stdIn= new BufferedReader(new InputStreamReader(System.in));
            socketIn= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOut= new PrintWriter(socket.getOutputStream(), true);

        } catch(IOException e){
            System.err.println(e.getMessage());
        }

    }

    public void communicate(){

        String line;
        String [] move;
        
        frame.registerListeners(buttonListeners);

        try{

            while (true) {
                
                line = socketIn.readLine();

                if (line.contains("\0")) {
                    if(line.contains("try again")){
                        line= frame.getName(true);
                    }
                    else{
                        line= frame.getName(false);
                    }
                    socketOut.println(line);
                }
                else if (line.equals("QUIT")) {
                    return;
                }
                else if(line.contains(" ")){
                    move= line.split(" ");
                    int bNum= Integer.parseInt(move[0]);
                    char m= move[1].charAt(0);
                    frame.setButton(bNum, m);
                }

            }

        } catch(IOException e){

            System.err.println(e.getMessage());

        } finally {

            try {
                stdIn.close();
                socketIn.close();
                socketOut.close();
                frame.setVisible(false);
                frame.dispose();

            } catch(IOException e){
                System.err.println(e.getMessage());
            }

        }

    }

    public static void main(String args[]){

        Client client= new Client("localHost", 8099);

        client.communicate();

    }


}
