
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
* Class Player represents a player
* of a tic tac toe game by giving it a name
* and a certain mark to use.
*
* The player will also associate with their
* opponent player.
* */

public class Player {

    //name of the player
    private String name;

    //board being played on
    private Board board;

    //opponent of the player
    private Player opponent;

    //mark the player will use in the game
    private char mark;

    //for communication through the client
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    /* Constructs a Player object with a name and mark
     * @param mark of new player
     * @param socket used for communication
     */
    public Player(char m, Socket s) throws IOException{

        socketIn= new BufferedReader(new InputStreamReader(s.getInputStream()));
        socketOut= new PrintWriter(s.getOutputStream(), true);
        name= nameRead();
        mark= m;
    }

    /*
    * checks the status of the game and if
    * ends if there is a win or a tie
    * else, the player makes a move and challenges
    * the opponent to make theirs
    * */
    public void play() {

        try {

            while (!board.oWins() && !board.xWins() && !board.isFull()) {

                int bNum= makeMove();
                opponent.sendMove(bNum, mark);
                opponent.play();
            }

        } catch(IOException e){
            System.err.println(e.getMessage());
        }

    }

    /*
    * used to insert the players mark on the board
    * according to users input
    * */
    public int makeMove() throws IOException{

        int buttonNum, row, column;
        String move;
        
        move= socketIn.readLine();

        buttonNum= Integer.parseInt(move);
        
        if(buttonNum % 3==0)
            column= 0;
        else if((buttonNum-1) % 3 == 0)
            column= 1;
        else
            column= 2;
        
        if(buttonNum < 3)
            row= 0;
        else if(buttonNum < 6)
            row= 1;
        else
            row= 2;

        board.addMark(row,column,mark);
        socketOut.flush();
        
        return buttonNum;
    }

    /*
    * accesses the name of a player
    * @return name
    * */
    public String getName() {
        return name;
    }

    /*
    * initializes the players opponent player
    * @param opponent player
    * */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /*
    * initializes the players board
    * @param board
    * */
    public void setBoard(Board board) {
        this.board = board;
    }

    /*
    * prompts user to enter their name
    * */
    public String nameRead() throws IOException{

        sendMessage("\0");
        String name= socketIn.readLine();

        while(name == null){
            sendMessage("\0try again");
            name= socketIn.readLine();
        }
        return name;
    }

    /*
    * closes socket input and output
    * */
    public void close(){

        try {
            socketIn.close();
            socketOut.close();

        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    /*
    * used to send a message to Client
    * @param message
    * */
    public void sendMessage(String m){
        socketOut.println(m);
        socketOut.flush();
    }

    /*
    * used to access the output socket
    * */

    public PrintWriter getSocketOut() {
        return socketOut;
    }
    
    public void sendMove(int bNum, char m){
        socketOut.println(bNum+" "+m);
        socketOut.flush();
    }
}

