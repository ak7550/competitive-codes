import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class PrimeSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int res[] = getResult(sc.nextInt());
        System.out.println("Answer is: "+Arrays.toString(res));
    }
    public static int[] getResult(int A) {
        ArrayList<Integer> prime = getPrime(A);
        System.out.println(prime);
        int ans[] = new int[2];
        int start=0, end=prime.size()-1;
        while (end>=start) {
            int a = prime.get(start), b = prime.get(end);
            if (a+b==A) {
                ans[0] = a;
                ans[1]=b;
                break;
            } else if(a+b>A){
                end--;
            }else {
                start++;
            }
        }
        return ans;
    }
    public static ArrayList<Integer> getPrime(int A) {
        boolean normal[] = new boolean[A + 1];
        Arrays.fill(normal, true);
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for (int i = 2; i < normal.length; i++) {
            if (normal[i]) {
                // got a prime
                prime.add(i);
                for (double j = Math.pow(i, 2); j < normal.length; j+=i) {
                    normal[(int)j] = false;
                }
            }
        }
        return prime;
    }
}