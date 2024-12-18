/*
 * @lc app=leetcode.cn id=6 lang=java
 * @lcpr version=20003
 *
 * [6] Z 字形变换
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            rows.get(i).append(c);
            i += flag;
        }

        StringBuilder res = new StringBuilder();

        for (StringBuilder sb : rows) {
            res.append(sb);
        }

        return res.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "PAYPALISHIRING"\n3\n
// @lcpr case=end

// @lcpr case=start
// "PAYPALISHIRING"\n4\n
// @lcpr case=end

// @lcpr case=start
// "A"\n1\n
// @lcpr case=end

 */

