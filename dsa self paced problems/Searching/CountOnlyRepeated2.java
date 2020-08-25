import java.util.Arrays;
import java.util.Scanner;

import AkPackage.CompetetiveCoding;

class Point {

    int x, y;
}
// all the elements are consequtive except the last repeated numbers.
// the number will repeat itself==> n-(arr[n-1]-arr[0])
// the task is to find the number only in O(log n) time
// it's dam clr that the number will definately lie in right side
public class CountOnlyRepeated2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arr[] = CompetetiveCoding.takeIntegerArrayInput(sc.nextInt());
        System.out.println("For Input: " + Arrays.toString(arr));
        Point p = getResult(arr);
        System.out.println("Value is: " + p.x);
        System.out.println("Count is: " + p.y);
    }

    public static Point getResult(int arr[]) {
        Point p = new Point();
        int index = search(arr, 0, arr.length - 1);
        p.x = arr[index];
        p.y = arr.length - (arr[arr.length - 1] - arr[0]);
        return p;
    }
    public static int search(int arr[], int start, int end) {
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == arr[(mid + 1) % arr.length] || (arr[mid]==arr[mid-1] && mid!=0)) {
                return mid;
            }
            if (arr[end]-arr[mid]==end-mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }
}