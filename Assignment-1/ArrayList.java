import java.lang.*;
import java.util.*;
public class ArrayList<T>
{
	Object array[];
	int size;
	int length;
	int oneOverFourFull;
	int threeOverFourFull;
	
	public ArrayList(int n)
	{
		length = n;
		array = new Object[length];
		size = 0;
		oneOverFourFull = Math.round((25*length)/100);
		threeOverFourFull = Math.round((75*length)/100);
	}
	public void add(T ele, Object[] array)
	{
		if (size == 0)
		{
			array[size] = ele;
		}
		else
		{
			array[size] = ele;
		}
		size++;
	}
	public void pop()
	{
		if (size>0)
		{
			array[size-1] = 0;
			size --;
		}
		
	}
	public void resize()
	{
		if(size == oneOverFourFull)
		{
			Object[] newarray =new Object[length/2];

			for (int i=0;i<size;i++) 
			{
				newarray[i] = array[i];
			}
			length = length/2;
			array = newarray;
		}
		if(size == threeOverFourFull)
		{
			Object[] newarray = new Object[length*2];

			for (int j=0;j<size;j++) 
			{
				newarray[j] = array[j];
			}
			length = length*2;
			array = newarray;
		}
		
	}
	public int size()
	{
		return length;
	}
	public String toString()
	{
		String s = Arrays.toString(array);
		return s;
		
	}

	public static void main(String[] args) 
	{
		ArrayList<Integer> obj = new ArrayList<>(10);
		obj.add(1, obj.array);
		obj.add(2, obj.array);
		obj.add(3, obj.array);
		obj.add(4, obj.array);
		obj.add(5, obj.array);
		obj.add(6, obj.array);
		obj.add(7, obj.array);
		obj.add(8, obj.array);


		// //The Total array
		// for (int i=0;i<obj.size;i++) 
		// {
		// 	System.out.print(obj.array[i]+ " ");
		// }
		// System.out.print("\n");
		// //The total length of the array
		// System.out.println("The Total length of array: " + obj.size());
		// //Pop or deleting the array
		// obj.pop();
		// //The array after the pop or delete
		// for (int i=0;i<obj.size;i++) 
		// {
		// 	System.out.print(obj.array[i]+ " ");
		// }
		// System.out.print("\n");
		// //The length of array in a string form
		// System.out.println("The length of array return in a string form: "+obj.toString());
		// //Resizing of the array
		// obj.resize();
		// //it shows the size of array when it is in 3/4
		// System.out.println("The length of array, when the array is 3/4th full: "+obj.size());


		assert(obj.size()==10);
		obj.pop();
		//assert(obj.toString()==[1,2,3,4,5,6,7]);
		obj.resize();
		assert(obj.size()==20);
		System.out.println("All Testcases are passed. ");

	}
}