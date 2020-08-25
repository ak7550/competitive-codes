public class LongestConsequtive1s {
    public static void main(String[] args) {
        int n=222;
        System.out.println("The number of longest consequtive 1's present in "+n+"is: "+numberof1(n));
    }
    public static int numberof1(int x) {
        int res=0;
        while(x!=0)
        {
            x=x&(x<<1);
            res++;
        }
        return res;
    }
}


// Time complexity:O(decimal value of x)
