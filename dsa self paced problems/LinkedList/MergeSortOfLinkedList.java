import java.util.ArrayList;

import AkPackage.InputOutput;

class Node2 {
    int data;
    Node2 next;

    Node2(int x) {
        data = x;
        next = null;
    }
}

/**
 * MergeSortOfLinkedList
 */
public class MergeSortOfLinkedList {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MergeSortOfLinkedList());
        while (!lines.isEmpty()) {
            ArrayList<Integer> arr = InputOutput.ArrayListFromString(lines.remove(0));
            Node2 head = makeLinkedList(arr);
            System.out.println("\nBefore merge sort the list is: ");
            prinlist(head);
            head = mergeSort(head);
            System.out.println("\nAfter merge sort the list is: ");
            prinlist(head);
        }
    }

    public static Node2 mergeSort(Node2 head) {
        if (head.next == null)
            return head;
        Node2 mid = getMiddle(head);
        Node2 head2 = mid.next;
        mid.next = null;
        System.out.println("After splitting head1 is: ");
        prinlist(head);
        System.out.println("After splitting head2 is: ");
        prinlist(head2);
        head = mergeSort(head);
        head2 = mergeSort(head2);
        head = merge(head, head2);
        System.out.println("Merged list is: ");
        prinlist(head);
        return head;
    }

    public static Node2 getMiddle(Node2 head) {
        Node2 slow = head, fast = head;
        while (fast.next == null || fast == null) { // most crucial line ===> don't know why this line is working ?
        
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node2 merge(Node2 a, Node2 b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node2 head = null;
        if (a.data < b.data) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        Node2 tail = head;
        tail.next = null;
        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        if (a == null)
            tail.next = b;
        else
            tail.next = a;
        return head;
    }

    public static void prinlist(Node2 head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        prinlist(head.next);
    }

    public static Node2 makeLinkedList(ArrayList<Integer> arr) {
        Node2 head = null, tail = null;
        while (!arr.isEmpty()) {
            if (head == null) {
                head = new Node2(arr.remove(0));
                tail = head;
            } else {
                tail.next = new Node2(arr.remove(0));
                tail = tail.next;
            }
        }
        return head;
    }
}