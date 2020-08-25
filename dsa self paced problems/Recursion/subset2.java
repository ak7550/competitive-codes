class demo
{
  public static void main(String args[])
  {
    String str="ABC";
    String curr=""; //null String
    int index=0;
    subset(curr,str,index-1);
  }
  static void subset(String curr, String str, int index)
  {
    if(index+1==str.length()) //base case reached, now print and return
    {
        System.out.println(curr);
        return;
    }
    subset(curr, str, index+1); // deciding not to include the character at that position
    subset(curr+str.charAt(index+1), str, index+1); // deciding to include the character at that position
  }
}