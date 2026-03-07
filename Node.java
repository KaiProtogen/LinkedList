public class Node{
	private Node next;
	private Node previous;
	private HurricaneRowData value;
	
	public Node(){}
	
	public Node(HurricaneRowData value){
		this.value = value;
	}
	
	public Node(Node next, Node previous, HurricaneRowData value){
		this.next = next;
		this.previous = previous;
		this.value = value;
	}
	
	public void getValue(){
		return value;
	}
	
	public boolean hasNext(){
		if(next != null)return true;
		else{return false;}
	}
	
	public void getNext(){
		return next;
	}
	
	public void setNext(Node newNode){
		next = newNode;
	}
	
	public boolean hasPrevious(){
		if(previous != null)return true;
		else{return false;}
	}
	
	public void getPrevious(){
		return previous;
	}
	
	public void setPrevious(Node newNode){
		previous = newNode;
	}
	
	public String toString(){
		
	}
}