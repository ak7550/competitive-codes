import AkPackage.Array;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        String str = ""; // just to take inputs
        int[] arr = Array.arrayFromString(str);
        Arrays.sort(arr);
        System.out.println("multiplied result of highest 3 values are: "+(arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3]));
    }

}