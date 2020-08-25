/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        ArrayList<String> arr=new ArrayList<String>(T); 
        for(int i=0;i<T;i++)
			arr.add(sc.next());
		System.out.println();
        for (String str : arr) {
            System.out.println(lapindrome(str));
        }
        sc.close();
	}
	public static boolean lapindrome(String str)
	{
        System.out.println("The string is: "+str);
        int endIndex=(str.length()/2)-1;
        // String right=new String(str.substring(endIndex+1));
        char left[]=new char[str.length()/2], right[]=new char[str.length()/2];
        str.getChars(0, endIndex+1, left, 0);
        endIndex=(str.length()%2==0)?endIndex+1:endIndex+2;
        str.getChars(endIndex, str.length(), right, 0); // works fine
        Arrays.sort(left);
        Arrays.sort(right);
        System.out.println("Left part is: "+left.toString()+"\nRight part is: "+right.toString());
        String l=new String(left),r=new String(right);
        System.out.println("Left part is: "+l+"\nRight part is: "+r);
        return (l.compareTo(r)==0)?true:false;
	}
}
