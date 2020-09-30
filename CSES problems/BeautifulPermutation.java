import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulPermutation {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Enter the number: ");
        int n;
        try {
            n = Integer.parseInt(stdin.readLine());
            getResult(n);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getResult(int n) {
        if (n<=1) {
            System.out.println(n);
            return;
        }
        else if (n<4) {
            System.out.println("NO SOLUTION");
        } else {
            for (int i = 2; i <=n; i+=2) {
                System.out.print(i+" ");
            }
            for (int i = 1; i <=n; i+=2) {
                System.out.print(i+" ");
            }
        }        
    }
}