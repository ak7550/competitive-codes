import java.io.*;
import java.util.*;
public class TrafficLights {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String str[] = stdin.readLine().split(" "),
            str2[]  = stdin.readLine().split(" ");

        trafficLights(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str2);
    }

    public static void trafficLights(int x, int n, String str[]) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> hm = new TreeMap<>(); // to store the the difference maps frequency of the differences
        tm.put(0, x);
        hm.put(x, 1);
        Integer max = x;
        boolean isRemoved = false;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(str[i]);
            Map.Entry<Integer, Integer> entry = tm.lowerEntry(number);
            int diff = Math.abs(entry.getKey() - entry.getValue());
            tm.remove(entry.getKey());
            hm.put(diff, hm.get(diff) - 1);
            if (hm.get(diff).equals(0)) {
                hm.remove(diff);
            }

            tm.put(entry.getKey(), number);
            diff = Math.abs(entry.getKey() - number);
            hm.put(diff, hm.getOrDefault(diff, 0) + 1);
            tm.put(number, entry.getValue());
            diff = Math.abs(entry.getValue() - number);
            hm.put(diff, hm.getOrDefault(diff, 0) + 1);
            System.out.print(hm.lastKey()+" ");
        }
    }
}
