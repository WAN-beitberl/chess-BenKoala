package ChessObj;
import ChessObj.Token;
import java.util.*;
class Empty extends Token{
	
	// Constructor.
	public Empty(String color){
		super(10, color, "Chess");
	}
	
	// Check if nothing can be moved (spoilers: you can't).
	public boolean isValid(String from, String to, Token[][] board){
		return false;
	}
	
	// Print nothing.
	public void printCube(){
		System.out.print("");
	}
}