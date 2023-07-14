import AkPackage.*;

import java.util.*;

class Trie {
    char value;
    Trie[] children;
    boolean isWord;

    Trie() {
        children = new Trie[26];
        isWord = false;
    }

    Trie(char ch) {
        value = ch;
        children = new Trie[26];
        isWord = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for (char ch : word.toCharArray()) {
            if (trie.children[ch - 'a'] == null) {
                trie.children[ch - 'a'] = new Trie();
            }
            trie = trie.children[ch - 'a'];
        }

        trie.isWord = true;
    }

    @Override
    public String toString() {
        return "Trie{" + "isWordEnd=" + isWord + ", children=" + children + '}';
    }

}

public class WordSearch2 {
    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new WordSearch2());
        while (!lines.isEmpty()) {
            String[] str = lines.remove(0).split(" ");
            char board[][] = { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
                    { 'a', 'f', 'l', 'v' } };
            System.out.println("for ip:" + Arrays.deepToString(board));
            System.out.println("weords:" + Arrays.toString(str));
            System.out.println("ans: " + wordSearch(board, str));
        }
    }

    private static List<String> wordSearch(char[][] board, String[] str) {
        Trie trie = new Trie();
        for (String string : str) {
            trie.insert(string);
        }

        List<String> ans = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char ch = board[row][col];
                if (trie.children[ch - 'a'] == null) {
                    continue;
                }
                dfs(row, col, board, new boolean[board.length][board[0].length], new StringBuilder(), ans,
                        trie.children[ch - 'a']);
            }
        }

        return ans;
    }

    private static void dfs(int row, int col, char board[][], boolean visited[][], StringBuilder str, List<String> ans,
            Trie trie) {
        char ch = board[row][col];
        visited[row][col] = true;
        str.append(ch);
        if (trie.isWord) {
            ans.add(str.toString());
        }

        int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int dir[] : dirs) {
            int r = row + dir[0], c = col + dir[1];

            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
                continue;
            if (visited[r][c])
                continue;

            char cc = board[r][c];
            if (trie.children[cc - 'a'] == null)
                continue;

            dfs(r, c, board, visited, str, ans, trie.children[cc - 'a']);

        }

        str.deleteCharAt(str.length() - 1);
        visited[row][col] = false;
    }

}