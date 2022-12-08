package ChessObj;
import ChessObj.Token;
import java.util.*;
class Rook extends Token{
	
	// Constructor.
	public Rook(String color){
		super(10, color, "Chess");
	}
	
	// Check if Rook can move as requested:
	// Rook moves on x, y axis only.
	public boolean isValid(String from, String to, Token[][] board){
		// Get board indexes.
		int y1 = from.charAt(0) - 'a';
		int x1 = from.charAt(1) - '1';
		int y2 = to.charAt(0) - 'a';
		int x2 = to.charAt(1) - '1';
		
		// Case - movment is on y axis - check that path is clean.
		if(x1 == x2){
			for(int i = Math.min(y1, y2) + 1; i < Math.max(y1, y2); i++){
				if (!(board[i][x1] instanceof Empty)){
					return false;
				}
			}
			return true;
		}
		// Case - movment is on x axis - check that path is clean.
		if (y1 == y2){
			for(int i = Math.min(x1, x2) + 1; i < Math.max(x1, x2); i++){
				if (!(board[y1][i] instanceof Empty)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	// Print the 'R' for Rook.
	public void printCube(){
		System.out.print(this.color.charAt(0));
		System.out.print("R");
	}
}