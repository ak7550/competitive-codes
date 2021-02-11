import AkPackage.*;

import java.util.*;


public class BTFromLL {

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new BTFromLL());
        while (!lines.isEmpty()) {
            System.out.println("The tree is: ");
            print(makeBT(InputOutput.getLinkedList(InputOutput.ArrayListFromString(lines.remove(0))), null));
            System.out.println();
        }
    }

    public static void print(Tree root) {
        if (root == null)
            return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    public static Node getFirstElement(Node head, Node temp) {
        if (head == null) {
            temp = null;
            return null;
        }
        temp = head;
        return head.next;
    }

    public static Tree makeBT(Node head, Tree root) {
        ArrayDeque<Tree> deq = new ArrayDeque<>();
        Node temp = null;
        if (head != null) {
            temp = head;
            head = head.next;
        }
        if (temp == null)
            return null;
        root = new Tree(temp.data);
        deq.add(root);
        while (!deq.isEmpty()) {
            Tree tree = deq.poll();
            if (head != null) {
                temp = head;
                head = head.next;
                tree.left = new Tree(temp.data);
                deq.add(tree.left);
                if (head != null) {
                    temp = head;
                    head = head.next;
                    tree.right = new Tree(temp.data);
                    deq.add(tree.right);
                } else
                    return root;

            } else
                return root;
        }
        return root;
    }
}