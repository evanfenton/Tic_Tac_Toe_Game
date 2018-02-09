/*
* Class Referee starts and manages the actual
* playing of the tic tac toe game
* */

public class Referee {

    /*
    * One of the players
    * */
    private Player xPlayer;

    /*
    * the other player
    * */
    private Player oPlayer;

    /*
    * the game board
    * */
    private Board board;

    /*
    * Constructs a Referee object
    * */
    public Referee(){
        xPlayer=null;
        oPlayer=null;
        board=null;
    }

    /*
    * used to set each players opponent and begin the game
    * */
    public void runTheGame(){

        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);

        System.out.println("Referee will now start the game\n");

        board.display();

        xPlayer.play();

        System.out.print("\nTHE GAME IS OVER: ");

        if(board.oWins()){
            System.out.println(oPlayer.getName() + " is the winner!");
        }
        else if(board.xWins())
            System.out.println(xPlayer.getName() + " is the winner!");
        else
            System.out.println("The game ended in a tie");

        board.clear();
    }

    /*
    * initializes the board
    * @param board
    * */
    public void setBoard(Board b){
        board=b;
    }

    /*
    * initializes the player using the O mark
    * @param the new O player
    * */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /*
     * initializes the player using the X mark
     * @param the new X player
     * */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }
}
