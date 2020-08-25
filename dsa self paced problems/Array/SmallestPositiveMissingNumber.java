import java.util.ArrayList;
import java.util.Arrays;
import AkPackage.InputOutput;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SmallestPositiveMissingNumber());
        int T = Integer.parseInt(lines.get(0));
        lines.remove(0);
        while (T-- > 0) {
            int length = Integer.parseInt(lines.get(0));
            lines.remove(0);
            int arr[] = InputOutput.arrayFromString(lines.get(0));
            lines.remove(0);
            System.out.println("For Input " + Arrays.toString(arr) + ": ");
            int ans = getResult(arr);
            System.out.println("Answer is: " + ans);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static int getResult(int arr[]) {
        int positiveNumbers = arr.length - segerrate(arr);
        System.out.println("After Segregation the Array is: " + Arrays.toString(arr));
        makeThemNegative(arr, positiveNumbers);
        System.out.println("After making then negative the Array is: " + Arrays.toString(arr));
        return findThePositiveIndex(arr, positiveNumbers);
    }

    public static int findThePositiveIndex(int arr[], int N) {
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1) {
                return i + 1;
            }
        }
        return N + 1;
    }

    public static void makeThemNegative(int arr[], int N) {
        for (int i = 0; i < N; i++) {
            int index = Math.abs(arr[i]);
            index--;
            if (index < arr.length) {
                arr[index] = Math.abs(arr[index]) * -1;
            }
        }
    }

    public static int segerrate(int arr[]) {
        return segerrate(arr, arr.length - 1);
    }

    public static int segerrate(int arr[], int end) {
        int pIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] <= 0) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        reverseArray(arr);
        System.out.println("nagative count is: " + pIndex);
        return pIndex;
    }

    public static void reverseArray(int validData[]) {
        for (int i = 0; i < validData.length / 2; i++) {
            swap(validData, i, validData.length - i - 1);
        }
    }

    public static void swap(int arr[], int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}