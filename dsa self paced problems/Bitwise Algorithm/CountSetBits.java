public class CountSetBits {
    public static void main(String[] args) {
        int intput = 338926;
        int table[] = new int[256];
        for (int i = 0; i < table.length; i++) {
            table[i] = (i & 1) + table[i / 2];
            System.out.println(i + " is having " + table[i] + " number of 1's in it's binary value");
        }
        int i=intput;
        int res = 0;
        while (intput > 0) {
            res += table[intput & 0xff];
            intput=intput>>8;
        }
        System.out.println("Total number of 1 present in "+ i +" is: "+ res );
    }
}

// Time complexity:O(1)
