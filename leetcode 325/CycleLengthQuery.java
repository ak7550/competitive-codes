import AkPackage.*;
import java.util.*;


public class CycleLengthQuery {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new CycleLengthQuery());
        while (!lines.isEmpty()) {
            int n = Integer.parseInt(lines.remove(0));
            int queryies[][] = Graph.takeAdjacencyMatrixInput(lines);
            System.out.println("ip: " + n);
            System.out.println("queries: " + Arrays.deepToString(queryies));
            System.out.println("ans: "+ Arrays.toString(solve(n, queryies)));
        }
    }

    private static int[] solve(int n, int[][] queries) {
        int ans[] = new int[queries.length];
        long limit = (long) Math.pow(2, n) - 1;
        for (int i = 0; i < queries.length; i++) {
            int query[] = queries[i];
            if (query[0] == 1 || query[1] == 1) {
                ans[i] = getHeight(query[0] == 1 ? query[1] : query[0], 1, limit);
            } else {
                ans[i] = getLca(1, query[0], query[1], limit);
            }
        }
        return ans;
    }

    private static int getHeight(int a, int root, long limit) {
        if (root > limit)
            return 0;
        if (root == a)
            return 1;
        int left = getHeight(a, root << 1, limit), right = getHeight(a, (root << 1) + 1, limit);
        if (left == 0 && right == 0)
            return 0;
        else
            return left + right + 1;
    }

    public static int getLca(int index, int a, int b, long limit) {
        if (index > limit)
            return 0;
        if (index == a || index == b) {
            return 1;
        }
        int left = getLca(index << 1, a, b, limit), right = getLca((index << 1) + 1, a, b, limit);
        // //lca found
        // if(left == 0 && right == null) return null;
        // if((left == a && right == b) || (left == b && right == a)){
        // return left + right;
        // }
        // else {
        // if(left != null) return left+1;
        // else return right + 1;
        // }

        // // return -1;
        if (left == 0 && right == 0)
            return 0;
        else if (left == 0 || right == 0) {
            return left == 0 ? right : left;
        }
        return left + right + 1;
    }
}