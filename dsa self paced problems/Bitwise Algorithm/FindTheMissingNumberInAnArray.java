// if the array length is n. then it contains values in the range of 1 to n+1 missing only one number from 1 to n+1. you have to find that missing number

public class FindTheMissingNumberInAnArray {
    public static void main(String[] args) {
        // take xor of all the numbers, then xor the result with 1 to n+1, the remaining
        // will be the ans
        int arr[] = { 1, 3, 4 };
        int res = 0, n = arr.length;
        for (int i : arr) {
            res = res ^ i;
        }
        for (int i = 1; i <= n + 1; i++) {
            res = res ^ i;
        }
        System.out.println("The missing number is: " + res);
    }
}