/*
 * @lc app=leetcode.cn id=3487 lang=java
 * @lcpr version=30202
 *
 * [3487] 删除后的最大子数组元素和
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {
        int s = 0, mx = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (x < 0) {
                mx = Math.max(mx, x);
            } else if (set.add(x)) {
                s += x;
            }
        }

        return set.isEmpty() ? mx : s;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,-1,-2,1,0,-1]\n
// @lcpr case=end

 */

