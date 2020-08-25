class LuckyNumber
{
  public static void main(String args[])
  {
    int n=101;
    boolean res=lucky(n);
    if(res==true)
      System.out.println(n+" is lucky number.");
    else
      System.out.println(n+" is not a lucky number");
  }
  static boolean lucky(int n)
  {
    return isLucky(n,2);
  }
  static boolean isLucky(int n, int counter)
  {
    if(counter>n)
      return true;
    if(n%counter==0) // the most crucial condition that gives false result
      return false;
    return isLucky(n-n/counter, counter+1);
  }
}