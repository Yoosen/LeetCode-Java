/*
 * @lc app=leetcode.cn id=84 lang=java
 * @lcpr version=20004
 *
 * [84] 柱状图中最大的矩形
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length + 2;
        int[] newHeights = new int[len];
        newHeights[0] = newHeights[len - 1] = 0;

        for (int i = 1; i < len - 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        Deque<Integer> st = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && newHeights[i] < newHeights[st.peek()]) {
                int cur = st.pop();
                int left = st.peek();
                int right = i;

                res = Math.max(res, (right - left - 1) * newHeights[cur]);
            }
            st.push(i);
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,5,6,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n
// @lcpr case=end

 */

