package ChessObj;
import ChessObj.Token;
import java.util.*;
class Pawn extends Token{
	
	// Constructor.
	public Pawn(String color){
		super(10, color, "Chess");
	}
	
	/*
	Check if pawn can move as requested:
	Pawn moves 1 block ahead, except for:
		1. eating (preformed diagonally).
		2. starting point (extra block ahead).
	Pawn can only move towards the other end of the board.
	*/
	public boolean isValid(String from, String to, Token[][] board){
		// Get the starting point of the pawn according to color.
		char colorStart = this.color.equals("black") ? 'b' : 'g';
		
		// Check if start boost is present.
		int move = 1 + (from.charAt(0) == colorStart ? 1 : 0);
		
		// Check if distance is 2 or 1 (according to start boost).
		if ((to.charAt(0) - from.charAt(0) <= move && this.color.equals("black"))||
		(from.charAt(0) - to.charAt(0)) <= move && this.color.equals("white"))
		{
			// Check if move is being preformed on y axis OR eating is being preformed.
			return ((to.charAt(1) == from.charAt(1) &&
			board[to.charAt(0) - 'a'][to.charAt(1) - '1'] instanceof Empty )||
			(Math.abs(to.charAt(1) - from.charAt(1)) == 1 &&
			Math.abs(to.charAt(0) - from.charAt(0)) == 1 &&
			!(board[to.charAt(0) - 'a'][to.charAt(1) - '1'] instanceof Empty)));
		}
		else
		{
			return false;
		}

	}
	
	// Print the letter 'P' in 'Pawn'.
	public void printCube(){
		System.out.print(this.color.charAt(0));
		System.out.print("P");
	}
}