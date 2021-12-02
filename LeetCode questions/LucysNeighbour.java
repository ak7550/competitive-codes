import AkPackage.*;
import java.util.*;

public class LucysNeighbour {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LucysNeighbour());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            int inp[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given input: " + Arrays.toString(arr) + "\nx: " + inp[0] + "\nk: " + inp[1]);
            System.out.println("o/p is:" + kClosesat(arr, inp[0], inp[1]));
        }
    }

    public static ArrayList<Integer> kClosesat(int arr[], int x, int k) {

        //=> we can't pass any comparator directly while sorting an int array.
        arr = Arrays.stream(arr).boxed().sorted((a, b) -> {
            int dis = Math.abs(a - x) - Math.abs(b - x);
            return dis == 0 ? a - b : dis;
        }).mapToInt(i -> i).toArray();

        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            ans.add(arr[i]);

        Collections.sort(ans);
        return ans;
    }
}