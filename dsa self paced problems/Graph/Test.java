import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

public class Test {
    public static void main(String[] args) {
        ArrayList<SimpleEntry<Integer, Integer>> asm = new ArrayList<>();
        SimpleEntry<Integer, Integer> entry = new SimpleEntry<Integer, Integer>(1,1);
        asm.add(entry);
        entry = new SimpleEntry<Integer, Integer>(2,2);
        asm.add(entry);
        entry = new SimpleEntry<Integer, Integer>(3,3);
        asm.add(entry);
        System.out.println(asm);
    }
}
