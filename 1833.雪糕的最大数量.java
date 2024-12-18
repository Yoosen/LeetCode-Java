/*
 * @lc app=leetcode.cn id=1833 lang=java
 * @lcpr version=20004
 *
 * [1833] 雪糕的最大数量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int ans = 0;
        Arrays.sort(costs);

        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,2,4,1]\n7\n
// @lcpr case=end

// @lcpr case=start
// [10,6,8,7,7,8]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,6,3,1,2,5]\n20\n
// @lcpr case=end

 */

