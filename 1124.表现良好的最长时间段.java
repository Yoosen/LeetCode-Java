/*
 * @lc app=leetcode.cn id=1124 lang=java
 * @lcpr version=20004
 *
 * [1124] 表现良好的最长时间段
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Deque;

class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (preSum[i] < preSum[st.peek()]) {
                st.push(i);
            }
        }

        for (int i = n; i > 0; --i) {
            while (!st.isEmpty() && preSum[i] > preSum[st.peek()]) {
                int x = st.pop();
                ans = Math.max(ans, i - x);
            }
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [9,9,6,0,6,6,9]\n
// @lcpr case=end

// @lcpr case=start
// [6,6,6]\n
// @lcpr case=end

 */

