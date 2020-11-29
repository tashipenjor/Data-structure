import java.util.Scanner;
public class insertion 
{
	public static int[] inserting(int[] array)
	{
		array = array;
		for (int i=1;i<array.length;i++) 
		{
			for (int j=i;j>0 && compare(j-1,j,array) ;j--)
			{
				swap(j-1,j,array);
			}
		}
		return array;
	}
	public static boolean compare(int k, int l, int[] array)
	{
		
		if(array[l]<array[k])
		{
			return true;
		}
		return false;
	}
	public static void swap(int a, int b, int[] array)
	{
		int x = array[a];
		array[a] = array[b];
		array[b] =x;
	}

	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the size of an array: ");
		int size = obj.nextInt();
		int[] array = new int[size];
		//int[] array = {11,2,3};
		System.out.println("Enter your element: ");
		for (int i=0;i<size;i++)
		{
			int a = obj.nextInt();
			array[i] = a;
		}
		for (int j=0;j<size;j++) 
		{
			System.out.print(array[j]+ " ");
		}
		System.out.print("\n");
		insertion obj1 = new insertion();
		int[] value =obj1.inserting(array);
		System.out.println("The sorted array: ");
		for (int j=0;j<array.length;j++) 
		{
			System.out.print(value[j]+ " ");
		}
	}
}