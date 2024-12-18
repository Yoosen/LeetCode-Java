/*
 * @lc app=leetcode.cn id=312 lang=java
 * @lcpr version=20004
 *
 * [312] 戳气球
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;

class Solution {
    public int maxCoins(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.add(0, 1);
        list.add(list.size(), 1);
        int n = list.size();

        int[][] dp = new int[n][n];
    
        // 先遍历各种区间长度
        for (int len = 2; len < n; len++) {
            // 再穷举 i, j
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                int maxCoin = 0;
                for (int k = i + 1; k < j; k++) {
                    int coins = dp[i][k] + list.get(i) * list.get(k) * list.get(j) + dp[k][j];
                    maxCoin = Math.max(maxCoin, coins);
                }
                dp[i][j] = maxCoin;
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,1,5,8]\n
// @lcpr case=end

// @lcpr case=start
// [1,5]\n
// @lcpr case=end

 */

