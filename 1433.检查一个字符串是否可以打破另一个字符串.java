/*
 * @lc app=leetcode.cn id=1433 lang=java
 * @lcpr version=20004
 *
 * [1433] 检查一个字符串是否可以打破另一个字符串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return check(chars1, chars2) || check(chars2, chars1);
    }

    boolean check(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] < chars2[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abc"\n"xya"\n
// @lcpr case=end

// @lcpr case=start
// "abe"\n"acd"\n
// @lcpr case=end

// @lcpr case=start
// "leetcodee"\n"interview"\n
// @lcpr case=end

 */

