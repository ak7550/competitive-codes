import java.util.ArrayList;

import AkPackage.InputOutput;

/**
 * SwapKthNodesFromEnds
 */

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
    }
}

public class SwapKthNodesFromEnds {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new SwapKthNodesFromEnds());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            Node head = null;
            arr.forEach(x -> addNewNodeAtFirst(head, x));
        }
    }

    public static void addNewNodeAtFirst(Node head, int x) {

    }
}