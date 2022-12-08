package ChessObj;
import ChessObj.Board;
class ChessBoard extends Board{
	
	// Constructor.
	public ChessBoard(){
		super(8, 8);
	}
	
	// Get the Chess Board.
	public Token[][] getBoard(){
		return this.board;
	}
	
}