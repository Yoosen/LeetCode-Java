/*
 * @lc app=leetcode.cn id=63 lang=java
 * @lcpr version=30003
 *
 * [63] 不同路径 II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, - 1);
        }

        return dfs(m - 1, n - 1, obstacleGrid, memo);
    }

    int dfs(int x, int y, int[][] obstacleGrid, int[][] memo) {
        if (x < 0 || y < 0 || obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (x == 0 && y == 0) return 1;

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        return memo[x][y] = dfs(x - 1, y, obstacleGrid, memo) + dfs(x, y - 1, obstacleGrid, memo);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[0,0,0],[0,1,0],[0,0,0]]\n
// @lcpr case=end

/*
// @lcpr case=start
// [[1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1],[0,0]]\n
// @lcpr case=end

 */

