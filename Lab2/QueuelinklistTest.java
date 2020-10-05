public class QueuelinklistTest{
	public static void main(String[] args) {
		Queuelinklist obj = new Queuelinklist();
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);

		assert(obj.size()==3);
		assert(obj.isEmpty()==false);
		assert(obj.first()==1);
		assert(obj.dequeue()==1);
		System.out.println("All Testcases are passed");

		// System.out.println(obj.size());
		// System.out.println(obj.dequeue());
		// System.out.println(obj.size());
	}
}