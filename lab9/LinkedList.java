public class LinkedList{
	Node head;
	Node tail;
	int size;
//making of head, tail and size of linkedlist.
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
//to see the size of linkedlist
	public int size(){
		return size;
	}
//given size is true or flase
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}
		return false;
	}
	//getting the element of first node
	public int first(){
		return head.getElement();
	}
	//getting the element of last node
	public int last(){
		return tail.getElement();
	}

	// adding of element in the first node.
	public void addFirst(int n){
		Node newest = new Node(n, null);

		if (size == 0) {
			 head = newest;
			 tail = newest;
		}

		else{
			newest.setNext(head);
			head = newest;
		}
		size = size + 1;
	}

	//adding of element in the last node 
	public void addLast(int n){
		Node newest = new Node(n, null);
		if (size == 0) {
			head = newest;
			tail = newest;
		}
		else{
			tail.setNext(newest);
			tail =newest;
		}
		size += 1;
	}

	//removing element of the first node
	public int removeFirst(){
		int deletedElement = head.getElement();
		if (size == 0) {
			return 0;
		}
		else{
			head = head.getNext();
			size = size -1;
		}
		return deletedElement;
	}

}

class Node{
	private int element;
	private Node next;
	// constructor
	public Node(int element, Node next ){
	    this.element = element;
		this.next = next;
	}

	// getElement
	public int getElement(){
		return element;
	}

	// getNext()
	public Node getNext(){
		return next;
	}

	//set the element in the node
	public void setElement(int n){
		element = n;
	}

	//set the element in next node
	public void setNext(Node n){
		next = n;
	}
}