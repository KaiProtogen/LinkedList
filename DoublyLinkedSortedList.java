public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	private Node head = null;
	private Node tail = null;
	private Node current = null;
	
	//Return a reference to the first Node in the list
	public Node getFirst(){
		while(current.getNext() != null)current = current.getNext();
		return current;
	}
	
	//Return a reference to the last Node in the list
	public Node getLast(){
		while(current.getPrevious() != null)current = current.getPrevious();
		return current;
	}
	
	//Remove the Node that has toRemove as its value
	public Node remove(HurricaneRowData toRemove){
		current = head;
		while(true){
			if(current.getValue() == toRemove){
				Node removeStorage = current;
				current.getNext().setPrevious(current.getPrevious());
				current.getPrevious().setNext(current.getNext());
				current = current.getPrevious();
				return removeStorage;
			}
			if(current.getPrevious() == null)return null;
			current = current.getPrevious();
		}
	}
	
	//Insert a new Node with the given newgetValue() into the list in order.
	public void insert(HurricaneRowData newValue){
		Node newNode = new Node(newValue);
		
		if(current == null){
			current = newNode;
			return;
		}
		
		while(current.getValue().getACE() >= newNode.getValue().getACE()){
			if(current.getPrevious() == null){
				current.setPrevious(newNode);
				newNode.setNext(current);
				return;
			}
			
			if(current.getValue().getACE() == newNode.getValue().getACE()){
				if(current.getValue().getStormsTotal() > newNode.getValue().getStormsTotal()){
					System.out.println("total storms current: " + current.getValue().getStormsTotal());
					System.out.println("total storms new: " + newNode.getValue().getStormsTotal());
					System.out.println("pull");
					pullNode(newNode);
					return;
				}
				else{
					System.out.println("total storms current: " + current.getValue().getStormsTotal());
					System.out.println("total storms new: " + newNode.getValue().getStormsTotal());
					System.out.println("push");
					pushNode(newNode);
					return;
				}
			}
			
			if(current.getValue().getACE() > newNode.getValue().getACE() && newNode.getValue().getACE() > current.getPrevious().getValue().getACE()){
				pullNode(newNode);
				return;
			}
			current = current.getPrevious();
		}
		
		while(current.getValue().getACE() <= newNode.getValue().getACE()){
			if(current.getNext() == null){
				current.setNext(newNode);
				newNode.setPrevious(current);
				head = newNode;
				return;
			}
			
			if(current.getValue().getACE() == newNode.getValue().getACE()){
				if(current.getValue().getStormsTotal() > newNode.getValue().getStormsTotal()){
					pullNode(newNode);
					return;
				}
				else{
					pushNode(newNode);
					return;
				}
			}
			
			if(current.getValue().getACE() < newNode.getValue().getACE() && newNode.getValue().getACE() < current.getNext().getValue().getACE()){
				pushNode(newNode);
				return;
			}
			current = current.getNext();
		}
	}
	
	//Return the entire list as a multi-line String
	public String toString(){
		current = head;
		String fullList = "";
		while(true){
			if(current.getPrevious() != null){
				fullList += current + "\n";
				current = current.getPrevious();
			}
			else{
				fullList += current;
				break;
			}
		}
		return fullList;
	}
	
	private void pushNode(Node newNode){
		Node storage = null;
		storage = current.getNext();
		current.setNext(newNode);
		newNode.setPrevious(current);
		current = storage;
		current.setPrevious(newNode);
		newNode.setNext(current);
	}
	
	private void pullNode(Node newNode){
		Node storage = null;
		storage = current.getPrevious();
		current.setPrevious(newNode);
		newNode.setNext(current);
		current = storage;
		current.setNext(newNode);
		newNode.setPrevious(current);
	}
}