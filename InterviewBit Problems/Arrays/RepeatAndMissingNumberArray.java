import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


import AkPackage.InputOutput;
// linear time complexity, const aux space
public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new RepeatAndMissingNumberArray());
        while (!lines.isEmpty()) {
            List<Integer> line = InputOutput.ArrayListFromString(lines.remove(0));
            System.out.println("For input: " + line);
            System.out.println("Ans: " + getResult(line));
        }
    }

    public static ArrayList<Integer> getResult(final List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        BigInteger sumOfAllNatural=new BigInteger("0"),sumOfAllElements= new BigInteger(
                "0"), sumOfAllNaturalSquare= new BigInteger("0"), sumOfAllElementsSquare= new BigInteger(
                        "0"), rMinusp= new BigInteger("0"), rPlusp= new BigInteger("0"), repeat = new BigInteger("0"), missing=new BigInteger("0");
        for (int i = 1; i <= A.size(); i++) {
            BigInteger a = new BigInteger(Integer.toString(i));
            sumOfAllNatural=sumOfAllNatural.add(a);
            a=a.multiply(a);
            sumOfAllNaturalSquare=sumOfAllNaturalSquare.add(a);
        }
        System.out.println(sumOfAllNatural);
        System.out.println(sumOfAllNaturalSquare);
        for (Integer integer : A) {
            BigInteger a = new BigInteger(Integer.toString(integer));
            sumOfAllElements= sumOfAllElements.add(a);
            a=a.multiply(a);
            sumOfAllElementsSquare = sumOfAllElementsSquare.add(a);
        }
        System.out.println(sumOfAllElements);
        System.out.println(sumOfAllElementsSquare);
        rMinusp = sumOfAllNatural.subtract(sumOfAllElements);
        rPlusp = sumOfAllNaturalSquare.subtract(sumOfAllElementsSquare).divide(rMinusp);
        System.out.println(rMinusp);
        System.out.println(rPlusp);
        BigInteger devider = new BigInteger("2");
        missing = rMinusp.add(rPlusp).divide(devider);
        repeat = rPlusp.subtract(rMinusp).divide(devider);
        System.out.println(repeat);
        System.out.println(missing);
        ans.add(repeat.intValue());
        ans.add(missing.intValue());
        return ans;
    }
}