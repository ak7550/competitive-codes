import java.util.ArrayList;
import java.util.List;

import AkPackage.InputOutput;

public class PascalTriangle {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PascalTriangle());
        while (!lines.isEmpty()) {
            int rows = InputOutput.integerArrayFromString(lines.remove(0))[0];
            System.out.println("For input: " + rows);
            List<List<Integer>> triangle = getResult(rows);
            printList(triangle);
        }
    }
    public static void printList(List<List<Integer>> l) {
        for (List<Integer> list : l) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> getResult(int num) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (num==0) {
            return triangle;
        }
        ArrayList<Integer> t = new ArrayList<Integer>();
        t.add(0);
        t.add(1);
        t.add(0);
        triangle.add(t);
        for (int i = 0; i < num-1; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            List<Integer> last = triangle.get(triangle.size() - 1);
            for (int j = 0; j < last.size() - 1; j++) {
                temp.add(last.get(j) + last.get(j + 1));
            }
            temp.add(0, 0);
            temp.add(0);
            last.remove(0);
            last.remove(last.size() - 1);
            triangle.add(temp);
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        last.remove(0);
        last.remove(last.size() - 1);
        return triangle;
    }
}