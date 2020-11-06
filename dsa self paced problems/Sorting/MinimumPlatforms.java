import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class MinimumPlatforms {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumPlatforms());
        while (!lines.isEmpty()) {
            int arrival[] = InputOutput.arrayFromString(lines.remove(0)),
                    departure[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input: \n" + Arrays.toString(arrival) + "\n" + Arrays.toString(departure));
            System.out.println("Minimum Platforms are: " + getResult(arrival, departure));
        }
    }
    public static int getResult(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, platform = 0, maxPlatform = Integer.MIN_VALUE;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            }  else {
                platform--;
                j++;
            }
            maxPlatform = Math.max(maxPlatform, platform);
        }
        return maxPlatform;
    }
}
