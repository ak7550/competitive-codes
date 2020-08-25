import java.util.*;

public class Q9 {
    public static void main(String[] args) {
        int x = 12345;
        ArrayList<Integer> arr = getThreeValues(x);
        checkAndPrint(arr);
    }

    public static void checkAndPrint(ArrayList<Integer> arr) {
        if ((arr.size() < 3) || (arr.size() == 3 && arr.get(0) == arr.get(1))) {
            System.out.println("\nNO");
        }
        if (arr.size() >= 6) {
            System.out.print("\nYES\n");
            System.out.print(arr.get(0) + " " + arr.get(1) * arr.get(2) + " ");
            int mul = 1;
            for (int i = 3; i < arr.size(); i++) {
                mul *= arr.get(i);
            }
            System.out.print(mul);
        }
        if (arr.size() == 3 && arr.get(0) != arr.get(1) && arr.get(1) != arr.get(2)) {
            System.out.print("\nYES\n");
            System.out.print(arr.get(0) + " " + arr.get(1) + " " + arr.get(2));
        }
        if (arr.size() == 4 && arr.get(0) == arr.get(arr.size() - 1)) {
            System.out.println("\nNO");
        }
        if (arr.size() == 5 && arr.get(1) * arr.get(2) == arr.get(arr.size() - 1) * arr.get(arr.size() - 2)) {
            System.out.println("\nNO");
        }
        else{
            System.out.print("\nYES\n");
            System.out.print(arr.get(0) + " " + arr.get(1) * arr.get(2) + " ");
            int mul = arr.get(3);
            for (int i = 4; i < arr.size(); i++) {
                mul *= arr.get(i);
            }
            System.out.print(mul);
        }
    }

    public static ArrayList<Integer> getThreeValues(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.print("Prime factors are: ");
        int no = n;
        for (int i = 2; i < Math.sqrt(no); i++) {
            while (n % i == 0) {
                arr.add(i);
                n /= i;
            }
        }
        if (n != 1) {
            arr.add(n);
        }
        System.out.print(arr);
        return arr;
    }
}

// Time complexity: O(sqrt(n)log(n))