/*
 * @lc app=leetcode.cn id=494 lang=java
 * @lcpr version=20004
 *
 * [494] 目标和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {

    int[][] memo;
    public int findTargetSumWays(int[] nums, int target) {
        int m = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        sum -= Math.abs(target);
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }
        memo = new int[m][sum / 2 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, m - 1, sum / 2);
    }

    //  索引，容量
    int dfs(int[] nums, int i, int c) {
        // 如果 i < 0，表示已经处理完所有元素：
        // 如果此时背包容量 c == 0，则找到一个有效方案，返回 1；
        // 否则返回 0。
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }

        if (memo[i][c] != -1) {
            return memo[i][c];
        }

        if (nums[i] > c) {
            return memo[i][c] = dfs(nums, i - 1, c);
        }
        
        return memo[i][c] = dfs(nums, i - 1, c) + dfs(nums, i - 1, c - nums[i]);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,1,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

