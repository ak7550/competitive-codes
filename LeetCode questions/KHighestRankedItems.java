import AkPackage.*;
import java.util.*;
//*WRONG SUBMISSION
public class KHighestRankedItems {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new KHighestRankedItems());
        while (!lines.isEmpty()) {
            int grid[][] = Graph.takeAdjacencyMatrixInput(lines),
                    pricing[] = InputOutput.arrayFromString(lines.remove(0)),
                    start[] = InputOutput.arrayFromString(lines.remove(0)),
                    k = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For ip: " + Arrays.deepToString(grid) + "\n" + Arrays.toString(pricing) + "\n"
                    + Arrays.toString(start) + "\n" + k);

            System.out.println("op is: " + highestRankedKItems(grid, pricing, start, k));
        }
    }

    static class PositionPrice {
        int pos[];
        int price, distance;

        public PositionPrice(int p[], int pr, int d) {
            pos = p;
            price = pr;
            distance = d;
        }
    }

    public static List<List<Integer>> highestRankedKItems(int grid[][], int pricing[], int start[], int k) {
        PriorityQueue<PositionPrice> q = new PriorityQueue<>(
                (a, b) -> a.distance != b.distance ? a.distance - b.distance
                        : a.price != b.price ? a.price - b.price
                                : a.pos[0] != b.pos[0] ? a.pos[0] - b.pos[0] : a.pos[1] - b.pos[1]);

        List<List<Integer>> ans = new ArrayList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        q.add(new PositionPrice(start, grid[start[0]][start[1]], 0));
        final int[][] dirs = new int[][] {
                { 1, 0 },
                { -1, 0 },
                { 0, -1 },
                { 0, 1 }
        };
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            PositionPrice pp = q.poll();

            if (pp.price != -1 && pp.price >= pricing[0] && pp.price <= pricing[1]) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(pp.pos[0]);
                arr.add(pp.pos[1]);
                ans.add(arr);
                if (ans.size() == k)
                    break;
            }

            for (int dir[] : dirs) {
                int dx = pp.pos[0] + dir[0], dy = pp.pos[1] + dir[1];

                if (dx >= 0 && dx < grid.length
                        && dy >= 0 && dy < grid[0].length
                        && !visited[dx][dy]
                        && grid[dx][dy] != 0) {
                    q.add(
                            new PositionPrice(new int[] { dx, dy }, grid[dx][dy],
                                    Math.abs(dx - start[0]) + Math.abs(dy - start[1]))
                        );
                    visited[dx][dy] = true;
                }
            }
        }

        return ans;
    }
}