public class QueueTest
{
	public static void main(String[] args) 
	{
		Queue obj = new Queue(8);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(7);
		obj.enqueue(7);
		obj.enqueue(9);
		assert(obj.size()==5);
		assert(obj.isEmpty()==false);
		assert(obj.first()==2);
		assert(obj.dequeue()==2);
		System.out.println("All Testcases are passed");
		
		// System.out.println(obj.size());
		// System.out.println(obj.isEmpty());
		// System.out.println(obj.first());
		// System.out.println(obj.dequeue());

	}
}