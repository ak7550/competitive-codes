import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PeakElementGFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        Random ran = new Random();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("For the array: " + Arrays.toString(arr));
        int pe = solve(arr, 0, arr.length - 1);
        System.out.println("The peak element is: " + pe);
        System.out.println("Element at peak is: " + arr[pe]);
    }

    static int solve(int a[], int l, int h) {
        if (a.length == 1)
            return 0;
        if (check(a, 0))
            return 0;
        if (check(a, a.length - 1))
            return a.length - 1;
        while (h >= l) {
            int mid = l + (h - l) / 2;
            if (check(a, mid))
                return mid;
            else {
                if (a[mid] < a[mid + 1])
                    l = mid;
                else
                    h = mid;
            }
        }
        return -1;
    }

    static boolean check(int a[], int index) {
        if (index == 0 && a[index] >= a[index + 1])
            return true;
        if (index == a.length - 1 && a[index] >= a[index - 1])
            return true;
        if (index < a.length - 1 && index > 0 && a[index] >= a[index + 1] && a[index] >= a[index - 1])
            return true;
        else
            return false;
    }
}