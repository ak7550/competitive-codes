import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        int x=24;
        System.out.println("Max a,b pair: "+Arrays.toString(maxPair(x))+" for number "+x);
    }
    public static int[] maxPair(int n) {
        int[] ar=new int[2];
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0 && n/i!=i && gcd(n/i,i)==1) {
                ar[0]=i;
                ar[1]=n/i;
            }
        }
        return ar;
    }
    public static int gcd(int no, int div) {
        if (div == 0)
            return no;
        return gcd(div, no % div);
    }
}

// time complexity= O( sqrt(n)logn)