
/*
* ENSF 409 Lab 2 Exercise 5
*
* the following class Game acts as a link between
* the other classes Player, Board, and Referee in
* order to set up the Tic Tac Toe game.
*
* Game sets up the game in main. It contains
* the board, the referee, and the two players.
*
* Game implements the Constants interface so that
* "O" and "X" can be used by the two players.
*
* */

public class Game implements Constants, Runnable {

	/*
	* Tic Tac Toe board (3x3 spaces)
	* */
	private Board theBoard;

	/*
	* Referee for the game
	* */
	private Referee theRef;

	/*
	* Constructs the game object
	* */
    public Game( ) {
        theBoard  = new Board();
	}

	/*
	* board accessor function
	* @return game board
	* */
	public Board getTheBoard(){ return theBoard; }

	/*
	* assigns a referee to the game
	* @param referee to be appointed
	* */
    public void appointReferee(Referee r, Player x, Player o) {
        theRef = r;

		theRef.setxPlayer(x);
		theRef.setoPlayer(o);
		theRef.setBoard(theBoard);

    	x.setBoard(theBoard);
    	o.setBoard(theBoard);
    }

    /*
    * used to start a Game
    * */
	@Override

	public void run(){

		theRef.runTheGame();

	}

}
