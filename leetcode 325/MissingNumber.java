import AkPackage.*;
import java.util.*;


public class MissingNumber {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MissingNumber());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For ip: " + Arrays.toString(nums));
            System.out.println("for op: " + missingNumber(nums));
        }
    }

    private static int missingNumber(int nums[]){
        int res = Arrays.stream(nums).reduce(0, (r, e) -> r ^ e);

        return 0;
    }
}
