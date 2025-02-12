/*
 * @lc app=leetcode.cn id=976 lang=java
 * @lcpr version=30004
 *
 * [976] 三角形的最大周长
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                res = Math.max(res, nums[i] + nums[i - 1] + nums[i - 2]);
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,10]\n
// @lcpr case=end

 */

