/*
 * @lc app=leetcode.cn id=1052 lang=java
 * @lcpr version=20004
 *
 * [1052] 爱生气的书店老板
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int initial = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                initial += customers[i];
            }
        }

        int l = 0, r = 0;
        int cur = initial;
        int res = initial;
        while (r < n) {
            if (grumpy[r] == 1) {
                cur += customers[r];
            }

            while (r - l + 1> minutes) {
                if (grumpy[l] == 1) {
                    cur -= customers[l];
                }

                l++;
            }

            // 更新最大满意度
            res = Math.max(res, cur);
            r++;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,1,2,1,1,7,5]\n[0,1,0,1,0,1,0,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n[0]\n1\n
// @lcpr case=end

 */

