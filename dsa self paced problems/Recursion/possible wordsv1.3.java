class Number
{
  public static void main(String args[])
  {
    int [] arr= new int[3];
    arr[0]=2;
    arr[1]=3;
    arr[2]=4;
    PhoneDial.msg(arr);
  }
}
class PhoneDial
{
    static String str[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static int [] buffer, arr;
    static void msg(int[] a)
    {
      buffer=new int[a.length];
      for (int i = 0; i < buffer.length; i++) {
          buffer[i]=0;
      }
      int index=0;
      arr=a;
      generateWord(index);    
    }
    static void generateWord(int index)
    {
        //base case
        if(buffer[0]==str[arr[0]].length())
            return;
        if(index==buffer.length)//time to print and increament
        {
            print();
            index--;
            incrementPreviousBit(index);
        }
        generateWord(index+1);
    }
    static void incrementPreviousBit(int index)
    {
        //base case
        if(buffer[0]==str[arr[0]].length())
            return;
        buffer[index]=0;
        index--;
        buffer[index]++;
        if(buffer[index]==str[arr[index]].length()) // time to call the method once again
            incrementPreviousBit(index);
    }
    static void print()
    {
        //base case
        if(buffer[buffer.length-1]==str[arr[arr.length-1]].length())
            return;
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(str[arr[i]].charAt(buffer[i]));
        }
        System.out.print(" ");
        buffer[buffer.length-1]++;
        print();
    }
}