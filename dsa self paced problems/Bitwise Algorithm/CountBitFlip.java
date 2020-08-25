// You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.

public class CountBitFlip {
    public static void main(String[] args) {
        int a=453, b=478;
        System.out.println("The number of bits need to flip is: "+ countSetBits(a^b)); // as it gives the differences as 1
    }
    public static int countSetBits(int input) {
        int table[] = new int[256];
        for (int i = 0; i < table.length; i++) {
            table[i] = (i & 1) + table[i / 2];
            System.out.println(i + " is having " + table[i] + " number of 1's in it's binary value");
        }
        // int i=input;
        int res = 0;
        while (input > 0) {
            res += table[input & 0xff];
            input=input>>8;
        }

        return res;
    }
}

// Time complexity:O(1)