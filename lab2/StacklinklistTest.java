public class StacklinklistTest
{
	public static void main(String[] args) {
		Stacklinklist obj = new Stacklinklist();
		obj.push(1);
		obj.push(2);
		// System.out.println(obj.size());
		// System.out.println(obj.pop());
		// System.out.println(obj.size());
		// System.out.println(obj.head.getElement());
		// System.out.println(obj.tail.getElement());
		assert(obj.size()==1);
		assert(obj.isEmpty()==false);
		assert(obj.top()==2);
		assert(obj.pop()==2);
		System.out.println("All TextCases are Passed");
	}
}