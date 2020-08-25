import java.util.Random;
class PossibleWords2
{  
  public static void main(String args[])
  {
    Random rand=new Random();
    int T=rand.nextInt(50);
    System.out.println("Test Cases: "+T);
    for(int i=0;i<T;i++)
    {
        System.out.println("Test Case: "+(i+1));
        System.out.println("=====================");
        int N=rand.nextInt(50);
        System.out.println("Array length: "+N+"\nThe array is: ");
        int[] arr=new int[N];
        for(int j=0;j<arr.length;j++)
        { 
            arr[j]=rand.nextInt(9);
            System.out.print(arr[j]);
        }
        System.out.println("\nCalling the methods.");
        PhoneDigits2.possibleWords2(arr, N);
    }
  }
}
class PhoneDigits2
{
  static String[] str = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  static void possibleWords2(int a[], int N) // N is the size of the array.
  {
    int buffer[]=new int[N];
    StringBuilder st=new StringBuilder(N);
    for (int i = 0; i < buffer.length; i++) 
    {
        buffer[i]=0;
        st.append(' ');
    }
    int bindex=0;
    pw3(buffer,bindex,a,st);
  }
  static void pw3(int[] buffer,int bindex, int[] a, StringBuilder st)  
  {  
    // base case
    if(buffer[0]>=str[a[0]].length())
    return;
    //we have to print the st
    if(bindex==buffer.length)
    {
      System.out.print(st+" ");
      bindex--;
      buffer[bindex]++;
    }
    
    if(buffer[bindex]== str[a[bindex]].length()) // need to check if the value at buffer[bindex] has reached to it's max level.
    {
      // increasee the previous bit by 1.
      bindex--;
      buffer[bindex]++;
      //upcoming all the bit 0.
      for(int k=bindex+1;k<buffer.length;k++)
      {
        buffer[k]=0;
        // st.setCharAt(bindex,str[a[bindex]-2].charAt(buffer[bindex]));//append in st is necessary at every step.
      }
      pw3(buffer, bindex, a, st);
    }
     // base case
     if(buffer[0]>=str[a[0]].length())
     return;
    st.setCharAt(bindex,str[a[bindex]].charAt(buffer[bindex]));//append in st is necessary at every step.
    pw3(buffer, bindex+1, a, st);
  }
}