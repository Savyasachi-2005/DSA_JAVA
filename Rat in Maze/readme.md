
# Rat in a Maze

Finds all paths from the top-left to the bottom-right of a maze, moving only through open cells (1), without revisiting any cell in a path.

## How It Works

- **Backtracking Approach:**
    - The algorithm starts at (0,0) and recursively explores all four directions: Down (D), Left (L), Right (R), Up (U).
    - It uses a `vis` (visited) matrix to mark cells already used in the current path, preventing cycles.
    - If a move leads to the destination (n-1, n-1), the current path string is added to the answer list.
    - After exploring a move, the cell is unmarked (backtracked) to allow other paths to use it.
    - Only valid moves (within bounds, not blocked, not visited) are considered.
- **Lexicographical Order:**
    - The directions are tried in the order D, L, R, U to ensure the resulting paths are generated in lexicographically sorted order.


## Example Usage

Input:

```java
int[][] maze = {
  {1, 0, 0, 0},
  {1, 1, 0, 1},
  {1, 1, 0, 0},
  {0, 1, 1, 1}
};
```

Output:

```
["DDRDRR", "DRDDRR"]
```


## Java Code

```java
import java.util.ArrayList;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        int[][] vis = new int[n][n];
        int[] di = {1, 0, 0, -1}; // D, L, R, U
        int[] dj = {0, -1, 1, 0};
        if (maze[^0][^0] == 1) {
            vis[^0][^0] = 1;
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
```


## Complexity

- **Time:** $O(4^{n^2})$ in the worst case, as each cell can branch in four directions.
- **Space:** $O(n^2)$ for the visited matrix and recursion stack.


## Explanation of the Code

- The main function `ratInMaze` initializes the answer list, visited matrix, and direction arrays.
- It checks if the starting cell is open. If so, it marks it as visited and starts the recursive backtracking.
- The `backtrack` function:
    - If the destination is reached, adds the current path to the answer list.
    - For each direction (D, L, R, U), it checks if the next cell is within bounds, open, and not visited.
    - Marks the cell as visited, appends the direction to the path, and recurses.
    - After recursion, unmarks the cell (backtracks) to allow other paths.
- The result is a list of all possible paths, sorted lexicographically by construction order.
<span style="display:none">[^1][^2][^3][^4][^5][^6][^7]</span>

<div align="center">⁂</div>

[^1]: https://www.geeksforgeeks.org/dsa/rat-in-a-maze/

[^2]: https://takeuforward.org/data-structure/rat-in-a-maze/

[^3]: https://www.enjoyalgorithms.com/blog/rat-in-a-maze/

[^4]: https://www.geeksforgeeks.org/dsa/rat-in-a-maze-backtracking-using-stack/

[^5]: https://dev.to/kishore_kumar_g7/finding-the-way-backtracking-algorithm-for-rat-in-a-maze-101j

[^6]: https://www.youtube.com/watch?v=D8Yze9CDDAw

[^7]: https://leetcode.com/discuss/post/2073103/rat-in-a-maze-problem/

