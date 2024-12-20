/*
 * @lc app=leetcode.cn id=2957 lang=java
 * @lcpr version=20004
 *
 * [2957] 消除相邻近似相等字符
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int ans = 0;

        for (int i = 1; i < word.length(); i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1) {
                ans++;
                i++;
            }
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "aaaaa"\n
// @lcpr case=end

// @lcpr case=start
// "abddez"\n
// @lcpr case=end

// @lcpr case=start
// "zyxyxyz"\n
// @lcpr case=end

 */

