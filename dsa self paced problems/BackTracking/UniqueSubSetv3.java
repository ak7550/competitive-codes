import AkPackage.*;
import java.util.*;


public class UniqueSubSetv3 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new UniqueSubset());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            Arrays.sort(arr);
            System.out.println("For the given arr: " + Arrays.toString(arr));
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> st = new ArrayList<>();
            res.add(st);
            subset(arr, res, st, 0);
            System.out.println("After adding res: ");
            res.forEach(System.out::println);
        }
    }

    //_ right ans
    public static void subset(int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> st, int index) {
        if (index == arr.length)
            return;
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        for (int i = index; i < arr.length ; i++) {
            st.add(arr[i]); //-> add ith index

            //_ recurssive call only when we have never faced the same shit before
            if (!hs.contains(st)) {
                hs.add(new ArrayList<>(st));
                res.add(new ArrayList<>(st));
                subset(arr, res, st, i + 1);
            }
            st.remove(st.size() - 1); //-> remove the last added number
        }
    }
}