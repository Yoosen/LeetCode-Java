/*
 * @lc app=leetcode.cn id=3074 lang=java
 * @lcpr version=20004
 *
 * [3074] 重新分装苹果
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int num : apple) {
            sum += num;
        }
        
        Arrays.sort(capacity);
        int m = capacity.length - 1;
        int res = 0;

        while (sum > 0) {
            sum -= capacity[m];
            m--;
            res++;
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,2]\n[4,3,1,5,2]\n
// @lcpr case=end

// @lcpr case=start
// [5,5,5]\n[2,4,2,7]\n
// @lcpr case=end

 */

