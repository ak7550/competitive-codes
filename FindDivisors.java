// import java.util.Arrays;

public class FindDivisors {
    public static void main(String[] args) {
        int n = 30;
        // int arr[]= new int[(int) Math.sqrt(n)];
        for (int i = 1; i <= n/i; i++) {
            if (n % i == 0) {
                // arr[count++]=i;
                System.out.print(i+" ");
                if(i!=n/i)
                {
                    // arr[count++]=n/i;
                    System.out.print(n/i+" ");
                }
            }
        }
    }
}

// 100=(1,100),(2,50),(4,25),(5,20),(10,10)
// 30= 1,30,2,15,3,30,5,6