import AkPackage.*;
import java.util.*;

//*not solved;.
public class PartitionArrayIntoDisjointInterval {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PartitionArrayIntoDisjointInterval());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given array: " + Arrays.toString(nums));
            partitionDisjoint(nums);
        }
    }

    public static void partitionDisjoint(int nums[]) {
        int left = 0, right = nums.length - 1, lmax = 0, rmin = nums.length - 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] <= nums[left]) {
                left = i;
            }
            if (nums[i] >= nums[right]) {
                right = i;
            }
        }

        for (int i = 1; i <= left; i++)
            if (nums[i] >= nums[lmax])
                lmax = i;
        for (int i = nums.length - 2; i >= right; i--)
            if (nums[i] <= nums[rmin])
                rmin = i;

        for (int i = right - 1; i > left; i--) {
            if (nums[i] < nums[lmax]) {
                left = i;
                break;
            }

        }
        System.out.println("left: "+ left);
        System.out.println("Right: "+ right);
        System.out.println("lmax: "+ lmax);
        System.out.println("rmin: "+ rmin);
    }
}