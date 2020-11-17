import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import AkPackage.InputOutput;

public class NumbersContaining123 {
    static HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new NumbersContaining123());
        findAll();
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            Arrays.sort(arr);
            System.out.println("For input: " + Arrays.toString(arr));
            boolean flag = false;
            for (int i : arr) {
                if (mp.containsKey(i)) {
                    System.out.print(i + " ");
                    flag = true;
                }
            }
            System.out.println(flag ? "" : "-1");
        }
    }

    public static void findAll() {
        mp.put(1, 1);
        mp.put(2, 1);
        mp.put(3, 1);
        for (int i = 11; i <= 1000000; i++)
            if (check(i))
                mp.put(i, 1);

    }

    public static boolean check(int num) {
        // base case
        if (num < 10)
            return mp.containsKey(num) ? true : false;
        if (mp.containsKey(num))
            return true;
        return mp.containsKey(num % 10) ? check(num / 10) : false;
    }

}
