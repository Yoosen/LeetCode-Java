/*
 * @lc app=leetcode.cn id=2144 lang=java
 * @lcpr version=20004
 *
 * [2144] 打折购买糖果的最小开销
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        int len = cost.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(cost);
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans += cost[i];
            if(i - 1 >= 0) ans += cost[i - 1];
            i -= 2;
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [6,5,7,9,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [5,5]\n
// @lcpr case=end

 */

