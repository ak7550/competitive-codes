import AkPackage.*;
import java.util.*;
import java.util.stream.Collectors;


public class Zolando {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Zolando());
        while (!lines.isEmpty()) {
            ArrayList<Integer> input = InputOutput.ArrayListFromString(lines.remove(0));
            List<String> str = input.stream().map(x -> x.toString()).collect(Collectors.toList());
            String sstr[] = new String[str.size()];
            for (int i = 0; i < str.size(); i++) {
                sstr[i] = str.get(i);
            }

            System.out.println("for ip:" + Arrays.toString(sstr));
            System.out.println("op: " +solution(sstr));
        }
    }

    private static int solution(String[] E) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < E.length; i++) {
            String personIAvailable = E[i];
            for (int j = 0; j < personIAvailable.length(); j++) {
                int num = personIAvailable.charAt(j) - '0';
                arr.get(num).add(i);
            }
        }

        int max = -1;

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                HashSet<Integer> hm = new HashSet<>();
                hm.addAll(arr.get(i));
                hm.addAll(arr.get(j));

                max = Math.max(max, hm.size());
            }
        }

        return max;
    }
}