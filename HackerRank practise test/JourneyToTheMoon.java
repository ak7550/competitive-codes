import AkPackage.*;
import java.util.*;


public class JourneyToTheMoon {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new JourneyToTheMoon());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)), n = arr[0], p = arr[1];
            ArrayList<ArrayList<Integer>> astro = new ArrayList<>(p);
            for (int i = 0; i < p; i++)
                astro.add(InputOutput.ArrayListFromString(lines.remove(0)));
            System.out.println("For I/P: " + Arrays.toString(arr));
            Graph.printAdjacencyList(astro);
            System.out.println("O/P: " + journeyToMoon(n, astro));
        }
    }

    static class DisJoint {
        int child = 0, parent[], rank[];
        int nc2[] ;

        public DisJoint(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            nc2 = new int[n + 1];
            nc2[0] = 0;
            nc2[1] = 1;
            parent[0] = 0;
            parent[1] = 1;
            if (n >= 2) {
                nc2[2] = 1;
                parent[2] = 2;
            }
            for (int i = 3; i <= n; i++) {
                nc2[i] = nc2[i - 1] * i / (i - 2);
                parent[i] = i;
            }

        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public void union(int x, int y) {
            int xp = find(x), yp = find(y);
            if(xp==yp) return;
            else {
                parent[yp] = xp;
                rank[xp]++;
                rank[yp]=0;
            }
        }
    }

    public static int journeyToMoon(int n, ArrayList<ArrayList<Integer>> astro) {
        DisJoint ds = new DisJoint(n);
        astro.forEach(x -> ds.union(x.get(0), x.get(1)));
        int ans = ds.nc2[n];
        for (int i = 0; i < n; i++) {
            if(ds.rank[i]!=0)
                ans -= ds.nc2[ds.rank[i] + 1];
        }
        return ans;
    }
}