import AkPackage.*;
import java.util.*;

public class UniqueSubset {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new UniqueSubset());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given arr: " + Arrays.toString(arr));
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            HashSet<ArrayList<Integer>> hs = new HashSet<>();
            subset2(arr, res, new ArrayList<Integer>(), hs, 0);
            System.out.println("Before adding res: ");
            res.forEach(System.out::println);

            System.out.println("hashset is: "+ hs);
            for (ArrayList<Integer> arrayList : hs)
                res.add(arrayList);

            System.out.println("After adding res: ");
            res.forEach(System.out::println);






            Collections.sort(res, (a, b) -> {
                if (a.size() < 1)
                    return a.size() - b.size();
                else {
                    for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                        if (a.get(i) != b.get(i))
                            return a.get(i) - b.get(i);
                    }
                    return a.size() - b.size();
                }
            });
            System.out.println("Ans is: ");
            res.forEach(System.out::println);
        }
    }

    public static void subset(int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> st,
            HashSet<ArrayList<Integer>> hs, int index) {
        if (index == arr.length) { // base case
            ArrayList<Integer> r = new ArrayList<>(st);
            Collections.sort(r);
            if (!hs.contains(r)) {
                res.add(r);
                hs.add(r);
            }
            return;
        }

        // -> dont add the current element
        subset(arr, res, st, hs, index + 1);

        // -> add the current element
        st.add(arr[index]);

        subset(arr, res, st, hs, index + 1);

        // -> remove the current element
        st.remove(st.size() - 1);
    }

    public static void subset2(int arr[], ArrayList<ArrayList<Integer>> res, ArrayList<Integer> st,
            HashSet<ArrayList<Integer>> hs, int index) {
        if (index == arr.length) { // base case
            ArrayList<Integer> r = new ArrayList<>(st);
            Collections.sort(r);
            if (!hs.contains(r))
                hs.add(r);
        }

        // -> dont add the current element
        subset(arr, res, st, hs, index + 1);

        // -> add the current element
        st.add(arr[index]);
        subset(arr, res, st, hs, index + 1);

        // -> remove the current element
        st.remove(st.size() - 1);
    }
}