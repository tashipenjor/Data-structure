public class Merge
{
	public static void printArray(int array[]) 
	{
		for(int i : array) 
		{
			System.out.print(i +" ");
		}
		System.out.println();
	}
	public static int []mergeSort(int array[])
	{
		if(array.length <= 1) 
		{
			return array;
		}
		//divide the array into two subarrays i.e., left and right
		int midpoint = array.length/2;
		int left[] = new int[midpoint];
		int[] right;
		//if the array size is even;
		if(array.length % 2 == 0) 
		{
			right = new int[midpoint];
		}
		//if the array size is odd
		else 
		{
			right = new int[midpoint + 1];
		}
		//placed the array list in left and right place
		for(int i = 0; i < midpoint; i++) 
		{
			left[i] = array[i];
		}
		for(int j = 0; j < right.length; j++) 
		{
			right[j] = array[midpoint + j];
		}
		// To store sorted array
		int result[] = new int[array.length];
		/* recursive function, which means it will the divide the array into many 
		subarrays until left and right array is one */
		left = mergeSort(left);
		right = mergeSort(right);
		result = merge(left, right);
		return result;
	}
	public static int[] merge(int left[], int right[]) 
	{
		int[] result = new int[left.length + right.length];
		int leftPointer,rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		/* Checking weather there is elements in left and right array. 
		if there array then it will execute through while loop */
		while(leftPointer < left.length || rightPointer < right.length) 
		{
			// condition checking at one elements in the array
			if(leftPointer < left.length && rightPointer < right.length) 
			{
				//Comparing the elements of left and right arrays
				if(left[leftPointer] < right[rightPointer]) 
				{
					//Based on true condition elements are arranging in ascending order and adding to result array
					result[resultPointer++] = left[leftPointer++];
				}
				else 
				{
					result[resultPointer++] = right[rightPointer++]; 
				}
			}
			// if there is only element in left
			else if(leftPointer < left.length) 
			{
				result[resultPointer++] = left[leftPointer++];
			}
			// if there is only element in right
			else if(rightPointer < right.length) 
			{
					result[resultPointer++] = right[rightPointer++];
			}
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		int array[] = {4,7,4,3,8};
		System.out.println("Unsorted Array : ");
		printArray(array);
		array = mergeSort(array);
		System.out.println("Sorted Array : ");
		printArray(array);
	}
}