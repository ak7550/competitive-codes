// programe to find the maximum number of cuts.
class className
{
  public static void main(String args[])
  {
    int n=5,a=1,b=2,c=2;
    System.out.println("The maximum numner of cuts for the given rope is: "+maxcuts(n,a,b,c));
  }
  static int maxcuts(int n, int a, int b, int c)
  {
    if(n==0) //base case, when n=0, that means no cuts are possible now
        return n;
    if(n<0) //base case, when n=0, that means no cuts are possible now
        return -1;
    int res=max(maxcuts(n-a, a, b, c),maxcuts(n-b, a, b, c),maxcuts(n-c, a, b, c)); //we want the maximum number of cuts so we want as much small pieces are possible.
    if(res<0)
        return -1; // -ve value means this cut is not possible
    return res+1; // each function call means a cut, so we are adding +1 at the end of each call
  }
  static int max(int a, int b, int c)
  {
    int max=(a>=b)?a:b;
    return (max>=c)?max:c;
  }
}