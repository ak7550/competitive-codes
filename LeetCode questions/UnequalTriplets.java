import AkPackage.*;
import java.util.*;


public class UnequalTriplets {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new UnequalTriplets());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For ip: " + Arrays.toString(nums));
            System.out.println("op: "+ unequalTriplets(nums));
        }
    }

    private static long unequalTriplets(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        if (count < 3)
            return 0;
        if (count == 3)
            return 1;
        if (count == 4)
            return 2;
        return (count-2) * (count - 3) * (count  - 4);
    }
}