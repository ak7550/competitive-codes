public class PowerOf2 {
    public static void main(String[] args) {
        int n = 246;
        System.out.println(n + " is " + (checkPowerOf2(n) ? "" : " not ") + " a power of 2");
    }

    public static boolean checkPowerOf2(int n) {
        return (n & n - 1)==0;
    }
}

// time complexity: O(1)