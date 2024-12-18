/*
 * @lc app=leetcode.cn id=413 lang=java
 * @lcpr version=20004
 *
 * [413] 等差数列划分
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

