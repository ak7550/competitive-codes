import java.util.ArrayList;
class GCD
{
  public static void main(String args[])
  {
    ArrayList<Integer> arr=new ArrayList<Integer>();
    arr.add(12);
    arr.add(16);
    arr.add(64);
    arr.add(84);
    arr.add(100);
    System.out.println("GCD is: "+ gcd(arr));
   }
static int gcd(ArrayList<Integer> arr)
  {
      int g=findgcd(arr.get(0),arr.get(1));
      for(int i=2;i<arr.size();i++)
          g=findgcd(g, arr.get(i));
      return g;
  }
  static int findgcd(int a1, int b1)
  {
      int a=Math.max(a1,b1);
      int b=Math.min(a1,b1);
      while (a%b!=0) // if a%b gives a value other than 0, the loop will run
      {
          int temp=b;
          b=a%b;
          a=temp;
      }
      return b;
  }
}