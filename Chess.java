package ChessObj;
import ChessObj.Game;
import ChessObj.ChessBoard;
import ChessObj.ChessPlayer;
import java.util.*;
class Chess{
	
	// Declare Properties.
	private int turnCounter;
	private ChessPlayer[] players;
	private ChessBoard board;
	
	// Constructor.
	public Chess(){
		this.players = new ChessPlayer[2];
		this.board = new ChessBoard();
		this.turnCounter = 0;
	}
	
	// Set player values.
	public void setPlayer(int index, String name){
		this.players[index] = new ChessPlayer(name);
	}
	
	// Move piece on board.
	public void move(String from, String to){
		// Set logical terms (input is right, not trying to move from the same slot).
		boolean notSame =  !from.equals(to),
				inRange1 = from.charAt(0) >= 'a' && from.charAt(0) <= 'h',
				inRange2 = to.charAt(0) >= 'a' && to.charAt(0) <= 'h',
				inRange3 = from.charAt(1) >= '1' && from.charAt(1) <= '8',
				inRange4 = from.charAt(1) >= '1' && from.charAt(1) <= '8';
				
		// Set slot indexes.
		int y1 = from.charAt(0) - 'a';
		int x1 = from.charAt(1) - '1';
		int y2 = to.charAt(0) - 'a';
		int x2 = to.charAt(1) - '1';
		
		// Check conditions.
		if (notSame && inRange1 && inRange2 && inRange4 && 
		((this.board.getBoard()[y1][x1].getColor().charAt(0) == 'w' && this.turnCounter % 2 == 0) ||
		(this.board.getBoard()[y1][x1].getColor().charAt(0) == 'b' && this.turnCounter % 2 == 1))){
			
			// Check if move is valid.
			if (this.board.getBoard()[y1][x1].isValid(from, to, this.board.getBoard())){
				// Case - goal slot is empty, move.
					if(this.board.getBoard()[y2][x2] instanceof Empty){
						this.board.getBoard()[y2][x2] = this.board.getBoard()[y1][x1];
						this.board.getBoard()[y1][x1] = new Empty("");
					}
					else {
						// Case - goal slot is occupied, eat.
						this.players[turnCounter % 2].eat(this.board.getBoard()[y2][x2]);
						this.board.getBoard()[y2][x2] = this.board.getBoard()[y1][x1];
						this.board.getBoard()[y1][x1] = new Empty("");
					}
					// Increase game clock.
						this.turnCounter++;
			}
		}
	}
	
