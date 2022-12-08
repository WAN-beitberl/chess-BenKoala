package ChessObj;
import ChessObj.Token;
import java.util.*;
class Queen extends Token{
	
	// Constructor.
	public Queen(String color){
		super(10, color, "Chess");
	}
	
	// Check that Queen can move as requested:
	// Queen moves like Rook & Bishop.
	public boolean isValid(String from, String to, Token[][] board){
		
		Rook StaightMov = new Rook(this.color);
		Bishop DiagMov = new Bishop(this.color);
		return (StaightMov.isValid(from, to, board) || DiagMov.isValid(from, to, board));
	}
	
	// Print the letter 'Q' in 'Queen'.
	public void printCube(){
		System.out.print(this.color.charAt(0));
		System.out.print("Q");
	}
}