import AkPackage.*;
import java.util.*;

public class Candies {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new Candies());
        while (!lines.isEmpty()) {
            List<Integer> candies = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For the given: " + candies);
            System.out.println("She must buy: " + countCandies(candies));
        }
    }

    static class State {
        boolean increasing, decreasing, equal;

        public State() {
            increasing = false;
            decreasing = false;
            equal = false;
        }
    }

    public static long countCandies(List<Integer> arr) {
        State state = new State();
        int start = 0, end = 1;
        long sum = 0;

        while (start<arr.size()) {
            update(arr, start, state);

            if (state.increasing) {
                while (end < arr.size() && arr.get(end) > arr.get(end - 1))
                    end++;

                long diff = end - start;
                sum += ((diff * (diff + 1)) >> 1);
                start = end;
                end += 1;
            }

            if (state.decreasing) {
                while (end < arr.size() && arr.get(end) < arr.get(end - 1))
                    end++;

                long diff = end - start;
                sum += ((diff * (diff + 1)) >> 1);
                start = end;
                end += 1;
            }

            if (state.equal) {
                while (end < arr.size() && arr.get(end).equals(arr.get(end - 1)))
                    end++;

                long diff = end - start;
                sum += diff;
                start = end;
                end += 1;
            }
        }
        return sum;
    }

    public static void update(List<Integer> arr, int start, State state) {
        state.increasing = false;
        state.decreasing = false;
        state.equal = false;

        // -> increasing
        if (start + 1 < arr.size() && arr.get(start) < arr.get(start + 1)) {
            state.increasing = true;
            return;
        }

        // -> decreasing
        if (start + 1 < arr.size() && arr.get(start) > arr.get(start + 1)) {
            state.decreasing = true;
            return;
        }

        // -> equal
        if (start + 1 < arr.size() && arr.get(start).equals(arr.get(start + 1))) {
            state.equal = true;
            return;
        }

        // _ start+1 == arr.size ==> only one element is left
        state.equal = true; // -> abhi kuch vi karo, it does not matter much./
    }

}