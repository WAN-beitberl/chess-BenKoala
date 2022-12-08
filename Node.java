package ChessObj;
import ChessObj.Token;
class Node {
	// Declare Properties.
    private Token data;
    private Node next;
 
	// Empty Constructor.
    public Node() {
        this.next = null;
        this.data = null;
    }
	
	// Value Constructor.
    public Node(Token d, Node n) {
        this.data = d;
        this.next = n;
    }
	
	// Set next node.
    public void setNext(Node n) {
        this.next = n;
    }
 
	// Get next node.
    public Node getNext() {
        return this.next;
    }
 
	// Set token.
    public void setData(Token d) {
        this.data = d;
    }
 
	// Get token.
    public Token getData() {
        return this.data;
    }
	
	// Print list values.
	public void printList(){
		Node runner = this;
		while(runner != null && runner.data != null){
			System.out.print("->" + runner.data.getClass().getName().substring(9));
			runner = runner.getNext();
		}
		System.out.println("");
	}
}