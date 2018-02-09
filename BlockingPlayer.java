

public class BlockingPlayer extends RandomPlayer implements Constants{
    
    protected BlockingPlayer(String n, char m, RandomGenerator rg){
        super(n,m,rg);
    }
    
    protected void play(){
        
        while(!this.board.oWins() &&
              !this.board.xWins() &&
              !this.board.isFull()) {
            
            makeMove();
            this.board.display();
            this.opponent.play();
        }
    }
    
    protected void makeMove(){

        for(int i=0; i<=2; i++){
            for(int j=0; j<=2; j++){
                
                if(testForBlocking(i,j)){
                    this.board.addMark(i,j,this.mark);
                    return;
                }
            }
        }
        
        super.makeMove();
        
    }
    
    protected boolean testForBlocking(int row, int column){

        boolean testDiagR= false;
        boolean testDiagL= false;
        int numOfOpp=0;
        char markAt= this.board.getMark(row, column);
        
        if(markAt != SPACE_CHAR)
            return false;
        
        // test horizontal
        for(int i=0; i<=2; i++){
            markAt= this.board.getMark(row, i);
            if(i==column)
                continue;
            else if(markAt == this.mark || markAt == SPACE_CHAR)
                break;
            else
                numOfOpp++;
        }
        
        if(numOfOpp==2)
            return true;
        
        // test vertical
        numOfOpp=0;
        for(int i=0; i<=2; i++){
            markAt= this.board.getMark(i, column);
            if(i==row)
                continue;
            else if(markAt == this.mark || markAt == SPACE_CHAR)
                break;
            else
                numOfOpp++;
        }
        
        if(numOfOpp==2)
            return true;
        
        if(row==column)
            testDiagR= true;
        
        // test diagonal down right
        numOfOpp=0;
        for(int i=0, j=0; i<=2 && testDiagR; i++, j++){
            markAt= this.board.getMark(i,j);
            if(i==row && j==column)
                continue;
            else if(markAt == this.mark || markAt == SPACE_CHAR)
                break;
            else
                numOfOpp++;
        }
        
        if(numOfOpp==2)
            return true;
        
        if(row == column-2 || column == row-2 ||
           (row == 1 && column ==1))
            testDiagL= true;
        
        
        // test diagonal down left
        numOfOpp=0;
        for(int i=2, j=0; i>=0 && testDiagL; i--, j++){
            markAt= this.board.getMark(i,j);
            if(i==row && j==column)
                continue;
            else if(markAt == this.mark || markAt == SPACE_CHAR)
                break;
            else
                numOfOpp++;
        }
        
        if(numOfOpp==2)
            return true;
        
        return false;
    }
    
    public String getName() {
        return super.getName();
    }
    
    public void setOpponent(Player opponent) {
        super.setOpponent(opponent);
    }
    
    public void setBoard(Board board) {
        super.setBoard(board);
    }
    
}
