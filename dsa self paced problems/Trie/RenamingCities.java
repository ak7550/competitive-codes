import AkPackage.*;
import java.util.*;


public class RenamingCities {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new RenamingCities());
        while (!lines.isEmpty()) {
            String arr[] = lines.remove(0).split(" ");
            System.out.println("For: " + Arrays.toString(arr));
        }
    }
}