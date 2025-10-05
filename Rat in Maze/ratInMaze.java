import java.util.ArrayList;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        int[][] vis = new int[n][n];
        int[] di = {1, 0, 0, -1}; // D, L, R, U
        int[] dj = {0, -1, 1, 0};
        if (maze[0][0] == 1) {
            vis[0][0] = 1;
            backtrack(0, 0, maze, n, ans, "", vis, di, dj);
        }
        return ans;
    }

    private void backtrack(int i, int j, int[][] maze, int n, ArrayList<String> ans,
                           String move, int[][] vis, int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int idx = 0; idx < 4; idx++) {
            int nexti = i + di[idx];
            int nextj = j + dj[idx];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                vis[nexti][nextj] == 0 && maze[nexti][nextj] == 1) {
                vis[nexti][nextj] = 1;
                backtrack(nexti, nextj, maze, n, ans, move + dir.charAt(idx), vis, di, dj);
                vis[nexti][nextj] = 0;
            }
        }
    }
}
