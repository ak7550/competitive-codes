public class GrayCodeToBinary {
    public static void main(String[] args) {
        int n = 245;
        System.out.println("Binary equivalent of gray code " + n + " is: " + covertToBinary(n));
    }

    public static int covertToBinary(int n) {
        int num = n;
        while (n >= 1) {
            n = n >> 1;
            num = num ^ n;
        }
        return num;
    }
}

// time complexity: O(binary value of n)