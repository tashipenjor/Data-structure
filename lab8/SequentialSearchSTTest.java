public class SequentialSearchSTTest{
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> obj = new SequentialSearchST<String, Integer>();
		obj.put("N",17);
		obj.put("G",23);
		obj.put("K",13);
		obj.put("D",19);
		obj.put("X",11);
		obj.delete("G");
		assert(obj.size() == 4);
		System.out.println(obj.keys());
        System.out.println(obj.isEmpty());
        System.out.println(obj.size());
        System.out.println("All Test Cases Passed");
	}
}