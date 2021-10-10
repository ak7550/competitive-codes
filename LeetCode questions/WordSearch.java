import AkPackage.*;
import java.util.*;


public class WordSearch {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new WordSearch());
        while (!lines.isEmpty()) {
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines);
        }
    }
}