import AkPackage.*;
import javafx.scene.media.EqualizerBand;

import java.util.*;


public class SerializeDeserialize {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SerializeDeserialize());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            Tree root = InputOutput.createBinaryTree(arr);
            System.out.println("for ip: " + arr);
            String str = serialize(root);
            System.out.println("op after serializing: " + str);
            root = deserialize(str);
            System.out.println("after deserializeing: " + root);
        }
    }

    static int index;

    private static Tree deserialize(String ss) {
        String str[] = ss.split(",");
        index = 0;
        return deserialize(str);
    }



    private static Tree deserialize(String[] str) {
        String string = str[index++];
        if ("N".equals(string)) {
            return null;
        }

        Tree root = new Tree(Integer.valueOf(string));
        root.left = deserialize(str);
        root.right = deserialize(str);

        return root;
    }



    private static String serialize(Tree root) {
        StringBuilder ans = new StringBuilder();
        preOrder(root, ans);
        return ans.toString();
    }

    private static void preOrder(Tree root, StringBuilder ans) {
        if (root == null) {
            ans.append("N,");
            return;
        }
        ans.append(root.data+",");
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }


}