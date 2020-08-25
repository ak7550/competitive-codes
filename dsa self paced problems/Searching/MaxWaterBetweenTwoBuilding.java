import java.util.Arrays;
import java.util.Scanner;

import AkPackage.CompetetiveCoding;

/**
 * MaxWaterBetweenTwoBuilding
 */
public class MaxWaterBetweenTwoBuilding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the buildings: ");
        int height[] = CompetetiveCoding.takeIntegerArrayInput(sc.nextInt());
        System.out.println("For Input: " + Arrays.toString(height));
        int tappedWater = getResult(height);
        System.out.println("Ans is: " + tappedWater);
    }
    public static int getResult(int height[]) {
        int start = 0, end = height.length - 1, maxWater=0;
        while (end > start) {
            int water = (end - start - 1) * Math.min(height[start], height[end]);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
            maxWater = Math.max(maxWater, water);
        }
        return maxWater;
    }
}