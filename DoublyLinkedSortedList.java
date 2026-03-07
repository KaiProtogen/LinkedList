public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	private Node head = null;
	private Node tail = null;
	private Node current = null;
	
	//Return a reference to the first Node in the list
	public Node getFirst(){
		while(current.next != null)current = current.next;
		return current;
	}
	
	//Return a reference to the last Node in the list
	public Node getLast(){
		while(current.prev != null)current = current.prev;
		return current;
	}
	
	//Remove the Node that has toRemove as its value
	public Node remove(HurricaneRowData toRemove){
		current = head;
		while(true){
			if(current.value == toRemove){
				Node removeStorage = current;
				current.next.prev = current.prev;
				current.prev.next = current.next;
				current = current.prev;
				return removeStorage;
			}
			if(current.prev == null)return null;
			current = current.prev;
		}
	}
	
	//Insert a new Node with the given newValue into the list in order.
	public void insert(HurricaneRowData newValue){
		Node storage = null;
		Node newNode = new Node(newValue);
		
		if(current == null){
			current = newNode;
			return;
		}
		
		while(current.value.getACE() > newNode.value.getACE()){
			if(current.prev == null){
				current.prev = newNode;
				newNode.next = current;
				tail = newNode;
				return;
			}
			
			if(current.value.getACE() > newNode.value.getACE() && newNode.value.getACE() > current.prev.value.getACE()){
				storage = current.prev;
				current.prev = newNode;
				newNode.next = current;
				current = storage;
				current.next = newNode;
				newNode.prev = current;
				return;
			}
			current = current.prev;
		}
		while(current.value.getACE() < newNode.value.getACE()){
			if(current.next == null){
				current.next = newNode;
				newNode.prev = current;
				head = newNode;
				return;
			}
			
			if(current.value.getACE() < newNode.value.getACE() && newNode.value.getACE() < current.next.value.getACE()){
				storage = current.next;
				current.next = newNode;
				newNode.prev = current;
				current = storage;
				current.prev = newNode;
				newNode.next = current;
				return;
			}
			current = current.next;
		}
	}
	
	//Return the entire list as a multi-line String
	public String toString(){
		
	}
}