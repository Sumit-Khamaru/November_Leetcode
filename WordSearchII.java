import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    /*
    Naive Approach : we iterate the Words array take every String and check if we can make the word by using Dfs approach
    if yes then add the word in our ans and return
     */
//    The dfs fun take m * m time and we call the function for len of the Words array , O(n * m* l)
//    S.C. = O(n * m)
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        if (board == null || board.length < 1 || board[0].length < 1 || words == null || words.length < 1) {
            return new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            if (findWord(board, words[i])) {
                set.add(words[i]);
            }
        }
        return new ArrayList<>(set);
    }
    private static boolean findWord(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(int x, int y, int index, char[][] board, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || visited[x][y] || word.charAt(index) != board[x][y]) {
            return false;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            if (dfs(x + dir[0], y + dir[1], index + 1, board, word, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][]board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));
        System.out.println(findWords1(board, words));
    }
    // Using Trie-DataStructure
    public static List<String> findWords1(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length; int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs1(board, i, j, root, res);
            }
        }
        return res;
    }

    private static void dfs1(char[][] board, int i, int j, TrieNode root, List<String> res) {
        char c = board[i][j];
        if(c == ';' || root.children[c - 'a'] == null) return;

        root = root.children[c - 'a'];
        if(root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        if(i < 0 || j < 0 || i> board.length- 1 || j > board[0].length - 1) return;
        board[i][j] = ';';
        dfs1(board, i - 1, j, root, res);
        dfs1(board, i , j - 1, root, res);
        dfs1(board, i + 1, j, root, res);
        dfs1(board, i , j + 1, root, res);
       board[i][j] = c;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                int i = c - 'a';
                if(p.children[i] == null) p.children[i] = new TrieNode();
                p =p.children[i];
            }
            p.word = word;
        }
        return root;
    }
}
class TrieNode{
    TrieNode[] children;
    String word;

    TrieNode() {
        children = new TrieNode[26];
    }
}
/*
    Try out the solution using Trie data-structure
 */
