import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import AkPackage.InputOutput;

/**
 * LRUCacheDesign
 */
public class LRUCacheDesign {

    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new LRUCacheDesign());
        while (!lines.isEmpty()) {
            int capacity = Integer.parseInt(lines.remove(0));
            String str[] = lines.remove(0).trim().split(" ");
            System.out.println("For the given string of: \n" + Arrays.toString(str));
            LRU cache = new LRU(capacity);
            for (int itr = 0; itr < str.length;) {
                String queryType = str[itr++];
                if (queryType.equals("SET"))
                    cache.set(Integer.parseInt(str[itr++]), Integer.parseInt(str[itr++]));
                else
                    System.out.print("\nGot the shit is: " + cache.get(Integer.parseInt(str[itr++])) + " ");

                System.out.println("\nAfter the " + queryType + " the cache is: ");
                LRU.print(cache.head);
            }
            System.out.println("\n=====================================================================");
        }
    }
}

class LRU {

    class Node {
        int data, key;
        Node next, prev;

        Node(int k, int val) {
            data = val;
            key = k;
            next = prev = null;
        }
    }

    HashMap<Integer, Node> mp;
    int capacity, size;
    Node head, tail;

    LRU(int x) {
        capacity = x;
        size = 0;
        mp = new HashMap<Integer, Node>();
        head = tail = null;
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            Node temp = mp.get(key);
            if (temp == head)
                return mp.get(key).data;
            else if (tail == temp) {
                tail = temp.prev;
                tail.next = null;
            } else if (temp != tail && temp != head) {
                Node next = temp.next, prev = temp.prev;
                prev.next = next;
                next.prev = prev;
            }
            temp.next = head;
            temp.prev = null;
            head.prev = temp;
            head = temp;
            return head.data;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node temp;
        // hit
        if (mp.containsKey(key)) {
            temp = mp.get(key);
            temp.data = value;
            if (temp == head)
                return;
            else if (tail == temp) {
                tail = temp.prev;
                tail.next = null;
            } else if (temp != tail && temp != head) {
                Node next = temp.next, prev = temp.prev;
                prev.next = next;
                next.prev = prev;
            }
        }
        // miss
        else {
            temp = new Node(key, value);
            if (size < capacity) {
                if (size == 0) {
                    head = temp;
                    tail = head;
                    size++;
                    mp.put(key, temp);
                    return;
                }
                size++;
            } else {
                // cache memory is full
                // remove tail from hashmap
                mp.remove(tail.key);
                if (capacity == 1) {
                    head = temp;
                    tail = temp;
                    mp.put(key, temp);
                    return;
                } else {
                    tail = tail.prev;
                    tail.next.prev = null; // problem zone ==> giving null pointer exception
                    tail.next = null;
                }
                mp.put(key, temp);
            }
        }
        // adding temp infront of head.
        temp.next = head;
        // temp.prev = null;
        head.prev = temp;
        head = temp;
    }

    public static void printList(Node head) {
        System.out.println("List is: ");
        print(head);
        System.out.println();
    }

    public static void print(Node head) {
        if (head == null)
            return;
        System.out.print("(" + head.key + " " + head.data + ")" + " ");
        print(head.next);
    }
}