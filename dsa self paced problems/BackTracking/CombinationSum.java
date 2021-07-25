import AkPackage.*;
import java.util.*;

public class CombinationSum {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CombinationSum());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            int sum = InputOutput.ArrayListFromString(lines.remove(0)).remove(0);
            System.out.println("From the array: " + arr);
            System.out.println("To make the sum: " + sum);
            ArrayList<ArrayList<Integer>> res = combinationSum(arr, sum);
            System.out.println("Results are: ");
            res.forEach(System.out::println);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(arr);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            if (arr2.get(arr2.size() - 1) != arr.get(i)) //removing the repeating elements
                arr2.add(arr.get(i));
        }
        System.out.println("updated array" + arr2);
        ArrayList<Integer> st = new ArrayList<Integer>();
        combine(res, arr2, sum, st, 0);
        return res;
    }

    public static void combine(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int sum,
            ArrayList<Integer> st, int i) {

        // -> base case
        if (sum <= 0) {
            if (sum == 0)
                res.add(new ArrayList<>(st));
            // -> passing a new instance of st, as the st reference will update eventually
            return;
        }

        // add all the numbers one by one from i to end
        for (int index = i; index < arr.size(); index++) {
            //-> add the number
            st.add(arr.get(index));
            sum -= arr.get(index);
            combine(res, arr, sum, st, index);
            // -> remove the same number
            st.remove(st.size() - 1);
            sum = sum + arr.get(index);
        }
    }
}