/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Carvans
{
	public static void main (String[] args)
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    int count=0, min=Integer.MAX_VALUE;
		    for(int i=0;i<n;i++){
		        if(arr[i]<min){
		            count++;
		            min=arr[i];
		        }
		    }
		    System.out.println(count);
		}
	}
}
