/*
 * @lc app=leetcode.cn id=2178 lang=java
 * @lcpr version=20004
 *
 * [2178] 拆分成最多数目的正偶数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();

        if (finalSum % 2 != 0) return res;

        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }

        // 28
        // 2   4   6   8 10
        // 26  22  16  8

        int back = res.size() - 1;
        res.set(back, res.get(back) + finalSum);

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 12\n
// @lcpr case=end

// @lcpr case=start
// 7\n
// @lcpr case=end

// @lcpr case=start
// 28\n
// @lcpr case=end

 */

