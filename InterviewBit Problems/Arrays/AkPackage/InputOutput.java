package AkPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class DualDataStructure {
    ArrayList<Integer> arr;
    String str;
}

public class InputOutput {

    static String msg = "There are 1 lines in the input.\nLine 1 ( Corresponds to arg 1 ) : An integer array. First number is the size S of the array. Then in the next line S numbers follow which indicate the elements in the array.\nFor example, Array: [1, 2, 6] will be written as 3 \n(new line) 1 2 6(with proper spaces).\n\nFor take a single number input just pass them one by one in a single line, each input in one line.";

    // returns the filename as a string
    private static String getFileName(Object obj) {
        return obj.getClass().getSimpleName() + "_testcases.txt";
    }

    // done
    public static ArrayList<String> takeCompleteInput() { // when you don't want to save the input in a file.
        System.out.println(msg);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Do you wanna take random input?(y/n) ");
        String decision;
        try {
            decision = stdin.readLine();
            if (decision.equals("y") || decision.equals("Y")) {
                ArrayList<String> lines = new ArrayList<>();
                System.out.print("Length of the array: ");
                String legnth = stdin.readLine();
                String arr = stringArrayOfRandomInteger(Integer.parseInt(legnth), Integer.parseInt(legnth)).str.trim();
                lines.add(0, arr + " This one is a random input."); // take input for this
                return lines;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter the Input.\nEverything will be handled automaticlly");
        return takeCompleteInput(stdin);
    }

    // done
    private static ArrayList<String> takeCompleteInput(BufferedReader stdin) {
        String line;
        ArrayList<String> lines = new ArrayList<>();
        try {
            while ((line = stdin.readLine()) != null && line.length() != 0) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // done
    public static ArrayList<String> takeCompleteInput(Object obj) {
        return takeCompleteInput(getFileName(obj));
    }

    // done
    public static ArrayList<String> takeCompleteInput(String fileName) {
        ArrayList<String> lines;
        try {
            lines = takeCompleteInput(new BufferedReader(new FileReader(fileName)));
            System.out.println("Inputs are taken from " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " doesnot exist.");
            lines = takeCompleteInput();
        }
        System.out.print("Do you have more testcases ? (y/n): ");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String decision;
        try {
            decision = stdin.readLine();
            if (decision.equals("y") || decision.equals("Y")) {
                addANewTestCases(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeTestCaseIntoFile(fileName, lines);
        return lines;
    }

    // done
    private static void addANewTestCases(ArrayList<String> strings) {
        System.out.println(msg);
        System.out.println("Enter the new test cases: ");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while ((line = stdin.readLine()) != null && line.length() != 0) {
                strings.add(0, line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // done
    public static ArrayList<Integer> ArrayListFromString(String str) {
        String arr[] = str.split(" ");
        ArrayList<Integer> myarr = new ArrayList<Integer>();
        for (String string : arr) {
            try {
                Integer ii = Integer.parseInt(string.trim());
                myarr.add(ii);
            } catch (Exception e) {
                // System.out.println("Exception avoided. The String is: "+ string);
            }
        }
        return myarr;
    }

    public static ArrayList<Integer> randomIntegerArrayList(int length, int bound) {
        return stringArrayOfRandomInteger(length, bound).arr;
    }

    // try to modify any one of them.
    private static DualDataStructure stringArrayOfRandomInteger(int length, int bound) {
        Random ran = new Random();
        String str = "";
        ArrayList<Integer> arr = new ArrayList<Integer>();
        DualDataStructure ddsObject = new DualDataStructure();
        for (int i = 0; i < length; i++) {
            int randomInteger = ran.nextInt(bound);
            str += " " + randomInteger;
            arr.add(randomInteger);
        }
        ddsObject.str = str;
        ddsObject.arr = arr;
        return ddsObject;
    }

    public static ArrayList<Integer> randomIntegerArrayList(int length) {
        return randomIntegerArrayList(length, length);
    }

    public static Integer[] randomIntegerArray(int length, int bound) {
        ArrayList<Integer> list = randomIntegerArrayList(length, bound);
        return list.toArray(new Integer[list.size()]);
    }

    // done
    public static Integer[] integerArrayFromString(String str) {
        ArrayList<Integer> list = ArrayListFromString(str);
        return list.toArray(new Integer[list.size()]);
    }

    public static Integer[] randomIntegerArray(int length) {
        return randomIntegerArray(length, length);
    }

    public static int[] randomIntArray(int length, int bound) {
        return randomIntegerArrayList(length, bound).stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] randomIntArray(int length) {
        return randomIntArray(length, length);
    }

    // done
    public static int[] arrayFromString(String str) {
        return ArrayListFromString(str).stream().mapToInt(Integer::valueOf).toArray();
    }

    // done
    private static void writeTestCaseIntoFile(String fileName, ArrayList<String> strings) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter writer;
        try {
            writer = new FileWriter(file);
            for (String string : strings) {
                try {
                    writer.write(string.trim() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.close();
            System.out.println("All the information has been stored into " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTestCaseIntoFile(Object obj, ArrayList<String> strings) {
        writeTestCaseIntoFile(getFileName(obj), strings);
    }
}
