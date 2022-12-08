package ChessObj;
import ChessObj.Token;
import java.util.*;
class Knight extends Token{
	
	// Constructor.
	public Knight(String color){
		super(10, color, "Chess");
	}
	
	// Check that Knight can move as requested:
	// Knight moves 2 in a direction, 1 in the other direction (L shape).
	public boolean isValid(String from, String to, Token[][] board){
		// Get distances between x's and y's.
		int dist1 = Math.abs(from.charAt(0) - to.charAt(0)),
			dist2 = Math.abs(from.charAt(1) - to.charAt(1));
		// Check any of the conditions.
		return (dist1 == 2 && dist2 == 1) || (dist1 == 1 && dist2 == 2);
				
	}
	
	// Print the 'N' in 'kNight' lol.
	public void printCube(){
		System.out.print(this.color.charAt(0));
		System.out.print("N");
	}
}