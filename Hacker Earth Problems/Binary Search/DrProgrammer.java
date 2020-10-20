import java.util.Arrays;
import java.util.Scanner;

//Code Link:- https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/to-do-b9cfd3e3/
public class DrProgrammer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nx = sc.nextInt();
        int ny = sc.nextInt();
        int q = sc.nextInt();
        long x[] = new long[nx];
        long[] y = new long[ny];
        for (int i = 0; i < x.length; i++) {
            x[i] = sc.nextLong();
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = sc.nextLong();
        }
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String line = sc.nextLine();
            System.out.println("For line: " + line);
            System.out.println("Result is: " + getResult(line, x, y));
        }
    }

    public static int getResult(String line, long x[], long y[]) {
        String str[] = line.split(" ");
        long z = Long.parseLong(str[0]);
        Arrays.sort(x);
        Arrays.sort(y);
        if (str[1].equals("A")) {
            return getDataC(z, x, y, Long.parseLong(str[2]), Long.parseLong(str[3]), 0, y[y.length - 1]);
        } else if (str[1].equals("B")) {
            return getDataC(z, x, y, 0, x[x.length - 1], Long.parseLong(str[2]), Long.parseLong(str[3]));
        } else {
            return getDataC(z, x, y, Long.parseLong(str[2]), Long.parseLong(str[3]), Long.parseLong(str[4]),
                    Long.parseLong(str[5]));
        }
    }

    public static int getDataC(long z, long x[], long y[], long l1, long r1, long l2, long r2) {
        int count = 0, startingIndex1 = 0, endingIndex1 = x.length - 1, startingIndex2 = 0, endingIndex2 = y.length - 1;
        while (x[startingIndex1] < l1) {
            startingIndex1++;
        }
        while (x[endingIndex1] > r1) {
            endingIndex1--;
        }
        while (y[startingIndex2] < l2) {
            startingIndex2++;
        }
        while (y[endingIndex2] > r2) {
            endingIndex2--;
        }
        for (int i = startingIndex1; i <= endingIndex1+1; i++) {
            int res = binarySearch(y, startingIndex2, endingIndex2+1, z - x[i]);
            if (res >= 0) {
                System.out.println(x[i] + ", " + y[res]);
                count++;
            }
        }
        return count;
    }

    public static int binarySearch(long arr[], int s, int e, long k) {
        int mid = s + (e - s) / 2;
        if (arr[mid] <= k)
            return mid;
        if (s <= e) {
            return binarySearch(arr, s, mid - 1, k);
        }
        return -1;
    }

}