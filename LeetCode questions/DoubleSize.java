import java.util.List;

import AkPackage.InputOutput;
import jdk.internal.util.xml.impl.Input;
import AkPackage.*;
import java.util.*;


public class DoubleSize {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new DoubleSize());
        while (!lines.isEmpty()) {
            List<Long> list = InputOutput.ArrayListFromString(lines.remove(0))
                    .stream()
                    .map(x -> Long.valueOf(x))
                    .collect(toList());

            System.out.println(doubleSize(list, 2l));
        }
    }

    public static long doubleSize(List<Long> arr, long b) {
        long max = Long.MIN_VALUE;
        for (long x : arr) {
            if (x == b) {
                b <<= 1;
                max = Math.max(max, b);
            }
        }
        return max;
    }

    public static String appendWord(List<String> inputArray) {
        StringBuilder res = new StringBuilder();
        for (int i = 2; i < inputArray.size(); i += 2) {
            res.append(inputArray.get(i));
        }

        return res.toString();
    }
}



interface OnlineAccount {
    int basePrice, regularMoviePrice, exclusiveMoviePrice;
}

class Account implements OnlineAccount, Comparable<Account> {
    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;

    Account(String ownerName, int noR, int noE) {
        this.ownerName = ownerName;
        noOfRegularMovies = noR;
        noOfExclusiveMovies = noE;
    }

    public int monthlyCost() {
        return basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice;
    }

    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }

    @Override
    public int compareTo(Account o) {
        return monthlyCost() - o.monthlyCost();
    }

}
