/*
 * @lc app=leetcode.cn id=3226 lang=java
 * @lcpr version=20004
 *
 * [3226] 使两个整数相等的位更改次数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minChanges(int n, int k) {
        return (n & k) == k ? Integer.bitCount(n ^ k) : -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 13\n4\n
// @lcpr case=end

// @lcpr case=start
// 21\n21\n
// @lcpr case=end

// @lcpr case=start
// 14\n13\n
// @lcpr case=end

 */

