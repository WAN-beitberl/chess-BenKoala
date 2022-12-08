package ChessObj;
abstract class Token{
	
	// Declare Properties.
	protected int size;
	protected String color;
	protected String shape;
	
	// Constructor.
	public Token(int size, String color, String shape){
		this.size = size;
		this.color = color;
		this.shape = shape;
	}
	
	// Check if a move can be played.
	abstract public boolean isValid(String from, String to, Token[][] board);
	
	// Print the letter that resembles the piece.
	abstract public void printCube();
	
	// Get color name.
	public String getColor(){
		return this.color;
	}
}
	
	