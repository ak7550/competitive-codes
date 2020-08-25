/**
 * josepheus problem
 */
class Josepheus
{
    public int josepheus(int n, int k)
    {
        if(n==1)
            return 0;
        int p=((this.josepheus(n-1,k)+k)%n);
        System.out.println("For the value of n="+n+" the return value is: "+p);
        return p;
    }
    
}
class kuch
{
  public static void main(String args[])
  {
    Josepheus j=new Josepheus();
    System.out.println("Answer is: "+j.josepheus(5,3));
  }
}