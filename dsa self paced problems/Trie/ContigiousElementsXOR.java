import AkPackage.*;
import java.util.*;

class TrieNode {
    TrieNode children[] = new TrieNode[2];

    public void insert(int num) {
        TrieNode curr = this;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            if (curr.children[bit] == null)
                curr.children[bit] = new TrieNode();
            curr = curr.children[bit];
        }
    }

    public int getMaxXor(int num) {
        TrieNode curr = this;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num & (1 << i)) == 0 ? 0 : 1;
            res = res << 1;
            if (curr.children[1 - bit] == null)
                curr = curr.children[bit]; // I am getting the same value only.
            else {
                // so I am getting the oppposite value
                curr = curr.children[1 - bit];
                res |= 1;
            }
        }
        return res;
    }

}

public class ContigiousElementsXOR {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ContigiousElementsXOR());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("\n\n\nFor: " + Arrays.toString(arr));
            System.out.println("Maximum Contigious subarray XOR: " + maxSubArrayXOR(arr));
        }
    }

    // docs: https://www.geeksforgeeks.org/find-the-maximum-subarray-xor-in-a-given-array/
    public static int maxSubArrayXOR(int arr[]) {
        int max = 0, xor = 0;
        TrieNode tr = new TrieNode();
        int preXor[] = new int[arr.length];
        tr.insert(xor);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            preXor[i] = xor;
            tr.insert(xor);
            max = Math.max(max, arr[i]);
            max = Math.max(max, xor);
        }
        System.out.println("PreXor: " + Arrays.toString(preXor));

        //=> for any prexor value present into Trie, we will find the max value from the trie => that will give the max contigious subarray xor value
        for (int i : preXor)
            max = Math.max(max, tr.getMaxXor(i));
        return max;
    }

}

// => It's good to implement trie, unserstanding the question requirement