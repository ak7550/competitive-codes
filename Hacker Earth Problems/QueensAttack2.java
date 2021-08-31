import AkPackage.*;
import java.util.*;

public class QueensAttack2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new QueensAttack());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)), // board size and k
                    queenPos[] = InputOutput.arrayFromString(lines.remove(0));

            List<ArrayList<Integer>> pieces = new ArrayList<>();

            for (int i = 0; i < arr[1]; i++)
                pieces.add(InputOutput.ArrayListFromString(lines.remove(0)));

            System.out.println("\nFor input: ");
            pieces.forEach(x -> System.out.print(x + " "));
            System.out.println("\nAns is: " + queenAttack(arr[0], arr[1], queenPos[0], queenPos[1], pieces));
        }
    }

    public static int queenAttack(int n, int k, int rq, int cq, List<ArrayList<Integer>> obstacles) {

        List<Integer> upHurdle = obstacles.stream().filter(x -> x.get(0) > rq).min((a, b) -> a.get(1) - b.get(1)).get(),
                downHurdle = obstacles.stream().filter(x -> x.get(0) < rq).max((a, b) -> a.get(1) - b.get(1)).get(),
                leftHurdle = obstacles.stream().filter(x -> x.get(1) < cq).max((a, b) -> a.get(1) - b.get(1)).get(),
                rightHurdle = obstacles.stream().filter(x -> x.get(1) > rq).min((a, b) -> a.get(1) - b.get(1)).get();
        System.out.println(upHurdle);
        System.out.println(downHurdle);
        System.out.println(leftHurdle);
        System.out.println(rightHurdle);

        return 0;
    }
}