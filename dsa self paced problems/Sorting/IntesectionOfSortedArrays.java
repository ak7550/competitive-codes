import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class IntesectionOfSortedArrays {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new IntesectionOfSortedArrays());
        while (!lines.isEmpty()) {
            int arr1[] = InputOutput.arrayFromString(lines.remove(0)),
                    arr2[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For Input1: " + Arrays.toString(arr1) + "\nFor Input2: " + Arrays.toString(arr2)
                    + "\nInterection is: " + getIntersection(arr1, arr2));
        }
    }

    public static ArrayList<Integer> getIntersection(int arr1[], int arr2[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i]<arr2[j]) 
                i++;
            else if (arr1[i] == arr2[j]) {
                if (arr.size()==0) {
                    arr.add(arr1[i]);
                }
                if(arr1[i]!=arr.get(arr.size()-1))  
                    arr.add(arr1[i]);
                i++;
                j++;
            }
            else
                j++;
        }
        return arr;
    }
}
