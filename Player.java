
/*
* Class Player represents a player
* of a tic tac toe game by giving it a name
* and a certain mark to use.
*
* The player will also associate with their
* opponent player.
* */

public abstract class Player {

    //name of the player
    protected String name;

    //board being played on
    protected Board board;

    //opponent of the player
    protected Player opponent;

    //mark the player will use in the game
    protected char mark;

    /* Constructs a Player object with a name and mark
     * @param name of new player
     * @param mark of new player
     */
    protected Player(String n, char m){
        name=n;
        mark=m;
    }

    /*
    * checks the status of the game and if
    * ends if there is a win or a tie
    * else, the player makes a move and challenges
    * the opponent to make theirs
    * */
    protected abstract void play();

    /*
    * used to insert the players mark on the board
    * according to users input
    * */
    protected abstract void makeMove();
    /*
    * accesses the name of a player
    * @return name
    * */
    protected String getName() {
        return name;
    }

    /*
    * initializes the players opponent player
    * @param opponent player
    * */
    protected void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /*
    * initializes the players board
    * @param board
    * */
    protected void setBoard(Board board) {
        this.board = board;
    }
}
