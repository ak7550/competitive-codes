import AkPackage.*;
import java.util.*;

public class SlopCounter {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SlopCounter());
        while (!lines.isEmpty()) {
            int points[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("For given: ");
            Graph.printAdjacencyMatrix(points);
            System.out.println("Maximum points that are lying on the same line is: " + countMaxPoints(points));
        }
    }

    static class Slope {
        int nom, denom;

        public Slope(int p1[], int p2[]) {
            int x = p1[0] - p2[0], y = p1[1] - p2[1];
            if (x == 0 || y == 0) {
                nom = x;
                denom = y;
            } else {
                int ax = x < 0 ? -x : x, ay = y < 0 ? -y : y;
                int gcd = gcd(Math.max(ax, ay), Math.min(ax, ay));
                nom = x / gcd;
                denom = y / gcd;
            }
        }

        @Override
        public boolean equals(Object sp) {
            Slope sp2 = (Slope) sp;
            return nom == sp2.nom && denom == sp2.denom;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            if (nom == 0)
                return prime + denom;
            if (denom == 0)
                return prime + nom;
            result = prime * result + nom;
            result = prime * result + denom;
            return result;
        }

        private static int gcd(int a, int b) {
            return a % b == 0 ? b : gcd(b, a % b);
        }
    }

    public static int countMaxPoints(int points[][]) {
        int max = 0;
        HashMap<Slope, HashSet<int[]>> hm = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Slope sp = new Slope(points[i], points[j]);
                HashSet<int[]> hs = hm.getOrDefault(sp, new HashSet<>());
                hs.add(points[i]);
                hs.add(points[j]);
                hm.put(sp, hs);
                max = Math.max(max, hs.size());
            }
        }
        return max;
    }
}