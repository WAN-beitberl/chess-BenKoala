package ChessObj;
import ChessObj.Token;
import java.util.*;
class King extends Token{
	
	// Constructor.
	public King(String color){
		super(10, color, "Chess");
	}
	
	// Check if king can move as requested:
	// king cam move in any of the 8 directions.
	public boolean isValid(String from, String to, Token[][] board){
		return ((Math.abs(from.charAt(0) - to.charAt(0)) <= 1)
				&& Math.abs(from.charAt(1) - to.charAt(1)) <= 1);
	}
	
	// Print the 'K' in 'King'.
	public void printCube(){
		System.out.print(this.color.charAt(0));
		System.out.print("K");
	}
}