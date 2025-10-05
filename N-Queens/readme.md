# N-Queens Solution Generator

This program finds all distinct solutions to the N-Queens puzzle, where the goal is to place \$ n \$ queens on an \$ n \times n \$ chessboard such that no two queens threaten each other.

## Problem Overview

The N-Queens problem requires placing \$ n \$ queens on a chessboard so that no two queens share the same row, column, or diagonal. The program returns all possible board configurations that satisfy these constraints.

## How It Works

1. **Initialization:**
    - A 2D character array represents the chessboard, initialized with '.' to indicate empty cells.
    - Three integer arrays track the occupation of rows and both diagonals to ensure no two queens threaten each other.
2. **Core Logic:**
    - The algorithm uses backtracking to try placing a queen in each column.
    - For each column, it iterates through all rows, checking if placing a queen is safe using the tracking arrays.
    - If safe, it places the queen, marks the row and diagonals, and recursively attempts to place queens in the next column.
    - If a solution is found (all columns filled), the current board configuration is added to the result list.
    - The algorithm backtracks by removing the queen and unmarking the row and diagonals.
3. **Returning the Result:**
    - All valid board configurations are collected and returned as a list of lists of strings, where each string represents a row.

## Key Features

- Efficient backtracking with constant-time safety checks using arrays.
- Handles all board sizes from 1 to 9.
- Returns all unique solutions in the required string format.
- Avoids redundant checks by using row and diagonal markers.


## Example Usage

Input:

```java
int n = 4;
```

Output:

```
[
  [".Q..","...Q","Q...","..Q."],
  ["..Q.","Q...","...Q",".Q.."]
]
```

Input:

```java
int n = 1;
```

Output:

```
[
  ["Q"]
]
```


## Java Code

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2 * n - 1];
        int[] lowerDiag = new int[2 * n - 1];
        solve(0, board, res, leftRow, upperDiag, lowerDiag);
        return res;
    }

    private void solve(int col, char[][] board, List<List<String>> res,
                       int[] leftRow, int[] upperDiag, int[] lowerDiag) {
        int n = board.length;
        if (col == n) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[n - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, upperDiag, lowerDiag);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[n - 1 + col - row] = 0;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
```


## Complexity Analysis

- **Time Complexity:** \$ O(N!) \$ — Each queen has up to \$ N \$ choices, but constraints reduce the actual number of possibilities. The backtracking explores all valid placements.
- **Space Complexity:** \$ O(N^2) \$ — For the board and result storage, plus recursion stack up to depth \$ N \$.

***




<div align="center">⁂</div>

[^1]: https://www.geeksforgeeks.org/dsa/n-queen-problem-backtracking-3/

[^2]: https://developers.google.com/optimization/cp/queens

[^3]: https://algo.monster/liteproblems/51

[^4]: https://www.linkedin.com/pulse/n-queen-problem-backtracking-algorithm-dilli-hang-rai-ay9mf

[^5]: https://www.youtube.com/watch?v=xFv_Hl4B83A

[^6]: https://leetcode.com/problems/n-queens/

[^7]: https://en.wikipedia.org/wiki/Eight_queens_puzzle

