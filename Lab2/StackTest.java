public class StackTest
{
	public static void main(String[] args) {
		Stack obj = new Stack(8);
		obj.push(1);
		assert(obj.size()==1);
		assert(obj.isEmpty()==false);
		assert(obj.top()==1);
		assert(obj.pop()==1);
		System.out.println("All TextCases are Passed");
	}
}