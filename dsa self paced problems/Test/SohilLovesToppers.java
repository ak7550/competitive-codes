import java.util.ArrayList;

/**
 * SohilLovesToppers
 */
import AkPackage.*;

public class SohilLovesToppers {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteFileInput(new SohilLovesToppers());
        int index = 0, T = InputOutput.arrayFromString(lines.get(index++))[0];
        while (T-- > 0) {
            int studentsInFirstColumn = InputOutput.arrayFromString(lines.get(index))[0];
            int studentsInSecondColumn = InputOutput.arrayFromString(lines.get(index++))[1];
            System.out.println("For Test Case " + T + " Sohil should seat at: "
                    + ((sum(InputOutput.arrayFromString(lines.get(index++))) > sum(
                            InputOutput.arrayFromString(lines.get(index++)))) ? "C1" : "C2"));
        }
        InputOutput.writeTestCaseIntoFile(new SohilLovesToppers(), lines);
    }

    static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}