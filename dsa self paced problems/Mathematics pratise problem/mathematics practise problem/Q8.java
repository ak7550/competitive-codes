import java.util.Arrays;


public class Q8 {
    public static void main(String[] args) {
        int x = 24;
        int[] arr = getAB(x);
        System.out.println("The value of a and b is: " + Arrays.toString(arr) + "\nGCD of " + arr[0] + " and " + arr[1]
                + " is: " + gcd(arr[0], arr[1]) + "\nLCD of " + arr[0] + " and " + arr[1] + " is: "
                + lcd(arr[0], arr[1]));
    }

    public static int gcd(int no, int div) {
        if (div == 0)
            return no;
        return gcd(div, no % div);
    }

    public static int lcd(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static int[] getAB(int x) {
        int[] arr = new int[2];
        for (int i = 1; i < x/2; i++) {
            if(gcd(x-i, i)+lcd(x-i, i)==x){
                arr[0]=x-i;
                arr[1]=i;
            }
        }
        return arr;
    }
}

// time complesity: O(nlogn)