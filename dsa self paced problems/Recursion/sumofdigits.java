/**
 * sumofdigits
 */
public class sumofdigits {

    public static void main(String arg[])
    {
        int n=99399;
        System.out.println("Sum of the digits of "+n+" is: "+sumofdigits.fun(n));
    }
    /*public static int fun(int n)
    {
        int sum=0;
        while (n>0) {
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }*/
    public static int fun(int n)
    {
        if (n == 0)
            return 0;
        return n%10+fun(n / 10);
    }
}