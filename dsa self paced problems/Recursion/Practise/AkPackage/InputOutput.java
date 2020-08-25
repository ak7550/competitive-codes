package AkPackage;

import java.io.*;
import java.util.ArrayList;

public class InputOutput {

    static String getFileName(Object obj) {
        return obj.getClass().getSimpleName() + "_testcases.txt";
    }

    // done
    public static ArrayList<String> takeCompleteInput() {
        System.out.println("Enter the complete input.\nRest of the stuff will be handled automatically.");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        return takeCompleteInput(stdin);
    }

    // done
    public static ArrayList<String> takeCompleteInput(BufferedReader stdin) {
        String line;
        ArrayList<String> lines = new ArrayList<>();
        try {
            while ((line = stdin.readLine()) != null && line.length() != 0) {
                lines.add(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
        } catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " doesnot exist.");
            lines = takeCompleteInput();
        }
        writeTestCaseIntoFile(fileName, lines);
        return lines;
    }

    // done
    public static void addANewTestCase(ArrayList<String> strings) {
        System.out.println("Enter the new test case: ");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            strings.add(stdin.readLine());
            // if works, go for the next line.
            Integer numberOfTestCases = Integer.parseInt(strings.get(0));
            strings.set(0, Integer.toString(++numberOfTestCases));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // done
    public static ArrayList<Integer> ArrayListFromString(String str) {
        String arr[] = str.split(" ");
        ArrayList<Integer> myarr = new ArrayList<Integer>();
        for (String string : arr) {
            try {
                Integer ii = Integer.parseInt(string);
                myarr.add(ii);
            } catch (Exception e) {
                // TODO: handle exception
                // System.out.println("Exception avoided. The String is: "+ string);
            }
        }
        return myarr;
    }

    // done
    public static Integer[] integerArrayFromString(String str) {
        ArrayList<Integer> list = ArrayListFromString(str);
        return list.toArray(new Integer[list.size()]);
    }

    // done
    public static int[] arrayFromString(String str) {
        return ArrayListFromString(str).stream().mapToInt(Integer::valueOf).toArray();
    }

    // done
    public static void writeTestCaseIntoFile(String fileName, ArrayList<String> strings) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileWriter writer;
        try {
            writer = new FileWriter(file);
            for (String string : strings) {
                try {
                    writer.write(string + "\n");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            writer.close();
            System.out.println("All the information has been stored into " + fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // done
    public static void writeTestCaseIntoFile(Object obj, ArrayList<String> strings) {
        writeTestCaseIntoFile(getFileName(obj), strings);
    }
}