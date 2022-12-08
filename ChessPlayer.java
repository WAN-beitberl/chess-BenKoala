package ChessObj;
import ChessObj.Player;
import ChessObj.Node;
class ChessPlayer extends Player{
	// Declare Properties.
	private int bestTime;
	private Node captives;
	
	// Constructor.
	public ChessPlayer(String name){
		super(name);
		this.captives = new Node();
		
	}
	
	// Eat the other player's piece.
	public void eat(Token captive){
		// Get captive into a node.
		Node n = new Node(captive, null);
		
		// Case - first captive.
		if(this.captives == null){
			this.captives = n;
		}
		else{
			n.setNext(this.captives);
			this.captives = n;
		}
		
		// Print message.
		System.out.println(captive.getClass().getName().substring(9) + " Was Eaten...");
	}
	
	// Get the list of eaten pieces.
	public Node getCaptives(){
		return this.captives;
	}
		
}