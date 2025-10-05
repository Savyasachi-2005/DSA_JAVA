class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0] && dfs(board, wordArr, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int idx) {
        // Check boundaries and matching character
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == '*' || board[i][j] != word[idx]) {
            return false;
        }
        // If all characters matched
        if (idx == word.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '*'; // mark as visited
        boolean found = dfs(board, word, i + 1, j, idx + 1) ||
                        dfs(board, word, i - 1, j, idx + 1) ||
                        dfs(board, word, i, j + 1, idx + 1) ||
                        dfs(board, word, i, j - 1, idx + 1);
        board[i][j] = temp; // backtrack
        return found;
    }
}