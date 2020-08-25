//given an array, need to find number has occured only a single time or less

public class FindTheOddOccuringNumber {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 1, 4, 4, 4, 2, 5, 5 }; // answer should be 4 here
        int res = 0;
        for (int i : arr) {
            res = res ^ i; // x ^ x = 0
        }
        System.out.println(res+" has occured odd times in the array.");
    }
}

// time complexity = O(arr.length)