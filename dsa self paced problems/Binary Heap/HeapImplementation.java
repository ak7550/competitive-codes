import AkPackage.*;
import java.util.*;

public class HeapImplementation {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new HeapImplementation());
        while (!lines.isEmpty()) {
            ArrayList<Integer> input = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For the given input: " + input);
            Heap h = new Heap(input.size()/2);
            while (!input.isEmpty()) {
                switch (input.remove(0)) {
                    case 1:
                        h.insertKey(input.remove(0));
                        System.out.println("After insertion the heap is: " + Arrays.toString(h.harr));
                        break;
                    case 2:
                        h.deleteKey(input.remove(0));
                        System.out.println("After deletion the heap is: " + Arrays.toString(h.harr));
                        break;
                    case 3:
                        System.out.println(h.extractMin() + " is extracted");
                        System.out.println("After extraction the heap is: " + Arrays.toString(h.harr));
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
                System.out.println();
            }
        }
    }
}