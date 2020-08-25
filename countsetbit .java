/**
 * countsetbit 
 */
class countsetbit  {

    public static void main(String arg[])
    {
        int n=42;
        System.out.println("The number of set bits are: "+countsetbit.countSetBits(n));
    }
    public static int countSetBits(int n){
    
        // Your code here
        int res;
        for(res=0;n>0;n/=2)
            if(n%2==1)
                res++;
        return res;
    }
}