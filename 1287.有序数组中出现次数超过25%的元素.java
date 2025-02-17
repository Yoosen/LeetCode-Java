/*
 * @lc app=leetcode.cn id=1287 lang=java
 * @lcpr version=30005
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        int up = 0, cnt = 0, res = -1;

        for (int x : arr) {
            if (x != up) {
                up = x;
                cnt = 0;
            }
            
            cnt++;
            if (cnt > arr.length / 4) {
                res = x;
                break;
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,6,6,6,6,7,10]\n
// @lcpr case=end

 */

