/*
 * @lc app=leetcode.cn id=1221 lang=java
 * @lcpr version=20004
 *
 * [1221] 分割平衡字符串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;

        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                r++;
            } else {
                l++;
            }
            if (r == l) ans++;
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "RLRRLLRLRL"\n
// @lcpr case=end

// @lcpr case=start
// "RLRRRLLRLL"\n
// @lcpr case=end

// @lcpr case=start
// "LLLLRRRR"\n
// @lcpr case=end

 */

