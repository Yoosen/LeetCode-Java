/*
 * @lc app=leetcode.cn id=901 lang=java
 * @lcpr version=20004
 *
 * [901] 股票价格跨度
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    final Deque<int[]> st = new ArrayDeque<>();
    int curDay = -1;

    public StockSpanner() {
        st.push(new int[]{-1, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        while (price >= st.peek()[1]) {
            st.pop();
        }
        int ans = ++curDay - st.peek()[0];
        st.push(new int[]{curDay, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end



/*
// @lcpr case=start
// ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"][[], [100], [80], [60], [70], [60], [75], [85]]\n
// @lcpr case=end

 */

