import AkPackage.*;
import java.util.*;


public class CreateAllBST {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CreateAllBST());
        while (!lines.isEmpty()) {
            int n = InputOutput.ArrayListFromString(lines.remove(0)).get(0);
            System.out.println("For the given:" + n);
            System.out.println("All the bsts are: ");
            getAllSubTree(1, n).forEach(x -> {
                Tree.preorderTraversal(x);
                System.out.println();
            });

        }
    }

    //! catalan number
    //-> f(x) = Sum of( f(i) * f(n-i-1)) from i=0 to n
    public static ArrayList<Tree> getAllSubTree(int start, int end) {
        ArrayList<Tree> arr = new ArrayList<Tree>();
        if (start > end){
            arr.add(null);
            return arr;
        }
        for (int i = start; i <= end; i++) {
            //_ first generate all the possible left, right subtrees and then connect them with ith node one by one.
            ArrayList<Tree> left = getAllSubTree(i + 1, end), right = getAllSubTree(start, i - 1);

            //f(i)
            for (Tree r : right) {
                //f(n-i-1)
                for (Tree l : left) {
                    Tree root = new Tree(i);
                    root.left = l;
                    root.right = r;
                    arr.add(root);
                }
            }
        }
        return arr;
    }


}