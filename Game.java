
import java.io.*;

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

public class Game implements Constants {

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
	* assigns a referee to the game
	* @param referee to be appointed
	* */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }

    /*
    * used to set up the game at run time
    * @param command line args
    * */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);

        System.out.println("Game Ended");
	}
	

}
