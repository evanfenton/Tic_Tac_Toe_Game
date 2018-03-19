
import java.io.*;
import java.net.*;

public class Client{

    private BufferedReader socketIn;
    private BufferedReader stdIn;
    private PrintWriter socketOut;


    public Client(String serverName, int portNumber){

        Socket socket;

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

        try{

            while (true) {

                while (true) {

                    line = socketIn.readLine();

                    if (line.contains("\0")) {

                        line = line.replace("\0", "");
                        System.out.println(line);
                        break;
                    }

                    if (line.equals("QUIT")) {
                        return;
                    }

                    System.out.println(line);

                }

                line = stdIn.readLine();
                socketOut.println(line);
            }

        } catch(IOException e){

            System.err.println(e.getMessage());

        } finally {

            try {
                stdIn.close();
                socketIn.close();
                socketOut.close();

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