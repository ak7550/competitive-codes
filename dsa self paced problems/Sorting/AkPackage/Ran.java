package AkPackage;

import java.util.Random;
import java.time.*;

public class Ran extends Random {
    private static final long serialVersionUID = 1L;
    String s = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    String smallletters = "qwertyuiopasdfghjklzxcvbnm", specialSymbols = "~!@#$%^&*()_+`={}[]<>,.?/|";
    String numbers = "1234567890", capitalLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public final String getString(int max) {
        return getStringFixedLength(nextInt(max), s);
    }

    public final String getString(int max, String s) {
        return getStringFixedLength(nextInt(max), s);
    }

    public final String getString() {
        return getString(100);
    }

    public String getStringFixedLength(int length, String s) {
        StringBuilder str = new StringBuilder(length);
        for (int i = 0; i < length; i++) // so that we will never get a null value.
            str.append(s.charAt(nextInt(s.length())));
        return str.toString();
    }

    public LocalDate getRandomDate() {
        return getRandomDate(2000);
    }

    public LocalDate getRandomDate(int range) {
        LocalDate temp = LocalDate.now();
        int randomYear = range + nextInt(temp.getYear() - range), randomMonth = nextInt(11) + 1;
        Month mn = Month.of(randomMonth);
        temp = temp.withYear(randomYear);
        int dayOfMonth = nextInt(mn.length(temp.isLeapYear()));
        return LocalDate.of(randomYear, randomMonth, dayOfMonth);
    }

    public int nextInt(int lowerBound, int upperBound) {
        return nextInt(upperBound - lowerBound) + lowerBound;
    }

    public String getRandomEmail() {
        return getStringFixedLength(1, smallletters) + getString(20, (smallletters + numbers)) + "@"
                + getStringFixedLength(6, smallletters) + "." + getStringFixedLength(3, smallletters);
    }
    public int[] giveAnArray(int size) {
        return giveAnArray(size, 100);
    }

    public int[] giveAnArray(int size, int bound) {
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt(bound);
        }
        return arr;
    }

}