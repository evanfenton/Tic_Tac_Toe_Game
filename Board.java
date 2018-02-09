


/*
* Class Board implements the board of a
* tic tac toe game as well as managing the
* state of the game (wins/losses).
*
* Board also has access to the characters held in
* the Constants interface since it is responsible
* for displaying the board and adding players marks.
* */

public class Board implements Constants {

	/*
	* two dimensional array of chars
	* to implement the tic tac toe board
	* */
	private char theBoard[][];

	/*
	* used to keep track of the number of marks
	* on the board
	* */
	private int markCount;

	/*
	* Constructs an object of type board
	* or a "clear game board"
	* */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/*
	* used for accessing the mark at a certain
	* point on the board
	* @param row number
	* @param column number
	* @return character (mark) at specified point
	* */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/*
	* tests for a full board which would signal
	* a tie if neither person had won already
	* @return true if board is full and false if not
	* */
	public boolean isFull() {
		return markCount == 9;
	}

	/*
	* determines if the player with the X
	* mark won or not
	* @return true if X player won and false if not
	* */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/*
	 * determines if the player with the O
	 * mark won or not
	 * @return true if O player won and false if not
	 * */
	public boolean oWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/*
	* prints the board and its current contents to
	* the console
	* */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/*
	* adds a mark at a specified point
	* @param row number
	* @param column number
	* @param mark to be inputted
	* */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/*
	* clears the board of all marks
	* */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/*
	* implements the tic tac toe game logic:
	* searches for 3 consecutive marks of the same type
	* diagonally or vertical/horizontal
	* @param type of mark to check for
	* @return 1 if the player has won and 0 if not
	* */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/*
	* used to display the column and its number
	* to the console
	* */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/*
	* used to display the horizontal lines
	* of the board
	* */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/*
	 * used to display the vertical lines
	 * of the board
	 * */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
