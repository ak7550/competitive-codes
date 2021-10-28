import java.util.HashSet;

class B {
    void method(){
        System.out.println("hi");
    }
}

class Try{
    public static void main(String[] args) {
        int a = 0, b = 1, d = 1;
        System.out.println(++a + ++a + a++ + " " + a++ + ++b + " " + ++d + d++ + a++);
    }


    public static int spellCheck(String str1, String str2, int k) {
        if (str1.equals(str2))
            return 1;
        int count = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                count++;
        }

        count += Math.max(str1.length(), str2.length()) - Math.min(str1.length(), str2.length()); // counting the extras

        if (count == k)

            return 3;

        else if (count < k)
            return 2;
        else
            return 4;
    }

    class Node {
        Node next;
        int data;
    }

    static Node DeleteDuplicates(Node head) {
        HashSet<Integer> hs = new HashSet<>();
        Node dummy = new Node(-1), prev = null;
        dummy.next = head;
        prev = dummy;
        Node curr = head;

        while (curr != null) {
            if (hs.contains(curr.data)) {
                curr = curr.next;
                prev.next = curr;
            } else {
                hs.add(curr.data);
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
