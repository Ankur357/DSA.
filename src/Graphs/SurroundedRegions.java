package Graphs;

public class SurroundedRegions {

    static class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) return;

            int m = board.length;
            int n = board[0].length;

            // Step 1: Perform DFS from the borders
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }

            // Step 2: Replace surrounded 'O' with 'X' and 'T' back to 'O'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X'; // Surrounded 'O' turned to 'X'
                    } else if (board[i][j] == 'T') {
                        board[i][j] = 'O'; // Non-surrounded 'O' turned back to 'O'
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            // Check bounds and 'O' cell
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }

            // Mark the cell as visited with a special character 'T'
            board[i][j] = 'T';

            // Explore the neighbors (up, down, left, right)
            dfs(board, i + 1, j); // down
            dfs(board, i - 1, j); // up
            dfs(board, i, j + 1); // right
            dfs(board, i, j - 1); // left
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: Surrounded Regions Test Case
        char[][] board1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        sol.solve(board1);
        System.out.println("Board after solve (Example 1):");
        printBoard(board1);

        // Example 2: Another Surrounded Regions Test Case
        char[][] board2 = {
                {'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };

        sol.solve(board2);
        System.out.println("Board after solve (Example 2):");
        printBoard(board2);
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}