import AkPackage.*;
import java.util.*;


public class GameOfThronesI {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new GameOfThronesI());
        while (!lines.isEmpty()) {
            String str = lines.remove(0);
            System.out.println("For input: " + str + " ==> " + gameOfThrones(str));
        }
    }

    public static boolean gameOfThrones(String str) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (char ch : str.toCharArray())
            hm.put(ch, hm.containsKey(ch) ? hm.get(ch) + 1 : 1);
        return hm.keySet().stream().filter(x -> (hm.get(x) & 1) ==1).count() <= 1;
    }
}