/*
 * @lc app=leetcode.cn id=2279 lang=java
 * @lcpr version=20004
 *
 * [2279] 装满石头的背包的最大数量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(left);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= left[i]) {
                additionalRocks -= left[i];
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,4,5]\n[1,2,4,4]\n2\n
// @lcpr case=end

// @lcpr case=start
// [10,2,2]\n[2,2,0]\n100\n
// @lcpr case=end

 */

