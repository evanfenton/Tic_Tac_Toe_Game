import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Constants{

    private ServerSocket serverSocket;
    private ExecutorService pool;


    public Server(int portNumber) {

        try {
            serverSocket = new ServerSocket(portNumber);
            pool= Executors.newCachedThreadPool();

            System.out.println("Game Server is now running.");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void communicate() {

        try{

            while(true){

                Game game = new Game();

                Player xPlayer= new Player(LETTER_X, serverSocket.accept()),
                oPlayer= new Player(LETTER_O, serverSocket.accept());

                Referee ref= new Referee();

                game.appointReferee(ref, xPlayer, oPlayer);

                pool.execute(game);
            }

        } catch(Exception e){

            System.err.println(e.getMessage());
            System.out.println("Server shutting down");
            pool.shutdown();

        }

    }

    public static void main(String args[]){

        Server myServer = new Server(8099);

        try {

            myServer.communicate();
            myServer.serverSocket.close();

        } catch(IOException e){

            System.err.println(e.getMessage());

        }

    }

}