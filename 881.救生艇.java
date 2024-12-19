/*
 * @lc app=leetcode.cn id=881 lang=java
 * @lcpr version=20004
 *
 * [881] 救生艇
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        int ans = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (people[l] + people[r] > limit) {
                ans++;
                r--;
            } else {
                ans++;
                l++;
                r--;
            }
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [3,2,2,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [3,5,3,4]\n5\n
// @lcpr case=end

 */

