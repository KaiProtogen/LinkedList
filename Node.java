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
	
	public HurricaneRowData getValue(){
		return value;
	}
	
	public boolean hasNext(){
		if(next != null)return true;
		else{return false;}
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node newNode){
		next = newNode;
	}
	
	public boolean hasPrevious(){
		if(previous != null)return true;
		else{return false;}
	}
	
	public Node getPrevious(){
		return previous;
	}
	
	public void setPrevious(Node newNode){
		previous = newNode;
	}
	
	public String toString(){
		return String.format("%10d%11d%11d%11d%11d", value.getYear(), value.getACE(), value.getStormsTotal(), value.getHurricanesTotal(), value.getHurricanesMajor());
	}
}