/*
 * @lc app=leetcode.cn id=474 lang=java
 * @lcpr version=20004
 *
 * [474] 一和零
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    String[] strs;
    int[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        this.strs = strs;
        int len = strs.length;

        memo = new int[len][m + 1][n + 1];

        for (int[][] me : memo) {
            for (int[] row : me) {
                Arrays.fill(row, -1);
            }
        }

        return dfs(len - 1, m, n);
    }

    // 索引 0容量 1容量
    int dfs(int i, int m, int n) {
        if (i < 0) {
            return 0;
        }

        if (memo[i][m][n] != -1) {
            return memo[i][m][n];
        }

        int[] count = countZerosAndOnes(strs[i]);
        // 只能不选
        if (count[0] > m || count[1] > n) {
            return memo[i][m][n] = dfs(i - 1, m, n);
        }

        return memo[i][m][n] = Math.max(dfs(i - 1, m, n), dfs(i - 1, m - count[0], n - count[1]) + 1);
    }

    int[] countZerosAndOnes(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["10", "0001", "111001", "1", "0"]\n5\n3\n
// @lcpr case=end

// @lcpr case=start
// ["10", "0", "1"]\n1\n1\n
// @lcpr case=end

 */

