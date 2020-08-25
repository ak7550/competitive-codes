class sub
{
  public static void main(String args[])
  {
    String st="abc";
    sub.subset("",0,st);
  }
  static void subset(String pr, int index, String st)
  { 
    if(index!=st.length())
    {
        subset(pr, index+1, st);
        subset(pr+st.charAt(index+1), index+1, st);
    }
    System.out.print(pr+",\t");
  }
}