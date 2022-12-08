package ChessObj;
import java.util.*;
import ChessObj.Chess;
class Main{
	static Scanner reader = new Scanner(System.in);
	public static void main(String args[]){
		// Declare Variables.
		Chess Game = new Chess();
		String name1, name2;
		String from, to;
		
		// Get players names.
		System.out.println("Enter Player1 (White) Name:");
		name1 = reader.next();
		System.out.println("Enter Player2 (Black) Name:");
		name2 = reader.next();
		
		// Set game.
		Game.setPlayer(0, name1);
		Game.setPlayer(1, name2);
		Game.setGame();
		
		// Print board, get player move.
		Game.printBoard();
		System.out.println("Your move?\nfrom: ");
		from = reader.next();
		System.out.println("to: ");
		to = reader.next();
		
		// while players dont want to quit.
		while(!from.equals("quit") || !to.equals("quit"))
		{
			// Move piece.
			Game.move(from, to);
			
			// Print board, get player move.
			Game.printBoard();
			System.out.println("Your move?\nfrom: ");
			from = reader.next();
			System.out.println("to: ");
			to = reader.next();
		}
	}
}