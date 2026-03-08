public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface{
	private Node head = null;
	private Node current = null;
	
	// Moves to the front of the linked list to find the first node whose next node is null,
	// then returns that node.
	public Node getFirst(){
		while(current.getNext() != null)current = current.getNext();
		return current;
	}
	
	// Moves to the back of the linked list to find the last node whose next node is null,
	// then returns that node.
	public Node getLast(){
		while(current.getPrevious() != null)current = current.getPrevious();
		return current;
	}
	
	// Removes a node by connecting both of the nodes in between to each other,
	// then returns the removed node.
	public Node remove(HurricaneRowData toRemove){
		current = head;
		while(true){
			if(current.getValue().equals(toRemove)){
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
	
	// Inserts and sorts a node by comparing it to other nodes in the linked list.
	public void insert(HurricaneRowData newValue){
		Node newNode = new Node(newValue);
		
		// Makes the current node the one being inserted if the list is empty.
		if(current == null){
			current = newNode;
			head = current;
			return;
		}
		
		// This while is used for when the value of the current node's ACE is larger or equal to newNode's ACE.
		while(current.getValue().getACE() >= newNode.getValue().getACE()){
			// When current is at the end of the list, newNode is added to the end.
			if(current.getPrevious() == null){
				current.setPrevious(newNode);
				newNode.setNext(current);
				return;
			}
			
			// When the ACE values are the same, the TotalStorms are compared to figure out the placement for the nodes.
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
			
			// The node is pulled back if the ACE is smaller than the current node but bigger than the previous node.
			if(current.getValue().getACE() > newNode.getValue().getACE() && newNode.getValue().getACE() > current.getPrevious().getValue().getACE()){
				pullNode(newNode);
				return;
			}
			current = current.getPrevious();
		}
		
		// This while is used for when the value of the current node's ACE is smaller or equal to newNode's ACE.
		while(current.getValue().getACE() <= newNode.getValue().getACE()){
			// When current is at the front of the list, newNode is added to the front.
			if(current.getNext() == null){
				current.setNext(newNode);
				newNode.setPrevious(current);
				head = newNode;
				return;
			}
			
			// When the ACE values are the same, the TotalStorms are compared to figure out the placement for the nodes.
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
			
			// The node is pushed forward if the ACE is bigger than the current node but smaller than the next node.
			if(current.getValue().getACE() < newNode.getValue().getACE() && newNode.getValue().getACE() < current.getNext().getValue().getACE()){
				pushNode(newNode);
				return;
			}
			current = current.getNext();
		}
	}
	
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
	
	// Uses getByValue to see if the value is found in the list.
	// Returns true or false depending on whether or not it's in the list.
	public boolean contains(HurricaneRowData value){
		return getByValue(value) != null;
	}
	
	// Searches through the list looking for a node with the same value as the input.
	// Returns null if it doesn't find a node with the value, otherwise it returns the node.
	public Node getByValue(HurricaneRowData value){
		current = head;
		while(current != null){
			if (current.getValue().equals(value)) return current;
			current = current.getPrevious();
		}
		current = head;
		return null;
	}
	
	public int length(){
		int length = 0;
		current = head;
		while(current != null){
			length += 1;
			current = current.getPrevious();
		}
		current = head;
		return length;
	}
	
	// The next node from current is stored and replaced with newNode.
	// Current is linked as the previous node from newNode.
	// The current node is then updated to be set as the node from storage.
	// The previous node from current is then set to newNode.
	// Finally, newNode is linked as the previous node to current.
	private void pushNode(Node newNode){
		Node storage = null;
		storage = current.getNext();
		current.setNext(newNode);
		newNode.setPrevious(current);
		current = storage;
		current.setPrevious(newNode);
		newNode.setNext(current);
	}
	
	// The previous node from current is stored and replaced with newNode.
	// Current is linked as the next node from newNode.
	// The current node is then updated to be set as the node from storage.
	// The next node from current is then set to newNode.
	// Finally, newNode is linked as the next node to current.
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