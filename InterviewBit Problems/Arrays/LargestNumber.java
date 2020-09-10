import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import AkPackage.InputOutput;

public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestNumber());
        while (!lines.isEmpty()) {
            ArrayList<Integer> input = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For the input: " + input);
            String ans = getResult(input);
            System.out.println("Ans is: " + ans);
        }
    }

    public static String getResult(ArrayList<Integer> arr) {
        // ArrayList<Integer> a = bubbleSort(arr);
        // ArrayList<Integer> a = mergeSort(arr, 0, arr.size() - 1);
        Collections.sort(arr, new Comparator<Integer>(){
            @Override // most trickiest part of the code.. as i didn't know about it
            public int compare(Integer a, Integer b) {
                return Long.compare(Long.parseLong(b.toString() + a.toString()), Long.parseLong(a.toString()+b.toString()));
            }
        });
        StringBuilder str = new StringBuilder();
        for (Integer integer : arr) {
            str.append(integer);
        }
        if (str.charAt(0) == '0')
            return "0";
        return str.toString();
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            arr = mergeSort(arr, start, mid);
            arr = mergeSort(arr, mid + 1, end);
            arr = merge(arr, start, mid, end);
        }
        return arr;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arr, int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (compare(arr.get(i), arr.get(j))) {
                temp.add(arr.get(j++));
            } else {
                temp.add(arr.get(i++));
            }
        }
        while (i <= mid) {
            temp.add(arr.get(i++));
        }
        while (j <= end) {
            temp.add(arr.get(j++));
        }
        for (int j2 = start; j2 <= end; j2++) {
            arr.set(j2, temp.get(j2 - start));
        }
        return arr;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr) {
        boolean isSwapped = false;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (compare(arr.get(j), arr.get(j + 1))) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return arr;
            }
            isSwapped = false;
        }
        return arr;
    }

    public static boolean compare(Integer a, Integer b) {
        return Long.parseLong(a.toString() + b.toString()) < Long.parseLong(b.toString() + a.toString());
    }
}