import AkPackage.*;
import java.util.*;


public class WordSearch {
    public static void main(String args[]){
        ArrayList<String> lines= InputOutput.takeCompleteInput(new WordSearch());
        while (!lines.isEmpty()) {
            int mat[][] = Graph.takeAdjacencyMatrixInput(lines);
            char board[][] = new char[mat.length][mat[0].length];
            for(int r =0 ; r<mat.length; r++){
                for (int i = 0; i < mat[0].length; i++) {
                    board[r][i] = (char) (mat[r][i] + 'a');
                }
            }
            String word = lines.remove(0);
            System.out.println("For ip: " + Arrays.deepToString(board));
            System.out.println("ans: "+ wordSearch(board, word));
        }
    }

    private static boolean wordSearch(char[][] board, String word) {
        int visited[][] = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, visited, r, c, 0, word))
                    return true;
            }
        }

        return false;
    }

    private static int dires[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private static boolean dfs(char board[][], int visited[][], int r, int c, int index, String word) {
        if (index == word.length())
            return true;
        if (board[r][c] != word.charAt(index)) {
            return false;
        }
        visited[r][c] = 1;
        board[r][c] = '*';
        for (int dir[] : dires) {
            int rr = r + dir[0], cc = c + dir[1];
            if (rr < 0 || cc < 0 || rr >= board.length || cc >= board[0].length || board[rr][cc] == '*')
                continue;

            if (dfs(board, visited, rr, cc, index + 1, word))
                return true;
        }

        return index +1 == word.length();
    }
}