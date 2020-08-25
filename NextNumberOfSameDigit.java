// i/p: 102,523,405,889,897
// o/p: 120,532,450,898,978
public class NextNumberOfSameDigit {
    // count the digits present into the number==> digits
    // using permutation we can generate digits! different numbers using our given
    // data
    // the idea is to produce all the digits! numbers sequencially and check if it's
    // bigger than n and the closest one.
    // if n is biggest possible number that can be made up of the given digits, then
    // print n is the biggest number of all.
    static int mainNumber, closest = Integer.MAX_VALUE, length,count=0;

    public static void main(String[] args) {
        int n = 1004;
        length = (int) Math.log10(n) + 1;
        mainNumber = n;
        // int firstIndex = 1, secondIndex = length;
        System.out.println("Newly generated numbers are: ");
        generateNumbers(n, 1, length);
        if (closest == Integer.MAX_VALUE) {
            System.out.println(mainNumber + " is the highest number, that can be made up of these " + length
                    + " digits.\nSo there's no any other number after " + mainNumber
                    + " that can be made up with these digits.");
        } else
            System.out.println("\nThe closest one is: " + closest);
        System.out.println("Total numbers geenrated: "+count);
    }

    public static int getDigit(int n, int pos) {
        int newNum = n / (int) Math.pow(10, length - pos);
        return newNum % 10;
    }

    public static int getNumber(int n, int first, int sec) {
        int firstElement = getDigit(n, first);
        int secElement = getDigit(n, sec);
        return setDigit(setDigit(n, firstElement, sec), secElement, first);
    }

    public static int setDigit(int n, int digit, int poss) {
        int fHalf = n / (int) Math.pow(10, length - poss + 1);
        int lHalf = n % (int) Math.pow(10, length - poss);
        fHalf *= 10;
        fHalf += digit;
        fHalf *= (int) Math.pow(10, length - poss);
        return fHalf + lHalf;
    }

    public static void generateNumbers(int n, int first, int second) {
        if (first == second + 1) { // base case reached
            System.out.print(n + " ");
            checkNum(n);
            count++;
            return;
        }
        for (int i = first; i <= second; i++) {
            n = getNumber(n, first, i);
            generateNumbers(n, first + 1, second);
            n = getNumber(n, first, i); // to the our actual value of n back
        }
    }

    public static void checkNum(int n) {
        if (n > mainNumber && n < closest) {
            closest = n;
        }
    }

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
