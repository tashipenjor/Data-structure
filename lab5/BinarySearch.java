public class BinarySearch
{
	// static int target_element = 3;
	// static int[] array= {2,4,1,3,6,5,7};
	// static int n = array.length;
	public static void sort(int[] array)
	{
		int n = array.length;
		for (int i=0;i<n;i++) 
		{
			for (int j=i+1;j<n;j++) 
			{
				if(array[i]>array[j])
				{
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
			System.out.print(array[i]+" ");
		}
	}

		// public static void search()
		// {

			
		// 	System.out.println("Enter your target element: ");
		// 	for (int i=0;i<n;i++) 
		// 	{
		// 		int r = array[i];
		// 		int half = r/2;
		// 		if (half == target_element) 
		// 		{
		// 			System.out.println("target element is found");
		// 		}
		// 		else if(target_element<half)
		// 		{
		// 			for (int k=0;k<half;k++) 
		// 			{
		// 				int e = array[i];
		// 				int halve = e/2;
		// 				if(target_element==halve)
		// 				{
		// 					System.out.println("Found it");
		// 				}
		// 			}
		// 		}
		// 	}

		// }

	public static int Search(int[] a,int key, int lo,int hi)
	{
		if(hi>=lo)
		{
			int mid = (lo+hi)/2;
			if(key==a[mid])
			{
				return mid;
			}	
			else if(key<a[mid])
			{
				return Search(a,key,lo,mid-1);
			}
			else
			{
				return Search(a,key,mid+1,hi);
			}
 		}
  		return -1;
	}
		//bestcase
		// for (int i=0;i<n;i++) 
		// {
		// 	int half = n/2;
		// 	int r = array[i];
		// 	if(half==target_element)
		// 	{
		// 		System.out.println(r);
		// 	}
		// }
	public static void main(String[] args) 
	{
		int[] array= {2,4,1,3,6,5,7};
		sort(array);
		

		System.out.println(Search(array,3,1,7));	
	}
}