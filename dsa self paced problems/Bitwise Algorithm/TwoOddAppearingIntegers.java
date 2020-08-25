public class TwoOddAppearingIntegers {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 3, 4, 5, 6, 6, 7 };
        int res = 0;
        for (int i : arr) {
            res = res ^ i;
        }
        // res= 5^7, res is giving the result where there is bits are different as 1
        // deviding the array into two parts,
        int onlyRightMostSetBit = res & ~(res-1);
        int res2 = 0;
        res=0;
        for (int i : arr) {
            if((onlyRightMostSetBit & i)==onlyRightMostSetBit){
                res=res^i;
            }else{
                res2=res2^i;
            }
        }
        System.out.println("1st oddly occured element is: " + res + "\n2nd oddly occured element is: " + res2);
    }

    

    
}

// time complexity = O(arr.length)