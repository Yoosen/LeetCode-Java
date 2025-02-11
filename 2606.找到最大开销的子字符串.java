/*
 * @lc app=leetcode.cn id=2606 lang=java
 * @lcpr version=30003
 *
 * [2606] 找到最大开销的子字符串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length();
        int len = chars.length();
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            arr[chars.charAt(i) - 'a'] = vals[i];
        }

        int[] dp = new int[n + 1];
        int res = 0;
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int val = arr[s.charAt(i - 1) - 'a'];
            dp[i] = Math.max(dp[i - 1] + val, val);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "adaa"\n"d"\n[-1000]\n
// @lcpr case=end

// @lcpr case=start
// "abc"\n"abc"\n[-1,-1,-1]\n
// @lcpr case=end

 */

