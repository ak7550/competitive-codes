import AkPackage.*;
import java.util.*;


public class MedianOfDataStream {
    static String find = "find", mid = "mid";
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MedianOfDataStream());
        while (!lines.isEmpty()) {
            String[] instructiosn = lines.remove(0).split(" ");
            List<Integer> input = InputOutput.ArrayListFromString(lines.remove(0));
            findAns(instructiosn, input);
        }
    }

    private static void findAns(String[] instructions, List<Integer> num){
        Median median = new Median();
        for (String string : instructions) {
            if (string.equals(find)) {
               System.out.println(median.findMedian());
            } else {
                median.add(num.remove(0));
            }
        }
    }
}

class Median {
    PriorityQueue<Integer> left, right;
    boolean isEven;

    Median() {
        isEven = true;
        //left will give the biggest value all the time
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public double findMedian() {
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        if (isEven) {
            return ((double)left.peek() + (double) right.peek())/2;
        } else {
            return left.peek();
        }
    }

    public void add(int num) {
        isEven = !isEven;
        Integer number = swapLeft(num);
        number = swapRight(number);
        if (isEven)
            right.add(number);
        else
            left.add(number);
    }

    private int swapRight(int num) {
        if (!right.isEmpty()) {
            int rt = right.peek();
            if (num > rt) {
                right.poll();
                right.add(num);
                return rt;
            }
        }
        return num;
    }

    private int swapLeft(int num) {
        if (!left.isEmpty()) {
            int lt = left.peek();
            if (lt > num) {
                left.poll();
                left.add(num);
                return lt;
            }
        }
        return num;
    }
}