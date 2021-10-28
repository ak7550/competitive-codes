import AkPackage.*;
import java.util.*;

public class FractionalKnpaSack {

    static class Item {
        int weight, value;

        public Item(int v, int w) {
            value = v;
            weight = w;
        }
    }

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new FractionalKnpaSack());
        while (!lines.isEmpty()) {
            int values[] = InputOutput.arrayFromString(lines.remove(0)),
                    weights[] = InputOutput.arrayFromString(lines.remove(0)),
                    weight = Integer.parseInt(lines.remove(0));

            System.out.println("Values: " + Arrays.toString(values) + "\nWeights: " + Arrays.toString(weights)
                    + "\n length of the array is: " + values.length);
            Item arr[] = new Item[values.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = new Item(values[i], weights[i]);

            System.out.println("Max value that can be taken is: " + fractionalKnapsack(arr, weight));
        }
    }

    public static double fractionalKnapsack(Item arr[], int weight) {
        double val = 0;
        Arrays.sort(arr,
                (a, b) -> ((double) b.value / (double) b.weight > (double) a.value / (double) a.weight) ?
                                1 : -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].weight < weight) {
                val += arr[i].value;
                weight -= arr[i].weight;
            } else {
                val += ((double) arr[i].value / (double) arr[i].weight) * (double) weight;
                break;
            }
        }
        return val;
    }
}