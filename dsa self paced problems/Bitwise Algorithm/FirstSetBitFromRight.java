/**
 * FirstSetBitFromRight
 */
public class FirstSetBitFromRight {

    public static void main(String[] args) {
        int input = 2; // 11000 ==> input-1== 10111
        if (input == 0) {
            System.out.println(input + " doesnot have any set bit init.");
        } else {
            int xor = input ^ input - 1; // ==> 01111
            int log = (int) (Math.log(xor) / Math.log(2)); // to count the number of digits, we use log operation with a
                                                           // +1
            System.out.println("First set bit in " + input + " is: " + (log + 1));
        }
    }
}