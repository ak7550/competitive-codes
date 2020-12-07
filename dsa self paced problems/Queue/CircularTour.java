import java.util.ArrayList;
import java.util.Arrays;

import AkPackage.InputOutput;

public class CircularTour {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CircularTour());
        while (!lines.isEmpty()) {
            int petrol[] = InputOutput.arrayFromString(lines.remove(0)),
                    distance[] = InputOutput.arrayFromString(lines.remove(0));
            System.out.println("Petrol: " + Arrays.toString(petrol) + "\nDistance: " + Arrays.toString(distance));
            System.out.println("The Truck should start from: " + getResult(petrol, distance) + " position.");
        }
    }

    public static int getResult(int petrol[], int distance[]) {
        int i = 0, disC = 0, reset = 0, pI = i, pet = petrol[pI], totalDistance =  Arrays.stream(distance).sum();
        while (disC < totalDistance && reset < petrol.length) {
            if (pet < distance[i]) {
                i = (i + 1) % petrol.length;
                pI = i;
                pet = petrol[pI];
                disC = 0;
                reset++;
            } else {
                pet -= distance[i];
                disC += distance[i];
                i = (i + 1) % petrol.length;
                pet += petrol[i];
            }
        }
        return reset == petrol.length ? -1 : pI;
    }
}
