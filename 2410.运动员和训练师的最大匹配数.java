/*
 * @lc app=leetcode.cn id=2410 lang=java
 * @lcpr version=20004
 *
 * [2410] 运动员和训练师的最大匹配数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int preIndex = 0;
        int ans = 0;
        for (int player : players) {
            for (int i = preIndex; i < trainers.length; i++) {
                if (player <= trainers[i]) {
                    ans++;
                    preIndex = i + 1;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,7,9]\n[8,2,5,8]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1]\n[10]\n
// @lcpr case=end

 */

