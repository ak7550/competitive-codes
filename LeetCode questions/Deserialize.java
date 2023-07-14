import AkPackage.*;
import java.util.*;


public class Deserialize {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Deserialize());
        while (!lines.isEmpty()) {
            String data = lines.remove(0);
            System.out.println("For ip: " + data);
            System.out.println("Ans is: " + Tree.levelorderTraversal(deserialize(data)));
        }
    }

    private static Tree deserialize(String data) {
        String str[] = data.substring(1, data.length()-1).split(",");
        return makeTree(str, 0);
    }

    private static Tree makeTree(String str[], int index){
        if(index >= str.length || str[index].trim().equals("null") || str[index].trim().equals("")){
            return null;
        }

        Tree root = new Tree(Integer.parseInt(str[index].trim()));
        root.left = makeTree(str, (index << 1) +1);
        root.right = makeTree(str, (index << 1) +2);

        return root;
    }
}