import java.util.Arrays;
import java.util.Scanner;

import AkPackage.Array;

public class MinimumNumberInSortedAndRotatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        str = "342 383 501 644 677 678 679 681 703 755 767 791 824 851 853 916 918 924 82 83 91 100 121 122 123 142 147 155 181 182 196 230 268 323 ";
        int arr[] = Array.arrayFromString(str);
        System.out.println("The Array is: " + Arrays.toString(arr));
        System.out.println("Smallest number is: " + minNumber(arr, 0, arr.length - 1));
    }

    static long minNumber(int arr[], long low, long high) {
        high = 1;
        low = 0;
        while (arr[(int) high] > arr[(int) low]) {
            low = high;
            high = (high * 2 > arr.length - 1) ? arr.length - 1 : high * 2;
        }
        return search(arr, low, high);
    }

    static long search(int arr[], long low, long high) {

        while (high >= low) {
            long mid = low + (high - low) / 2;
            if (arr[(int) mid] < arr[(int) ((mid == 0) ? (arr.length - 1) : (mid - 1))])
                return arr[(int) mid];
            if (arr[(int) high] > arr[(int) mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}