
import java.util.Scanner;

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

    /* Constructs a Player object with a name and mark
     * @param name of new player
     * @param mark of new player
     */
    public Player(String n, char m){
        name=n;
        mark=m;
    }

    /*
    * checks the status of the game and if
    * ends if there is a win or a tie
    * else, the player makes a move and challenges
    * the opponent to make theirs
    * */
    public void play(){

        while(!board.oWins() && !board.xWins() && !board.isFull()) {

            makeMove();
            board.display();
            opponent.play();
        }


    }

    /*
    * used to insert the players mark on the board
    * according to users input
    * */
    public void makeMove(){

        Scanner scan= new Scanner(System.in);
        int row,column;

        System.out.println(name+ ", what row should your next "+mark+
            " be placed in?");
        row=Integer.parseInt(scan.nextLine());

        System.out.println(name+ ", what column should your next "+mark+
                " be placed in?");
        column=Integer.parseInt(scan.nextLine());

        board.addMark(row,column,mark);
        System.out.println();
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
}
