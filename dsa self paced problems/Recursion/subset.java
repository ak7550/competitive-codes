class Main
{
  public static void main(String args[])
  {
    StringBuffer str=new StringBuffer("abc");
    StringBuffer a=new StringBuffer("");
    Main.subset(str,0,a);
  }
  static void subset(StringBuffer str, int index, StringBuffer string) 
  {
    if(index==str.length())
    {
        System.out.println(string+", ");
        return;
    }
      subset(str, index + 1, string);
      //string.append(str.charAt(index));
      subset(str, index + 1, string.append(str.charAt(index)));
      // string.replace(index, index+1, str.sub)
    return;
  }
}