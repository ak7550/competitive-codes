import AkPackage.*;
import java.util.*;


public class ValidSerialize {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ValidSerialize());
        while (!lines.isEmpty()) {
            String preorder = lines.remove(0);
            System.out.println("For I/P:" + preorder);
            System.out.println("The stirng is: " + isValid(preorder));
        }
    }

    static int index;

    public static boolean isValid(String preorder) {
        index = 0;
        String pre[] = preorder.split(",");
        if (!(preorder.charAt(preorder.length() - 1) == '#' && preorder.charAt(preorder.length() - 3) == '#'))
            return false;

        return buildTree(pre) && index == pre.length;
    }

    public static boolean buildTree(String pre[]) {
        if (pre[index].equals("#")) {
            index++;
            return true;
        }
        if (index == pre.length) {
            // System.out.print("...");
            return false;
        }

        index++;

        boolean left = buildTree(pre), right = buildTree(pre);

        return left && right;
    }
}