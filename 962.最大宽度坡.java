/*
 * @lc app=leetcode.cn id=962 lang=java
 * @lcpr version=20004
 *
 * [962] 最大宽度坡
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Stack;

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int res = 0;

        Stack<Integer> st  = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || nums[st.peek()] > nums[i]) {
                st.push(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                int x = st.pop();
                res = Math.max(res, i - x);
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [6,0,8,2,1,5]\n
// @lcpr case=end

// @lcpr case=start
// [9,8,1,0,1,9,4,0,4,1]\n
// @lcpr case=end

 */

