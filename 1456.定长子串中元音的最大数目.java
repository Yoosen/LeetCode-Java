/*
 * @lc app=leetcode.cn id=1456 lang=java
 * @lcpr version=20004
 *
 * [1456] 定长子串中元音的最大数目
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        int l = 0, r = 0;

        int res = 0;
        int windowsVowelNums = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;

            if (isVowel(c)) {
                windowsVowelNums++;
            }

            while (r - l >= k) {
                char d = s.charAt(l);
                res = Math.max(res, windowsVowelNums);
                l++;
                if (isVowel(d)) {
                    windowsVowelNums--;
                }
            }
        }

        return res;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abciiidef"\n3\n
// @lcpr case=end

// @lcpr case=start
// "aeiou"\n2\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n3\n
// @lcpr case=end

// @lcpr case=start
// "rhythms"\n4\n
// @lcpr case=end

// @lcpr case=start
// "tryhard"\n4\n
// @lcpr case=end

 */

