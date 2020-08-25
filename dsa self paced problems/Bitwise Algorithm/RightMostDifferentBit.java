// Input Format:
// The input line contains T, denoting the number of testcases. Each testcase follows. First line of each testcase contains two space separated integers M and N.

// Output Format:
// For each testcase in new line, print the position of rightmost different bit in binary representation of numbers. If both M and N are same then print -1 in this case.

public class RightMostDifferentBit {
    public static void main(String[] args) {
        int m = 52, n = 52;
        System.out.println("Right Most different bit present in " + m + " and " + n + " is: " + firstSetBit(m ^ n));
    }
    public static int firstSetBit(int input) {
        if (input == 0) {
            System.out.println("All are similiar, nothing is different.");
            return -1;
        } else {
            int xor = input ^ input - 1; // ==> 01111
            int log = (int) (Math.log(xor) / Math.log(2)); // to count the number of digits, we use log operation with a
                                                           // +1
            return log+1;                                                        
        }
    }
}
// Time complexity:O(1)
