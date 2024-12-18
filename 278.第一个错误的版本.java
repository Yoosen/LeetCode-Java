/*
 * @lc app=leetcode.cn id=278 lang=java
 * @lcpr version=20003
 *
 * [278] 第一个错误的版本
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;

        int first = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n4\n
// @lcpr case=end

// @lcpr case=start
// 1\n1\n
// @lcpr case=end

 */

