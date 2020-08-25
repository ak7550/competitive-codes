class Demo
{
  public static void main(String args[])
  {
    int n=10;  
    System.out.print("0, 1, ");
    System.out.println(n+"th fibonacci number is: "+fibonacci(0, 1, n)); // already 2 numbers are taken. 0, 1
  }
  static int fibonacci(int a, int b, int n)
  {
    System.out.print(a+b+", ");
    if(n==0)
    {
        System.out.println("");
        return a;
    }
    return fibonacci(b, a+b, n-1);
  }
}

// Time Complexity: O(2^n)