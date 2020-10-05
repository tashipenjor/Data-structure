public class Resize
{
	static int[] enroll;
	static int[] roll;
	public static void main(String[] args)
	{
		enroll= new int[3];
		enroll[0]=1;
		enroll[1]=2;
		enroll[2]=3;

		int[] revalue=resize(4);

		for(int j=0;j<revalue.length;j++)
		{
			System.out.println(revalue[j]);
		}
	}
	public static int[] resize(int n)
	{
		roll = new int[n];
		for (int i=0;i<enroll.length;i++) 
		{
			roll[i]=enroll[i];
		}
		roll[n-1]=4;
		return roll;
	}
}