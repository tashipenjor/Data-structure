import java.util.Scanner;
public class LinearSearch
{
	public static String search(int[] array)
	{
		int n = array.length;
		Scanner obj = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Enter the elemt for search: ");
		int x = obj.nextInt();
		for (int i=0;i<n;i++) 
		{
			int r=array[i];
			if(x==r)
			{
				return ("The target element "+r+" is found");
			}
			// //break;

			// else
			// {
			// 	System.out.println("Value is not present");
			// }
			
		}
		return ("Value is not present");
		
	}
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the size ");

		int size = obj.nextInt();

		int[] array = new int[size];

		System.out.println("Enter the elements ");

		for (int i=0;i<size;i++ ) 
		{
			int a = obj.nextInt();
			array[i] = a;
		}

		System.out.print("List of the elements present in an array: ");
		for (int j=0;j<size;j++ ) 
		{
			System.out.print(array[j]+ " ");
		}
		System.out.println(search(array)); 
	}

}
