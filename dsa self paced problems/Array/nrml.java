import java.util.Arrays;
import java.util.Scanner;

public class nrml {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int value = maxArr(arr);
        System.out.println(value);
    }
    public static int maxArr(int A[]) {
        int max=Integer.MIN_VALUE;
        int leftMax[]=new int[A.length];
        int rightMax[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            leftMax[i]=Math.max(max,A[i]);
            max=leftMax[i];
        }
        max=Integer.MIN_VALUE;
        for(int i=A.length-1;i>=0;i--){
            rightMax[i]=Math.max(max,A[i]);
            max=rightMax[i];
        }
        int i=0, j=0;
        max=Integer.MIN_VALUE;
        while(i<A.length && j< A.length){
            int diff=Math.abs(leftMax[i]-rightMax[j])+Math.abs(i-j);
            if(diff>max){
                max=diff;
                i++;
            }
            else
            {
                j++;
            }
            System.out.println(diff);
        }
        while(i<A.length){
            int diff=Math.abs(leftMax[i]-rightMax[A.length-1])+Math.abs(i-(A.length-1));
            max=Math.max(diff,max);
            i++;
            System.out.println(diff);
        }
        while(j<A.length){
            int diff=Math.abs(leftMax[A.length-1]-rightMax[j])+Math.abs((A.length-1)-j);
            max=Math.max(diff,max);
            j++;
            System.out.println(diff);
        }
        return max;
    }
}