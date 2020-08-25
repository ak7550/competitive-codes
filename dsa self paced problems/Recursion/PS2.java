class PS2
{
  public static void main(String args[])
  {
    int arr[]=new int[3];
    arr[0]=2;
    arr[1]=3;
    arr[2]=4;
    PhoneDigit.possibleWords(arr, 3);
  }
}

class PhoneDigit
{
    static String[] str = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static void possibleWords(int a[], int N)
    {
        // your code here  
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
        if(buffer[0]>=str[a[0]].length()||bindex<0)
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
     if(buffer[0]>=str[a[0]].length()||bindex<0)
     return;
    st.setCharAt(bindex,str[a[bindex]].charAt(buffer[bindex]));//append in st is necessary at every step.
    pw3(buffer, bindex+1, a, st);
  }
}
