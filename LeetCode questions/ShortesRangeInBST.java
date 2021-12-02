import AkPackage.*;
import java.util.*;

public class ShortesRangeInBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ShortesRangeInBST());
        while (!lines.isEmpty()) {
            Tree root = InputOutput.createBST(lines.remove(0));
            System.out.println("For i/p: " + Tree.inorderTraversal(root));
            System.out.println("o/p is: " + shortestRange(root));
        }
    }

    static class Range {
        int x, y;

        Range() {
            x = 0;
            y = 0;
        }

        Range(int xx, int yy) {
            x = xx;
            y = yy;
        }

        @Override
        public String toString() {
            return String.format("[" + x + "," + y + "]");
        }
    }

    public static Range shortestRange(Tree root) {
        if (root == null)
            return new Range();
        Range r = new Range();
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            if(r.x == 0 && r.y==0)//level 1
            {
                Tree node = q.poll();
                r.x = node.data;
                r.y = node.data;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                continue;
            }
            Integer maxData = null, minData = null;
            boolean found = false;
            // traversing through a level
            for (int i = 0; i < size; i++) {
                Tree node = q.poll();
                if (!found) {
                    if (node.data < r.x) {
                        minData = minData == null ? node.data : Math.max(minData, node.data);
                    }
                    if (node.data > r.y) {
                        maxData = maxData == null ? node.data : Math.min(maxData, node.data);
                    }
                }
                if (node.data > r.x && node.data < r.y) {

                    minData = null;
                    maxData = null; //-> atleast one element is present into the range, so we wont change
                    found = true;
                }
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

            }
            if (!found) {
                // left-distance = ld
                Integer ld = minData == null ? null : Math.abs(minData - r.x),
                        rd = maxData == null ? null : Math.abs(maxData - r.y);
                if (ld != null && rd != null) {
                    if (rd <= ld)
                        r.y = maxData;
                    if (rd >= ld)
                        r.x = minData;
                }
                else if (ld == null && rd != null)
                    r.y = maxData;
                else if(ld!=null && rd==null)
                    r.x = minData;
            }
        }
        return r;
    }
}
