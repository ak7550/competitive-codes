/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Reverse
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<Integer>(T); 
        for(int i=0;i<T;i++)
			arr.add(sc.nextInt());
		System.out.println();
        for (Integer integer : arr) {
            reverse(integer);
        }
        sc.close();
	}
	public static void reverse(int n)
	{
		boolean zero=true;
		do
	    {
	        int remainder=n%10;
			if(remainder!=0)
				zero=false;
			if(!(zero==true && remainder==0))
				System.out.print(remainder);
	        n/=10;
        }while(n>0);
		// sc.close();
		System.out.println();
	}
}

