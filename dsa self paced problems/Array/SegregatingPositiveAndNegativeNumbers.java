import java.util.Arrays;
import java.util.Random;

public class SegregatingPositiveAndNegativeNumbers {
    public static void main(String[] args) {
        int n = 12;
        int arr[] = new int[n];
        fillAraay(arr, arr.length);
        System.out.println("\nAfter filling the array is: " + Arrays.toString(arr));
        reArrange(arr);
        System.out.println("After rearranging the arrays is: " + Arrays.toString(arr));
    }

    public static void reArrange(int[] a) {
        int h[] = new int[20002];
        Arrays.fill(h, 0);
        // System.out.println("h is: " + Arrays.toString(h));
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            if (a[i] < 0) {
                temp *= -1;
                h[temp]++;
            } else {
                temp += 10000;
                h[temp]++;
            }
        }
        // System.out.println("h is: " + Arrays.toString(h));
        int count = 0;
        for (int i = 0; i <= 9999; i++) { // for negative values
            if (h[i] != 0) {
                int temp=i;
                temp*=-1;
                a[count++] = temp;
            }
            if (count == a.length) {
                break;
            }
        }
        for (int i = 10000; i <= 20001; i++) { // for positive values
            if (h[i] != 0) {
                int temp=i;
                temp-=10000;
                a[count++] = temp;
            }
            } else {
                a[i] = temp;
            }
        }
        a[a.length-1]=0;
    }
}