import AkPackage.*;
import java.util.*;

public class TripletSumWithGivenRange {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new TripletSumWithGivenRange());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)),
                    lr[] = InputOutput.arrayFromString(lines.remove(0));

            System.out.println("For given: " + Arrays.toString(arr) + "\n" + Arrays.toString(lr));
            System.out.println("Count is: " + countTriplets(arr, arr.length, lr[0], lr[1]));
        }
    }

    static int countTriplets(int arr[], int n, int l, int r) {
        Arrays.sort(arr);

        return countTriplets(arr, r) - countTriplets(arr, l-1);
    }

    static int countTriplets(int arr[], int target){
        int ans=0;
        for(int i=0; i+2<arr.length; i++){
            int start = i+1, end = arr.length-1;
            while(start<end){
                int sum = arr[i]+arr[start]+arr[end];
                if(sum>target)end--;
                else{
                    ans += (end - start);
                    start++;
                }
            }
        }

        return ans;
    }
}