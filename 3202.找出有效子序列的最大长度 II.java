/*
 * @lc app=leetcode.cn id=3202 lang=java
 * @lcpr version=30201
 *
 * [3202] 找出有效子序列的最大长度 II
 */

// @lc code=start
class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        for (int m = 0; m < k; m++) {
            int[] f = new int[k];
            for (int x : nums) {
                x %= k;
                f[x] = f[(m - x + k) % k] + 1;
                ans = Math.max(ans, f[x]);
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,4,2,3,1,4]\n3\n
// @lcpr case=end

 */

