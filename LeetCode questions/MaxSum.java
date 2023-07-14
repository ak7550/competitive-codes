import AkPackage.*;
import java.util.*;


public class MaxSum {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new MaxSum());
        while (!lines.isEmpty()) {

        }
    }


    public static double findMaxSum(List<Integer> list){
        Integer max = list.stream().max((a,b) -> a-b).get();

        Integer m2 = list.stream().filter(x -> x!= max).max((a,b) -> a-b).get();


        return max+m2;
    }
}