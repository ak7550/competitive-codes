public class KthBitSet {
    public static void main(String[] args) {
        int n = 45, k = 2;
        System.out.println("In " + n + ", " + k + "th bit is " + (checkKthBitSet(n, k) ? "" : "not ") + "set.");
    }

    public static boolean checkKthBitSet(int n, int k) {
        return (n & 1 << (k - 1)) != 0;
    }
}