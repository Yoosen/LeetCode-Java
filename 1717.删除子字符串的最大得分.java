/*
 * @lc app=leetcode.cn id=1717 lang=java
 * @lcpr version=30201
 *
 * [1717] 删除子字符串的最大得分
 */

// @lc code=start
class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();

        char a = 'a', b = 'b';
        if (x < y) {
            int t = x;
            x = y;
            y = t;

            char c = a;
            a = b;
            b = c;
        }

        int ans = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == a) {
                cnt1++;
            } else if (c == b) {
                if (cnt1 > 0) {
                    ans += x;
                    cnt1--;
                } else {
                    cnt2++;
                }
            } else {
                // 当前子字符串结算，置0
                ans += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }
        ans += Math.min(cnt1, cnt2) * y;
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "cdbcbbaaabab"\n4\n5\n
// @lcpr case=end

// @lcpr case=start
// "aabbaaxybbaabb"\n5\n4\n
// @lcpr case=end

 */

