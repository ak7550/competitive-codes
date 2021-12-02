import AkPackage.*;
import java.util.*;
//*WRONG CODE
public class MinimumCostHomecomingOfRobot {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new MinimumCostHomecomingOfRobot());
        while (!lines.isEmpty()) {
            int strrtpos[] = InputOutput.arrayFromString(lines.remove(0)),
                    homepos[] = InputOutput.arrayFromString(lines.remove(0)),
                    rowCost[] = InputOutput.arrayFromString(lines.remove(0)),
                    colCost[] = InputOutput.arrayFromString(lines.remove(0));

            System.out.println("For: " + Arrays.toString(strrtpos));
            System.out.println("ans is: " + minCost(strrtpos, homepos, rowCost, colCost));
        }
    }

    public static int minCost(int startPos[], int homePos[], int rowCosts[], int colCosts[]) {
        int cost = 0;
        if (startPos[0] > homePos[0]) // go up
            cost += goUp(startPos[0], homePos[0], rowCosts);
        else if (startPos[0] < homePos[0]) // go down
            cost += goDown(startPos[0], homePos[0], rowCosts);

        if (startPos[1] > homePos[1]) // go left
            cost += goLeft(startPos[1], homePos[1], colCosts);
        else if (startPos[1] < homePos[1]) // go right
            cost += goRight(startPos[1], homePos[1], colCosts);

        return cost;
    }

    public static int goUp(int start, int home, int arr[]) {
        int cost = 0;
        while (start != home) {
            start--;
            cost += arr[start];
        }

        return cost;
    }

    public static int goDown(int start, int home, int arr[]) {
        int cost = 0;
        while (start != home) {
            start++;
            cost += arr[start];
        }
        return cost;
    }

    public static int goLeft(int start, int home, int arr[]) {
        int cost = 0;
        while (start != home) {
            start--;
            cost += arr[start];
        }
        return cost;
    }

    public static int goRight(int start, int home, int arr[]) {
        int cost = 0;
        while (start != home) {
            start++;
            cost += arr[start];
        }

        return cost;
    }
}