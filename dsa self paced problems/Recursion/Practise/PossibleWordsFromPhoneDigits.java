import java.util.ArrayList;

import AkPackage.InputOutput;

public class PossibleWordsFromPhoneDigits {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PossibleWordsFromPhoneDigits());
        lines.remove(0);// removing the testcase number
        for (String string : lines) {
            int arr[] = InputOutput.arrayFromString(string);
            if (arr.length > 1) {
                System.out.print("Input " + string + ": ");
                getResult(arr,"",0);
                System.out.println();
            }
        }
    }

    static String numbers[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void getResult(int[] arr, String str, int index) {
        if (index == arr.length) {
            System.out.print(str + " ");
            return;
        }
       for (int i = 0; i < numbers[arr[index]].length(); i++) {
           getResult(arr, str+numbers[arr[index]].charAt(i), index+1);
       }
    }
}