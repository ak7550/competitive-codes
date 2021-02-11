import AkPackage.*;
import java.util.*;

public class DiameterOfABT {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DiameterOfABT());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            Tree root = InputOutput.createBinaryTree(arr);
            System.out.println("For the given bt: " + arr.toString() + "\nDiameter is: " + getResult(root));
        }
    }

    static int res;

    public static int getResult(Tree root) {
        res = 0;
        if (root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        return Math.max(1 + lh + rh, res);
    }

    public static int height(Tree root) {
        if (root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        res = Math.max(1 + lh + rh, res);
        return Math.max(lh, rh) + 1;
    }
}

