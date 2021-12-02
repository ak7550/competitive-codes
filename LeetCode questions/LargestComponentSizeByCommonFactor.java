import AkPackage.*;
import java.util.*;

public class LargestComponentSizeByCommonFactor {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LargestComponentSizeByCommonFactor());
        while (!lines.isEmpty()) {
            int nums[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("For i/p: " + Arrays.toString(nums));
            System.out.println("Largest common size is: " + largestComponentSize2(nums));
        }
    }

    static class Disjoint {
        int nodes;
        HashSet<Integer> primeFactors; // all the prime factors, through which those numbers can be divisible

        public Disjoint(int x, Integer sieve[]) {
            nodes = 1;
            primeFactors = new HashSet<>();
            while (sieve[x] != x) {
                primeFactors.add(sieve[x]);
                x /= sieve[x];
            }
            primeFactors.add(sieve[x]);
        }

        public void union(Disjoint ds) {
            primeFactors.addAll(ds.primeFactors);
            nodes += ds.nodes;
        }

    }

    public static int largestComponentSize(int nums[]) {
        Arrays.sort(nums);
        Integer sieve[] = Mathematics.getSieveTable(nums[nums.length - 1]);
        HashSet<Disjoint> sets = new HashSet<>();
        for (int x : nums) {
            Disjoint ds = new Disjoint(x, sieve);
            ArrayList<Disjoint> arr = new ArrayList<>();
            sets.stream().parallel() // O(n2) solution ==> tle
                    .filter(set -> !Collections.disjoint(set.primeFactors, ds.primeFactors)).forEach(set -> {
                        ds.union(set);
                        arr.add(set);
                    });
            sets.removeAll(arr);
            sets.add(ds);
        }
        return sets.stream().max((a, b) -> a.nodes - b.nodes).get().nodes;
    }


    static class DisjointSet {
        int parent[];

        public DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;
        }

        public void union(int a, int b) {

        }

        public int get(int a) {
            return parent[a] == a ? parent[a] = get(parent[a]) : a;
        }
    }
    public static int largestComponentSize2(int nums[]) {
        DisjointSet ds = new DisjointSet(Arrays.stream(nums).max().getAsInt());
        for (int x : nums) {
            for (int j = (int) Math.sqrt(x); j >= 2; --j) {
                if (x % j == 0) {
                    ds.union(x, j);
                    ds.union(x, x / j);
                }
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int x : nums) {
            int parent = ds.get(x);
            hm.put(parent, hm.getOrDefault(parent, 0) + 1);
            max = Math.max(hm.get(parent), max);
        }
        return max;
    }

}