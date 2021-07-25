import AkPackage.*;
import java.util.*;


public class CamelCase {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new CamelCase());
        while (!lines.isEmpty()) {
            String dic[] = lines.remove(0).split(" ");
            String pattern = lines.remove(0);
            findAllWords(dic, pattern);
        }
    }

    public static void findAllWords(String dict[], String pattern) {
        Trie<String> trie = new Trie<>();
        for (String str : dict) {
            trie.insert(Arrays.asList(str.split("")));
        }
    }
}