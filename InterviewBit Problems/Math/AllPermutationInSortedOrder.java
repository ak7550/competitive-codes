import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class AllPermutationInSortedOrder {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new AllPermutationInSortedOrder());
        while (!lines.isEmpty()) {
            Integer line = InputOutput.arrayFromString(lines.remove(0))[0];
            char input[] = getCharArray(line);
            ArrayList<String> ans = findMaxMin(input);
            System.out.println("For Input: "+ Arrays.toString(input));
            System.out.println("Ans is: " + ans);
            System.out.println("Length is: "+ans.size());
        }
    }

    public static ArrayList<String> findMaxMin(char number[]) {
        ArrayList<String> ans = new ArrayList<String>();
        ans.add(getString(number));
        findMax(number, ans);
        findMin(number, ans);
        return ans;
    }

    public static void findMin(char number[], ArrayList<String> ans) {
        char store[] = new char[number.length];
        fillNumber(number, store);
        int inconsistence = 0;
        for (int i = 0; i < number.length - 1; i++) {
            char left = number[i], right = number[i + 1];
            if (right < left) {
                inconsistence = i + 1;
                break;
            }
        }
        if (inconsistence > 0) {
            int index = linearSearch(number, number[inconsistence], 0, inconsistence - 1);
            swap(number, inconsistence, index);
            reverse(number, 0, inconsistence - 1);
            ans.add(0, getString(number));
            findMin(number, ans);
        } else {
            // smallest number reached.
            return;
        }
        fillNumber(store, number);
    }

    public static void fillNumber(char source[], char[] des) {
        for (int i = 0; i < source.length; i++) {
            des[i] = source[i];
        }
    }

    public static void findMax(char[] number, ArrayList<String> ans) {
        char[] store = new char[number.length];
        fillNumber(number, store);
        int inconsistence = number.length - 1;
        for (int i = number.length - 1; i > 0; i--) {
            char left = number[i - 1], right = number[i];
            if (left < right) {
                inconsistence = i - 1;
                break;
            }
        }
        if (inconsistence < number.length - 1) {
            int index = linearSearch(number, number[inconsistence], inconsistence + 1, number.length - 1);
            swap(number, inconsistence, index);
            reverse(number, inconsistence + 1, number.length - 1);
            ans.add(getString(number));
            findMax(number, ans);
        } else { // biggest number reached
            return;
        }
        fillNumber(store, number);
    }

    public static String getString(char number[]) {
        String str = "";
        for (char c : number) {
            str += c;
        }
        return str;
    }

    public static void reverse(char number[], int start, int end) {
        while (start < end) {
            swap(number, start, end);
            start++;
            end--;
        }
    }

    public static void swap(char number[], int start, int end) {
        char temp = number[start];
        number[start] = number[end];
        number[end] = temp;
    }

    public static int linearSearch(char number[], char key, int start, int end) {
        if (start == 0) {
            for (int i = start; i <= end; i++) {
                if (number[i] > key) {
                    return i;
                }
            }
        } else {
            for (int i = end; i >= start; i--) {
                if (number[i] > key) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static char[] getCharArray(Integer line) {
        char[] ans = new char[(int) Math.floor(Math.log10(line)) + 1];
        String str = Integer.toString(line);
        for (int i = 0; i < str.length(); i++) {
            ans[i] = str.charAt(i);
        }
        return ans;
    }

}