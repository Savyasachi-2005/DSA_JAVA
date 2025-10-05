<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>

# Word Search in 2D Grid

This program determines if a given word can be found in a 2D grid of characters by tracing adjacent cells (horizontally or vertically), with each cell used at most once per search path.

## Problem Overview

The algorithm searches for a specific word within an m x n grid of letters, returning `true` if the word can be found by moving through adjacent (up, down, left, right) cells without reusing any cell in the same search. The solution uses depth-first search (DFS) to explore possible letter paths for the given word.

## How It Works

1. **Initialization:**
    - Convert the target word into a character array for efficient indexing.
    - Iterate through every cell on the board as a potential starting point.
2. **Core Logic:**
    - For each cell that matches the first letter of the word, initiate a DFS to check for the complete word path.
    - The DFS marks each visited cell temporarily to avoid revisiting.
    - For each DFS call, move to neighboring unvisited cells if the next character matches.
    - The search backtracks (unmarks the cell) if the path does not yield a solution.
3. **Returning the Result:**
    - If any DFS search finds the word, return `true`.
    - After all attempts, return `false` if the word is not found.

## Key Features

- Uses DFS with backtracking for efficient traversal.
- Prevents revisiting the same cell in a single search path.
- Handles edge cases like words not present or reusing letters.
- Early exit upon finding the word improves efficiency.


## Example Usage

Input:

```java
char[][] board = {
  {'A','B','C','E'},
  {'S','F','C','S'},
  {'A','D','E','E'}
};
String word = "ABCCED";
```

Output:

```
true
```

Input:

```java
char[][] board = {
  {'A','B','C','E'},
  {'S','F','C','S'},
  {'A','D','E','E'}
};
String word = "ABCB";
```

Output:

```
false
```


## Complexity Analysis

- **Time Complexity:** O(m * n * 4^L), where $m, n$ are the dimensions of the board and $L$ is the length of the word. Each cell initiates a DFS that can branch in up to 4 directions for each step.
- **Space Complexity:** O(L), where $L$ is the word length, accounting for the recursion stack depth due to backtracking.

