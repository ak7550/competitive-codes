import java.util.Scanner;

public class LeftIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array length: ");
        int arr[] = new int[sc.nextInt()];
        System.out.println("Enter the " + arr.length + " elements one by one: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value to search: ");
        int search = sc.nextInt();
        System.out.println("The left Index of " + search + " is: " + leftIndex(arr, search, 0, arr.length - 1));
    }

    public static int leftIndex(int arr[], int s, int l, int h) {
        int m = l + (h - l) / 2;
        if (h >= l) {
            if (m == 0 && arr[m] == s) // when m=0 then finding m-1 index is gonna throw an error
                return m;
            if (arr[m] == s && arr[m - 1] != s) {
                return m;
            } else if (arr[m] < s) {
                return leftIndex(arr, s, m + 1, h);
            } else
                return leftIndex(arr, s, l, m - 1);
        }
        return -1;
    }
}