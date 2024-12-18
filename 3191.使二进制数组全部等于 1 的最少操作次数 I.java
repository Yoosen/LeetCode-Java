/*
 * @lc app=leetcode.cn id=3191 lang=java
 * @lcpr version=20004
 *
 * [3191] 使二进制数组全部等于 1 的最少操作次数 I
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }

        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {
            return -1;
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,1,1,0,0]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,1,1]\n
// @lcpr case=end

 */

