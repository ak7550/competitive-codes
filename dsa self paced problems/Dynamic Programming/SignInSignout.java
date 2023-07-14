import java.util.*;
import AkPackage.*;


public class SignInSignout {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SignInSignout());
        while (!lines.isEmpty()) {
            int maxSpan = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For ip: " + lines);
            System.out.println(maxSpan);
            System.out.println("op is: " + processLogs(lines, maxSpan));
        }
    }

    static class Timings {
        Integer signIn, signOut, id;

        public Timings(Integer i) {
            id = i;
            signIn = null;
            signOut = null;
        }

    }

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        HashMap<Integer, Timings> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String log : logs) {
            String data[] = log.split(" ");
            int id = Integer.parseInt(data[0]), time = Integer.parseInt(data[1]);
            Timings timings = null;
            if (hm.containsKey(id)) {
                timings = hm.get(id);
            } else {
                timings = new Timings(id);
                hm.put(id, timings);
            }
            if (data[2].equals("sign-in"))
                timings.signIn = time;
            else
                timings.signOut = time;
        }

        for (int id : hm.keySet()) {
            Timings timings = hm.get(id);
            if (timings.signIn != null && timings.signOut != null) {
                int span = Math.abs(timings.signOut - timings.signIn);
                if (span <= maxSpan) {
                    ans.add(String.valueOf(timings.id));
                }
            }

        }
        Collections.sort(ans);
        return ans;
    }
}