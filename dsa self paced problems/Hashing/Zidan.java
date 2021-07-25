import AkPackage.*;
import java.util.*;


public class Zidan {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new Zidan());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println(Arrays.toString(arr));
        }
    }
}