package ChessObj;
class Player{
	
	// Declare Properties.
	private int wins;
	private String name;
	
	// Constructor.
	public Player(String name){
		this.name = name;
		this.wins = 0;
	}
	
	// Get player name.
	public String getName(){
		return this.name;
	}
}