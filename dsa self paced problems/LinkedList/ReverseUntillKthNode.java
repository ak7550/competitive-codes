import java.util.*;
import AkPackage.*;

class NewNode {
    Node currHead, updatedHead, nextOfHead;
}


public class ReverseUntillKthNode {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new ReverseUntillKthNode());
        while (!lines.isEmpty()) {
            Node head = Node.getLinkedList(lines.remove(0));
            int k = InputOutput.arrayFromString(lines.remove(0))[0];
            System.out.println("For given: ");
            print(head);
            System.out.println("Updated ll is: ");
            print(reverseLinkedList(head, k));
        }
    }

    public static NewNode reverse(Node head, int k) {
        NewNode obj = new NewNode();
        obj.currHead = head;
        int count = 0;
        Node prev=null, curr=head, next=head.next;
        while (count < k && curr != null) { //basic reverse of ll algo
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
            next = curr.next;
        }
        obj.updatedHead = curr;
        obj.nextOfHead = next;
        obj.currHead.next = next;
        return obj;
    }

    public static Node reverseLinkedList(Node head, int k) { 
        Node dummy = new Node(-1);
        dummy.next = head;
        int total = countTotal(head), count=0; //to count the length of the linkedlist
        while (count < total) { //-> implementation of sliding window technique (fixed size sliding window of length k)
            NewNode obj = reverse(dummy.next, k);
            dummy.next = obj.updatedHead;
            count += k;
            dummy = obj.currHead;
        }
        return dummy.next;
    }
}