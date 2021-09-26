import java.util.*;


public class DigiSumPallindrome {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println(digitSum(sc.nextInt()));
    }

    public static int digitSum(int num) {
        int sum  = 0;
        for(char ch: String.valueOf(num).toCharArray())
            sum+= Integer.parseInt(ch+"");
        StringBuilder res = new StringBuilder(String.valueOf(sum)).reverse();

        return String.valueOf(sum).compareTo(res.toString()) == 0 ? 1 : 0;
    }
}
