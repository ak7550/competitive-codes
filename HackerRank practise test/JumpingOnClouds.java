import AkPackage.*;
import java.util.*;


public class JumpingOnClouds {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new JumpingOnClouds());
        while (!lines.isEmpty()) {
            ArrayList<Integer> c = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For: " + c);
            System.out.println("Minimum number of Jumps required: " + jumpingClouds(c));
        }
    }

    public static int jumpingClouds(ArrayList<Integer> arr) {
        int pos=0, jump=0;
        while (pos < arr.size() - 1) {
            if (pos == arr.size() - 2) {
                jump++;
                break;
            }
            pos += arr.get(pos + 2) == 1 ? 1 : 2;
            jump++;
        }
        return jump;
    }
}