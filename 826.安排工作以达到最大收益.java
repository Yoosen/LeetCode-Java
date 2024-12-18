/*
 * @lc app=leetcode.cn id=826 lang=java
 * @lcpr version=20004
 *
 * [826] 安排工作以达到最大收益
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // 将工作难度升序排序
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // 将工人能力升序排序
        Arrays.sort(worker);

        int ans = 0, j = 0;
        int p = 0;          // 每个工人可以获得的最大收益
        // 遍历每个工人，试图找到这个人能力对应的最大收益
        for (int w : worker) {
            
            while(j < n && w >= jobs[j][0]) {
                // i + 1 一定不会比 i 个工人能获得的收益少
                p = Math.max(p, jobs[j][1]);
                j++;
            }
            ans += p;
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,6,8,10]\n[10,20,30,40,50]\n[4,5,6,7]\n
// @lcpr case=end

// @lcpr case=start
// [85,47,57]\n[24,66,99]\n[40,25,25]\n
// @lcpr case=end

 */

