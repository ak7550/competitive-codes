public class BinaryToGrayCode {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Gray code value of " + n + " is: " + convertToGray(n));
    }

    public static int convertToGray(int n) {
        int rightShift = n >> 1;
        return n ^ rightShift;
    }
}

// Time complexity: O(1)