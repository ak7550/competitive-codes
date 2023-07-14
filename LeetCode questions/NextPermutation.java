import AkPackage.*;
import java.util.*;


public class NextPermutation {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new NextPermutation());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For ip: " + Arrays.toString(nums));
            nextPermutation(nums);
            System.out.println("op: "+ Arrays.toString(nums));
        }
    }

    private static void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int pc = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pc = i - 1;
                break;
            }
        }

        if(pc != -1) // no pc
        {
            int p = pc + 1, max = pc + 1;
            for (int i = p + 1; i < nums.length; i++) {
                if (nums[i] > nums[pc] && nums[i] < nums[max]) {
                    max = i;
                }
            }

            int tem = nums[pc];
            nums[pc] = nums[max];
            nums[max] = tem;
            Arrays.sort(nums, pc+1, nums.length);
        }else Arrays.sort(nums);
    }
}