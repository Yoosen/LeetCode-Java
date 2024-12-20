/*
 * @lc app=leetcode.cn id=3192 lang=java
 * @lcpr version=20004
 *
 * [3192] 使二进制数组全部等于 1 的最少操作次数 II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 一般地，设遍历到 x=nums[i] 时，之前执行了 k 次操作，分类讨论：

// 如果 x=0 且 k 是奇数，或者 x=1 且 k 是偶数，那么这 k 次操作执行完后 nums[i] 变成 1。所以如果 
// x = kmod 2，则不需要操作。
// 如果 x=0 且 k 是偶数，或者 x=1 且 k 是奇数，那么这 k 次操作执行完后 nums[i] 变成 0。所以如果 x=kmod2，则一定要操作。

class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;

        for (int x : nums) {
            if (x == ans % 2) {
                ans++;
            }
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,1,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,0,0]\n
// @lcpr case=end

 */

