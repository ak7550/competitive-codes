public class MaximumANDWithinAnArray {
    public static void main(String[] args) {
        int arr[] = { 4, 8, 12, 16 };
        System.out.println("Maximum AND value is: " + maxAnd(arr));
    }

    public static int maxAnd(int[] arr) {
        int res = 0, count = 0;
        for (int i = 31; i >= 0; i--) {
            count = countSetBit(res | (1 << i), arr);
            if (count >= 2) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    public static int countSetBit(int pattern, int[] arr) {
        int count = 0;
        for (int i : arr) {
            if ((pattern & i) == pattern)
                count++;
        }
        return count;
    }
}

// time complexity: O(n)