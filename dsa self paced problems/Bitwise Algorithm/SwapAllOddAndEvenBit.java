public class SwapAllOddAndEvenBit {
    public static void main(String[] args) {
        int n=23;
        System.out.println("Swapping odd and even elements the value of "+n+" has become: "+swapAllOddAndEvenBit(n));
    }

    public static int swapAllOddAndEvenBit(int n) {
        long ex = n & (0xAAAAAAAA);
        long ox = n & (0x55555555);
        ex = ex >> 1;
        ox = ox << 1;
        return (int) (ex | ox);
    }
}