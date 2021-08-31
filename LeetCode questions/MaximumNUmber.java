import AkPackage.*;
import java.util.*;


public class MaximumNUmber {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MaximumNUmber());
        while (!lines.isEmpty()) {
            String num = lines.remove(0);
            int change[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For the given: " + num + Arrays.toString(change));
            System.out.println("Ans is: "+ maximumNumber(num, change));
        }
    }

    public static String maximumNumber(String num, int change[]) {
        int val = Integer.parseInt(num);
        boolean start = false;
        for(int i=0; i<num.length(); i++)
        {
            if(num.charAt(i) - '0' <= change[num.charAt(i) - '0']){
                val = change(val, i, change[num.charAt(i) - '0']);
                start = true;
            } else if(num.charAt(i) - '0' > change[num.charAt(i) - '0'] && start){
                break;

            }
        }
        return Integer.toString(val);
    }

    public static int change (int val, int index, int digit){
        int diff = digit - Integer.parseInt(Integer.toString(val).split("")[index]);
        int len = (int)Math.floor(Math.log10(val)) ;
        len -= index;
        val+=((int)Math.pow(10, len))*diff;
        return val;
    }
}