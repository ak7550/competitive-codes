public class SparseNumber {
    public static void main(String[] args) {
        int n = 3245;
        // n & n<<1 is not equal to 0 that means it's a sparse number
        System.out.println(n + " is " + (checkSparse(n) ? "" : " not ") + " a sparse number");
    }

    public static boolean checkSparse(int n) {
        return (n & n << 1) != 0;
    }
}

// Time complexity:O(1)
