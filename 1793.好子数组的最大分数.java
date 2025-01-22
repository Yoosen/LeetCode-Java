/*
 * @lc app=leetcode.cn id=1793 lang=java
 * @lcpr version=20004
 *
 * [1793] 好子数组的最大分数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 存当前元素左侧小于它，右侧也小于它的下标
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];

            if (l < k && k < r) {
                res = Math.max(res, nums[i] * (r - l - 1));
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,3,7,4,5]\n3\n
// @lcpr case=end

// @lcpr case=start
// [5,5,4,5,4,1,1,1]\n0\n
// @lcpr case=end

 */

