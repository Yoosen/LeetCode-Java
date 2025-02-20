/*
 * @lc app=leetcode.cn id=2369 lang=java
 * @lcpr version=30005
 *
 * [2369] 检查数组是否存在有效划分
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] && nums[i] == nums[i - 1] ||
                i > 1 && dp[i - 2] && (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
                dp[i + 1] = true;
            }
        }

        return dp[n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,4,4,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1,2]\n
// @lcpr case=end

 */

