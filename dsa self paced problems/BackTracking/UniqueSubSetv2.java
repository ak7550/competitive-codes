import AkPackage.*;
import java.util.*;

public class UniqueSubSetv2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new UniqueSubset());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given arr: " + Arrays.toString(arr));
            HashSet<ArrayList<Integer>> hs = new HashSet<>();
            subset(arr, new ArrayList<>(), hs, 0);
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            res.addAll(hs);
            // Collections.sort(res, (a, b) -> {
            // if (a.size() < 1)
            // return a.size() - b.size();
            // else {
            // for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            // if (a.get(i) != b.get(i))
            // return a.get(i) - b.get(i);
            // }
            // return a.size() - b.size();
            // }
            // });
            System.out.println("After adding res: ");
            res.forEach(System.out::println);
        }
    }

    public static void subset(int arr[], ArrayList<Integer> st, HashSet<ArrayList<Integer>> hs, int index) {
        if (index == arr.length) {
            ArrayList<Integer> r = new ArrayList<>(st);
            // Collections.sort(r);
            hs.add(r);
            return;
        }

        // -> dont add the indexed number
        subset(arr, st, hs, index + 1);

        // -> add the number
        st.add(arr[index]);
            subset(arr, st, hs, index + 1);

        // -> remove the number
        st.remove(st.size() - 1);
    }
}