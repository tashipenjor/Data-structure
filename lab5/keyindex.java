//import java.util.Scanner;
public class keyindex
{
	public static void index(int[] array)
	{
		int N = array.length;
		int R =256;
		int[] aux = new int[N];
		int[] count = new int[R+1];

		//Compute frequency counts.
		for (int i = 0; i < N; i++)
		{
 			count[array[i] + 1]++;	
 		}

 		//Transform counts to indices.
 		for (int r = 0; r < R; r++)
 		{
 			count[r+1] += count[r];
 		}

 		//Distribute the data.
 		for (int i = 0; i < N; i++)
 		{
 			aux[count[array[i]]++] = array[i];
 		}
 		
 		//Copy back.
 		for (int i = 0; i < N; i++)
 		{
 			array[i] = aux[i];
 		}

 		//printing the sorted values
		for (int i = 0; i < N; i++)
		{
			System.out.print(array[i]+" ");
		}
	}
	public static void main(String[] args) 
	{
		int[] array = {1,2,3,4,5,2};
		index(array);
	}
}
// {
// 	public static void index(int[] array)
// 	{
// 		int n = array.length;
// 		int counts=0;

// 		int[] b;
// 		for (int i=0;i<enroll.length;i++) 
// 		{
// 			roll[i]=enroll[i];
// 		}
// 		roll[n-1]=4;
// 		return roll;

// 	//Compute frequency counts.
// 	//Transform counts to indices.
// 	//Distribute the data.
// 	//Copy back.
// 	}
// 	public static void main(String[] args) 
// 	{
// 		Scanner obj = new Scanner(System.in);
// 		System.out.println("Enter the size ");

// 		int size = obj.nextInt();

// 		int[] array = new int[size];

// 		System.out.println("Enter the elements ");

// 		for (int i=0;i<size;i++ ) 
// 		{
// 			int a = obj.nextInt();
// 			array[i] = a;
// 		}

// 		for (int j=0;j<size;j++ ) 
// 		{
// 			System.out.print(array[j]+ " ");
// 		}
// 	}

// 	index(array);
// }

	