import AkPackage.*;
import java.util.*;

class Trie {
    Trie[] arr = new Trie[2];
    int value;

    public void insert(int n) {
        Trie curr = this;
        char ch[] = Integer.toBinaryString(n).toCharArray();
        for (char c : ch) {
            if (c == '1') {
                if (curr.arr[1] == null)
                    curr.arr[1] = new Trie();
                curr = curr.arr[1];
            } else {
                if (curr.arr[0] == null)
                    curr.arr[0] = new Trie();
                curr = curr.arr[0];
            }
        }
        curr.value = n;
    }

    public int query(int n) {
        Trie curr = this;
        char ch[] = Integer.toBinaryString(n).toCharArray();
        StringBuilder str = new StringBuilder();
        for (char c : ch) {
            if (c == '1') { // as i am taking the xor, to get the max value, for any 0 or 1, i should take the complementary value
                if (curr.arr[0] == null) {
                    str.append(1);
                    curr = curr.arr[1];
                } else {
                    str.append(0);
                    curr = curr.arr[0];
                }
            } else {
                if (curr.arr[1] == null) {
                    str.append(0);
                    curr = curr.arr[0];
                } else {
                    str.append(1);
                    curr = curr.arr[1];
                }
            }
        }
        return curr.value ^ n;

    }
}


public class MaxXOR {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaxXOR());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For: " + Arrays.toString(arr));
            System.out.println("Max XOR: " + findMaxXOR(arr));
        }
    }

    public static int findMaxXOR(int arr[]) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        Trie tr = new Trie();
        for (int i : arr) {
            res = res ^ i;
            tr.insert(res);
            max = Math.max(max, tr.query(res));
        }
        return max;
    }
}