import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class QuadraticProbing {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new QuadraticProbing());
        while (!lines.isEmpty()) {
            int hashSize = Integer.parseInt(lines.remove(0));
            int arr[] = InputOutput.arrayFromString(lines.remove(0)), hash[] = new int[hashSize];
            // Arrays.fill(hash, -1);
            quadraticProbing(hash, hashSize, arr, arr.length);
            System.out.println("The input is: " + Arrays.toString(arr));
            System.out.println("After quadratic probing the hash table is: " + Arrays.toString(hash));
        }
    }

    static void quadraticProbing(int[] hash, int hash_size, int arr[], int N) {
        //Your code here
        int size = 0;
        Arrays.fill(hash, -1);
        for (int i = 0; i < N; i++) {
            if (size == hash_size)
                return;
            int val = arr[i] % hash_size;
            if (hash[val] != -1) {
                int j = 1, og=val;
                while (hash[val] != -1) {
                    int mul = j * j;
                    val = (og + mul) % hash_size;
                    j++;
                }
            }
            hash[val] = arr[i];
            size++;
        }
    }
}