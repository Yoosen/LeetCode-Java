/*
 * @lc app=leetcode.cn id=2841 lang=java
 * @lcpr version=30003
 *
 * [2841] 几乎唯一子数组的最大和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        int l = 0, r = 0;
        long res = 0, cur = 0;
        Map<Integer, Integer> freq = new HashMap<>(); // 记录窗口中元素的频率
        int unique = 0; // 记录窗口中唯一元素的数量

        while (r < n) {
            int num = nums.get(r);
            // 更新频率表
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) == 1) {
                unique++; // 如果是新元素，增加唯一元素计数
            }
            cur += num; // 更新当前窗口的和
            r++;

            // 当窗口大小超过 k 时，收缩左边界
            while (r - l > k) {
                int leftNum = nums.get(l);
                // 更新频率表
                freq.put(leftNum, freq.get(leftNum) - 1);
                if (freq.get(leftNum) == 0) {
                    unique--; // 如果元素频率降为 0，减少唯一元素计数
                }
                cur -= leftNum; // 更新当前窗口的和
                l++;
            }

            // 检查当前窗口是否满足条件
            if (r - l == k && unique >= m) {
                res = Math.max(res, cur);
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,6,7,3,1,7]\n3\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1,3]\n2\n2\n
// @lcpr case=end

// @lcpr case=start
// [5,9,9,2,4,5,4]\n1\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,2,1,2,1]\n3\n3\n
// @lcpr case=end

 */

