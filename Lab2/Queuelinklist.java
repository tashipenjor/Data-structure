public class Queuelinklist
{
	Node head;
	Node tail;
	int size;

	public Queuelinklist()
	{
		head = null;
		tail = null;
		size = 0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		if(size()==0)
		{
			return true;
		}
		return false;
	}
	public void enqueue(int n){
		Node newest = new Node(n, null);
		if(isEmpty()){
			head = newest;
			tail =newest;
		}else{
			tail.setNext(newest);
			tail = newest;
		}
		size++;
	}
	public int first(){
		if(isEmpty()){
			return 0;
		}else{
			return head.getelement();
		}
	}

	public int dequeue(){
		int first = head.getelement();
		if(isEmpty()){
			return 0;
		}
		head = head.getnext();
		size--;
		return first;
	}
}
class Node
{
	private int element;
	private Node next;
	public Node(int element, Node next)
	{
		this.element = element;
		this.next = next;

	}
	public int getelement(){
		return element;
	}
	public void setElement(int n){
		element = n;
	}
	public Node getnext(){
		return next;
	}
	public void setNext(Node n){
		next = n;
	}
}