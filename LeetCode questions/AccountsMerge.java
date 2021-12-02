import AkPackage.*;
import java.util.*;

public class AccountsMerge {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new AccountsMerge());
        while (!lines.isEmpty()) {
            int number = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            List<String[]> accounts = new ArrayList<>();
            for (int i = 0; i < number; i++)
                accounts.add(lines.remove(0).split(" "));

            System.out.println("For: " + accounts);
            System.out.println("o/p: " + mergeAccounts(accounts));
        }
    }

    static class Disjoint {
        String name;
        HashSet<String> emails;

        public Disjoint(String str[]) {
            name = str[0];
            emails = new HashSet<>();
            for (int i = 1; i < str.length; i++)
                emails.add(str[i]);
        }

        public void union(Disjoint ds){
            emails.addAll(ds.emails);
        }
    }

    public static List<List<String>> mergeAccounts(List<String[]> accounts) {
        HashSet<Disjoint> sets = new HashSet<Disjoint>();
        accounts.stream().forEach(x -> {
            Disjoint ds = new Disjoint(x);
            new HashSet<>(sets)
                    .stream()
                    .filter(set -> set.name == ds.name && !Collections.disjoint(ds.emails, set.emails))
                    .forEach(set -> {
                        sets.remove(set);
                        ds.union(set);
                    });
            sets.add(ds);
        });

        List<List<String>> ans = new ArrayList<>();
        sets.stream().parallel().forEach(set -> {
            ArrayList<String> arr = new ArrayList<String>();
            arr.add(set.name);
            set.emails.stream().sorted().forEach(arr::add);
            ans.add(arr);
        });

        return ans;
    }
}