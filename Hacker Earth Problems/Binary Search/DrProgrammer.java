import java.util.Arrays;
import java.io.*;

//Code Link:- https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/to-do-b9cfd3e3/
public class DrProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = stdin.readLine().split(" "), secondLine = stdin.readLine().split(" "),thirdLine=stdin.readLine().split(" ");
        long nx =  Long.parseLong(firstLine[0]);
        long ny =  Long.parseLong(firstLine[1]);
        long q = Long.parseLong(firstLine[2]);
        long x[] = new long[(int)nx];
        long[] y = new long[(int)ny];
        for (int i = 0; i < x.length; i++) {
            x[i] = Long.parseLong(secondLine[i]);
        }
        for (int i = 0; i < y.length; i++) {
            y[i] = Long.parseLong(thirdLine[i]);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < q; i++) {
            String line = stdin.readLine();
            System.out.println("For line: " + line);
            System.out.println("Result is: " + getResult(line, x, y));
        }
    }

    public static int getResult(String line, long x[], long y[]) {
        String str[] = line.split(" ");
        long z = Long.parseLong(str[0]);
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
        while ( startingIndex1 < x.length && x[startingIndex1] < l1 ) {
            startingIndex1++;
        }
        while ( endingIndex1 >= 0 && x[endingIndex1] > r1) {
            endingIndex1--;
        }
        while ( startingIndex2 < y.length && y[startingIndex2] < l2) {
            startingIndex2++;
        }
        while ( endingIndex2 >= 0 && y[endingIndex2] > r2) {
            endingIndex2--;
        }

        if (startingIndex1 > endingIndex1 || startingIndex2 > endingIndex2 ) {
            return 0;
        }
        long bigArray[], smallArray[];
        if (endingIndex1 - startingIndex1 + 1 >= endingIndex2 - startingIndex2 + 1) {
            bigArray = x;
            smallArray = y;
            int temp1 = startingIndex1, temp2 = endingIndex1;
            startingIndex1 = startingIndex2;
            endingIndex1 = endingIndex2;
            startingIndex2 = temp1;
            endingIndex2 = temp2;
        } else {
            bigArray = y;
            smallArray = x;
        }
        for (int i = startingIndex1; i <= endingIndex1; i++) {
            int res = binarySearch(bigArray, startingIndex2, endingIndex2, z - smallArray[i]);
            if (res >= 0) {
                res = res - startingIndex2 + 1;
                System.out.println(res);
                count += res;
            }
        }
        return count;
    }

    public static int binarySearch(long arr[], int s, int e, long k) {
        if (e >= 0 && arr[e] <= k)
            return e;
        if (s < e) {
            int mid = s + (e - s) / 2;
            if (mid >= 0 && arr[mid] <= k) {
                int ans = binarySearch(arr, mid + 1, e, k);
                return ans == -1 ? mid : ans;
            } else {
                return binarySearch(arr, s, mid - 1, k);
            }
        }
        return -1;
    }
}