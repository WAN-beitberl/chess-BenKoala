package ChessObj;
import ChessObj.Token;
import java.util.*;
class Bishop extends Token{
	
	// Constructor.
	public Bishop(String color){
		super(10, color, "Chess");
	}
	
	// Check if bishop can be moved as requested:
	// Bishop moves diagonally.
	public boolean isValid(String from, String to, Token[][] board){
		// Get slots indexes.
		int y1 = from.charAt(0) - 'a';
		int x1 = from.charAt(1) - '1';
		int y2 = to.charAt(0) - 'a';
		int x2 = to.charAt(1) - '1';
		
		// check that goal slot is diagonally positioned relative to the pieces.
		if ( Math.abs(x1 - x2) == Math.abs(y1 - y2)){
			// Check path.
			for(int i = 1; i < Math.abs(y1 - y2) - 1 ; i++){
				if (!(board[Math.min(y1, y2) + i][Math.min(x1, x2) + i] instanceof Empty)){
					System.out.println(board[Math.min(y1, y2) + i][Math.min(x1, x2) + i]);
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	// Print the 'B' in "Bishop".
	public void printCube(){
		System.out.print(this.color.charAt(0));
		System.out.print("B");
	}
}