	// Print the game board, the indexes and the captive lists.
	public void printBoard(){
		
		// Print the top layer - players and clock.
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println(this.players[0].getName() + " VS " +
		this.players[1].getName() + "\tClock: " + this.turnCounter);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		// Print top indexes - numbers.
		// Layer 1/4
		System.out.println("-------------------------------------------------------------");
		
		// Layer 2/4
		System.out.print("|=====");
		for(int j = 0; j <= 48; j++){
			if(j % 6 == 0){
				System.out.print("|");
			}
			else{
				System.out.print("=");
			}
		}
		System.out.println("=====|");
		
		// Layer 3/4
		System.out.print("|=====");
		for(int j = 0; j <= 48; j++){
			if(j % 6 == 0){
				System.out.print("|");
			}
			else{
				if(j % 6 == 3){
				System.out.print(j / 6 + 1);
				}
				else{
				System.out.print("=");
				}
			}
		}
		System.out.println("=====|");
		
		// Layer 4/4
		System.out.print("|=====");
		for(int j = 0; j <= 48; j++){
			if(j % 6 == 0){
				System.out.print("|");
			}
			else{
				System.out.print("=");
			}
		}
		
		// Print Board.
		System.out.println("=====|");
		// 8 Rows.
		for(int i = 0; i < 8; i++){
			System.out.println("-------------------------------------------------------------");
			System.out.print("|=====");
			// 48 Char length.
			for(int j = 0; j <= 48; j++){
				if(j % 6 == 0){
					System.out.print("|");
				}
				else{
					// Print cube 1/3.
					if( (j / 6) % 2 == (i % 2)){
						System.out.print("█");
					}
					else{
						System.out.print(" ");
					}
				}
			}
			System.out.println("=====|");
			System.out.print("|=====");
			
			// Print cube 2/3.
			for(int j = 0; j <= 48; j++){
				if(j % 6 == 2){
					if(this.board.getBoard()[i][j / 6] instanceof Empty){
						if( (j / 6) % 2 == (i % 2)){
							System.out.print("██");
						}
						else{
							System.out.print("  ");
						}
					}
					else{
						this.board.getBoard()[i][j / 6].printCube();
					}
					j++;
				}
				else{
					if(j % 6 == 0){
					System.out.print("|");
					}
					else{
						if( (j / 6) % 2 == (i % 2)){
							System.out.print("█");
						}
						else{
							System.out.print(" ");
						}
					}
				}
			}
			System.out.println("=="+(char)('A' + i) + "==|");
			System.out.print("|=====");
			
			// Print cube 3/3.
			for(int j = 0; j <= 48; j++){
				if(j % 6 == 0){
					System.out.print("|");
				}
				else{
					if( (j / 6) % 2 == (i % 2)){
						System.out.print("█");
					}
					else{
						System.out.print(" ");
					}
				}
			}
			System.out.println("=====|");
		}
		System.out.println("-------------------------------------------------------------");
		System.out.print("|=====");
		
		// Print Bottom.
		// Layer 1/4.
		for(int j = 0; j <= 48; j++){
			if(j % 6 == 0){
				System.out.print("|");
			}
			else{
				System.out.print("=");
			}
		}
		System.out.println("=====|");
		
		// Layer 2/4.
		System.out.print("|=====");
		for(int j = 0; j <= 48; j++){
			if(j % 6 == 0){
				System.out.print("|");
			}
			else{
				if(j % 6 == 3){
				System.out.print(j / 6 + 1);
				}
				else{
				System.out.print("=");
				}
			}
		}
		System.out.println("=====|");
		
		// Layer 3/4.
		System.out.print("|=====");
		for(int j = 0; j <= 48; j++){
			if(j % 6 == 0){
				System.out.print("|");
			}
			else{
				System.out.print("=");
			}
		}
		System.out.println("=====|");
		
		// Layer 4/4.
		System.out.println("-------------------------------------------------------------");
		
		// Print Eaten Pieces.
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Player 1 Captives");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		this.players[0].getCaptives().printList();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Player 2 Captives");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		this.players[1].getCaptives().printList();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
	
	public void setGame(){
		// Fill Black Pawns in second row.
		for(int i = 0; i < 8; i++){
			this.board.getBoard()[1][i] = new Pawn("black");
		}
		
		// Set first row with black pieces.
		this.board.getBoard()[0][0] = new Rook("black");
		this.board.getBoard()[0][7] = new Rook("black");
		this.board.getBoard()[0][1] = new Knight("black");
		this.board.getBoard()[0][6] = new Knight("black");
		this.board.getBoard()[0][2] = new Bishop("black");
		this.board.getBoard()[0][5] = new Bishop("black");
		this.board.getBoard()[0][3] = new King("black");
		this.board.getBoard()[0][4] = new Queen("black");
		
		// Fill middle board with empty slots.
		for(int i = 2; i < 6; i++){
			for(int j = 0; j < 8; j++){
				this.board.getBoard()[i][j] = new Empty("empty");
			}
		}
		
		// Fill White pawn is second from end row.
		for(int i = 0; i < 8; i++){
			this.board.getBoard()[6][i] = new Pawn("white");
		}
		
		// Fill last row with white pieces.
		this.board.getBoard()[7][0] = new Rook("white");
		this.board.getBoard()[7][7] = new Rook("white");
		this.board.getBoard()[7][1] = new Knight("white");
		this.board.getBoard()[7][6] = new Knight("white");
		this.board.getBoard()[7][2] = new Bishop("white");
		this.board.getBoard()[7][5] = new Bishop("white");
		this.board.getBoard()[7][4] = new King("white");
		this.board.getBoard()[7][3] = new Queen("white");
	}
}
