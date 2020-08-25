class PossibleWords
{
  static String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  public static void main(String args[])
  {
    int N=3;
    int[] arr=new int[N];
    arr[0]=7;
    arr[1]=8;
    arr[2]=9;
    possibleWords2(arr, N);
  }
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
    if(buffer[0]>=str[a[0]-2].length())
    return;
    //we have to print the st
    if(bindex==buffer.length)
    {
      System.out.print(st+" ");
      bindex--;
      buffer[bindex]++;
    }
    
    if(buffer[bindex]== str[a[bindex]-2].length()) // need to check if the value at buffer[bindex] has reached to it's max level.
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
     if(buffer[0]>=str[a[0]-2].length())
     return;
    st.setCharAt(bindex,str[a[bindex]-2].charAt(buffer[bindex]));//append in st is necessary at every step.
    pw3(buffer, bindex+1, a, st);
  }
}