import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array length: ");
        int arr[] = new int[sc.nextInt()];
        System.out.println("Enter the " + arr.length + " elements one by one: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Majority element is: " + findMajority(arr));
    }

    public static int findMajority(int a[]) {
        int candidate = findCandidate(a);
        return (frequency(a, candidate) > a.length / 2) ? candidate : -1;
    }

    //=> Moore's Voting Algorithm, accurate all the time. finding the element having frequency greater than the array length.
    public static int findCandidate(int a[]) {
        int majIndex = 0, count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[majIndex] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }
        return a[majIndex];
    }

    public static int frequency(int a[], int element) {
        int count = 0;
        for (int i : a) {
            if (i == element) {
                count++;
            }
        }
        return count;
    }
}