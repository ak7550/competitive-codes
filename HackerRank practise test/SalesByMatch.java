import AkPackage.*;
import java.util.*;

public class SalesByMatch {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SalesByMatch());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For: " + arr);
            System.out.println("SockMerchant: " + sockMerchant(arr));
        }
    }

    public static int sockMerchant(List<Integer> arr) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        arr.forEach(x -> hm.put(x, hm.containsKey(x) ? hm.get(x) + 1 : 1));
        int res = 0;
        for (Integer integer : arr) {
            res += hm.get(integer) / 2;
            hm.put(integer, 0);
        }
        return res;
    }
}