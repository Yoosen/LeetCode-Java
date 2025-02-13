/*
 * @lc app=leetcode.cn id=1561 lang=java
 * @lcpr version=30004
 *
 * [1561] 你可以获得的最大硬币数目
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);

        int res = 0;
        for (int i = n / 3; i < n; i += 2) {
            res += piles[i];
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,1,2,7,8]\n
// @lcpr case=end

// @lcpr case=start
// [2,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [9,8,7,6,5,1,2,3,4]\n
// @lcpr case=end

 */

