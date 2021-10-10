import AkPackage.*;
import java.util.*;

public class TwoOutOfThree {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TwoOutOfThree());
        while (!lines.isEmpty()) {
            int nums1[] = InputOutput.arrayFromString(lines.remove(0)),
                    nums2[] = InputOutput.arrayFromString(lines.remove(0)),
                    nums3[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("Ans: " + twoOutOfThree(nums1, nums2, nums3));
        }
    }

    public static List<Integer> twoOutOfThree(int nums1[], int nums2[], int nums3[]) {
        int count[] = new int[101];
        for (int x : Arrays.stream(nums1).distinct().toArray())
            count[x]++;
        for (int x : Arrays.stream(nums2).distinct().toArray())
            count[x]++;
        for (int x : Arrays.stream(nums3).distinct().toArray())
            count[x]++;

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            if (count[i] >= 2)
                ans.add(i);

        return ans;
    }
}