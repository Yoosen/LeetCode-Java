/*
 * @lc app=leetcode.cn id=931 lang=java
 * @lcpr version=20004
 *
 * [931] 下降路径最小和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    int res = Integer.MAX_VALUE;
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++) {
            res = Math.min(res, dfs(matrix, m - 1, j));
        }

        return res;
    }

    int dfs(int[][] matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;

        if (j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        
        return memo[i][j] = Math.min(dfs(matrix,i - 1, j - 1), Math.min(dfs(matrix, i - 1, j), dfs(matrix, i - 1, j + 1))) + matrix[i][j];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,3],[6,5,4],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[-19,57],[-40,-5]]\n
// @lcpr case=end

 */

