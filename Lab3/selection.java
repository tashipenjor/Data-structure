import java.util.Scanner;
public class selection
{
	public static int[] sort(int[] array)
	//public static void sort(int[] array)
	{
		//array = array;
		int n = array.length;
		for (int i=0;i<n-1;i++) 
		{
			int smallest = i;
			//for (int j=i;j>0 && compare(j,j+1,array);j--)
			for (int j=i;j<n;j++)
			{
				if(array[j] < array[smallest])
					smallest = j;
			}
			int x = array[smallest];
			array[smallest] = array[i];
			array[i] = x;
			// {
			// 	swap(j,j+1,array);
			// }
		}
		return array;
	}
	// public static boolean compare(int a, int b, int[] array)
	// {
	// 	if (array[a]>array[b])
	// 	{
	// 		return true;
	// 	}
	// 	return false;
	// }
	// public static void swap(int a, int b, int[] array)
	// {
	// 	int temp = array[a];
	// 	array[a] = array[b];
	// 	array[b]=temp;
	// }
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the length: ");
		int len = obj.nextInt();
		int[] array = new int[len];
		System.out.println("Enter the element: ");
		for (int i=0;i<len;i++)
		{
			int b = obj.nextInt();
			array[i] = b;
		}
		// for (int j=0;j<len;j++) 
		// {
		// 	System.out.print(array[j]+" ");
		// }
		selection obj1 = new selection();
		int[] x = obj1.sort(array);
		//obj1.sort(array);
		for (int j=0;j<len;j++) 
		{
			System.out.print(x[j]+" ");
			//System.out.println(array[j]);
		}
	}
}