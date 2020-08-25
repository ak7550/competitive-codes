import java.util.Random;

public class GenerateRandomNumbers {
    public static void main(String[] args) {
        Random ran = new Random();
        int n = 20;
        for (int i = 0; i < n; i++) {
            System.out.print((ran.nextInt(65536) - 32768) + " ");
        }
    }
}