import java.util.Arrays;

public class ExtendedEuclidianAlgorithmToFindGCDAndXandY {
    public static void main(String[] args) {
        int a = 200, m = 29;
        int arr[] = gcdExtended(a, m);
        if (arr[0] != 1) {
            System.out.println("gcd of" + a + " and" + m + "is: " + arr[0] + "\n" + a + " and" + m
                    + " are not coprime with each other. Not possible to find modular arithmatic inverse");
        } else {
            System.out.println("x is : " + arr[1] + "\ny is: " + arr[2]);
            int res = (arr[2] % m + m) % m;
            System.out.println("Modular arithmatic inverse of " + a + " is: " + res + " with respect to " + m);
            System.out.println("Modulo Result is: " + (a * res) % m);
        }
    }

    public static int[] gcdExtended(int a, int b) {
        int[] arr = new int[3];
        if (b == 0) {
            arr[0] = a;
            arr[1] = 0; // x
            arr[2] = 1; // y
            return arr;
        }
        arr = gcdExtended(b, a % b);
        int x1 = arr[1], y1 = arr[2];
        arr[1] = (int) (y1 - Math.floor(a / b) * x1);
        arr[2] = x1;
        System.out.println("The array is: " + Arrays.toString(arr));
        return arr;
    }
}