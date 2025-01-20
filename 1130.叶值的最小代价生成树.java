/*
 * @lc app=leetcode.cn id=1130 lang=java
 * @lcpr version=20004
 *
 * [1130] 叶值的最小代价生成树
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        int mct = 0;
        st.push(Integer.MAX_VALUE);

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= st.peek()) {
                mct += st.pop() * Math.min(st.peek(), arr[i]);
            }
            st.push(arr[i]);
        }

        while (st.size() > 2) {
            mct += st.pop() * st.peek();
        }

        return mct;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [6,2,4]\n
// @lcpr case=end

// @lcpr case=start
// [4,11]\n
// @lcpr case=end

 */

