public class MaxCutPractise {
    public static void main(String[] args) {
        int n = 23, a = 11, b = 12, c = 9;
        System.out.println("Max cuts are: " + maxCut(n, a, b, c));
    }

    public static int maxCut(int n, int a, int b, int c) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int res = max(maxCut(n - a, a, b, c), maxCut(n - b, a, b, c), maxCut(n - c, a, b, c));
        return (res != -1) ? res + 1 : -1;
    }

    static int max(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        if(max<a)
            max = a;
        if(max<b)
            max = b;
        if(max<c)
            max = c;
        return max;
    }
}

// time complexity: O(3^n)