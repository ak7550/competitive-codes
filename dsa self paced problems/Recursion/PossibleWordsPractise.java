public class PossibleWordsPractise {
    public static void main(String args[]) {
        int[] arr = new int[3];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;
        System.out.println("Possible words are: ");
        StringBuilder msg = new StringBuilder("");
        PhoneDial2.possibleWords(0, 0, arr,msg);
    }
}

class PhoneDial2 {
    static String str[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void possibleWords(int index, int strIndex, int[] arr,StringBuilder msg) {
        if (index == arr.length)// base case reached
        {
            System.out.println(msg);
            return;
        }
        for (int i = strIndex; i < str[arr[index]].length(); i++) {
            msg.append(str[arr[index]].charAt(i));
            possibleWords(index + 1, strIndex, arr, msg);
            msg.deleteCharAt(index);
        }
    }
}

