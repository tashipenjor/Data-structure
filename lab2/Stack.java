public class Stack
{
	int array[];
	int top;
	int size;
	public Stack(int n)
	{
		array = new int[n];
		top = -1;
		size = 0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		if(size()==0)
		{
			return true;
		}
		return false;
	}
	public int top()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			return array[top];
		}
	}

	public void push(int n)
	{
		if(isEmpty())
		{
		array[0] = n;
		top = 0;
		}
		else
		{
			array[top+1] = n;
			top++;
		}
		size = size + 1;
	}
	public int pop()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			top = top-1;
			size = size -1;
		}
		return array[top+1];
	}
}