package ChessObj;
import ChessObj.Board;
import ChessObj.Player;
import java.util.*;
abstract class Game{
	
	// Declare Properties.
	protected Board board;
	protected Player[] players;
	
	// Constructor.
	public Game(int numOfPlayers){
		this.players = new Player[numOfPlayers];
	}
	
	// Print the games board.
	abstract public void printBoard();
}