public class Queue
{
int array[];
int rear;
int front;
int size;

public Queue(int n)
	{
		array = new int[n];
		size = 0;
		front = -1;
		rear = -1;
	}
public int size()
{
	return size;
}
public boolean isEmpty()
{
	if(size()== 0)
	{
		return true; 
	}
	return false;
}
public int first()
{
	if(isEmpty())
	{
		return 0;
	}
	else
	{
		return array[front];
	}
}
public void enqueue(int n)
{
	if(isEmpty())
	{
		array[0] = n;
		front =0;
		rear = 0;
	}
	else
	{
		array[rear+1] = n;
		rear++;
	}
		size = size + 1;
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			front = front+1;
			size = size - 1;
			return array[front-1];
		}	
	}
}
