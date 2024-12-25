/*
 * @lc app=leetcode.cn id=841 lang=java
 * @lcpr version=20004
 *
 * [841] 钥匙和房间
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // List<Integer>[] g = new ArrayList[n];
        // for (List<Integer> room : rooms) {
            
        // }

        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        dfs(0, rooms, vis);

        for (boolean b : vis) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    void dfs(int x, List<List<Integer>> rooms, boolean[] vis) {
        vis[x] = true;
        for (int y : rooms.get(x)) {
            if (!vis[y]) {
                dfs(y, rooms, vis);
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1],[2],[3],[]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,3],[3,0,1],[2],[0]]\n
// @lcpr case=end

 */

