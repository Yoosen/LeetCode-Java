/*
 * @lc app=leetcode.cn id=3115 lang=java
 * @lcpr version=20004
 *
 * [3115] 质数的最大距离
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int l = 0; 
        int r = nums.length - 1;

        while (!isPrime(nums[l])) l++;
        while (!isPrime(nums[r])) r--;

        return r - l;
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,9,5,3]\n
// @lcpr case=end

// @lcpr case=start
// [4,8,2,8]\n
// @lcpr case=end

 */

