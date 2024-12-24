/*
 * @lc app=leetcode.cn id=2101 lang=java
 * @lcpr version=20004
 *
 * [2101] 引爆最多的炸弹
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int i = 0; i < n; i++) {
            long x = bombs[i][0];
            long y = bombs[i][1];
            long r = bombs[i][2];

            for (int j = 0; j < n; j++) {
                long dx = bombs[j][0] - x;
                long dy = bombs[j][1] - y;
                long dr = bombs[j][2] - r;

                if (j != i && dx * dx + dy * dy <= r * r) {
                    g[i].add(j);
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfs(i, g, vis));
        }

        return ans;
    }

    int dfs(int x, List<Integer>[] g, boolean[] vis) {
        vis[x] = true;
        int count = 1;

        for (int y : g[x]) {
            if (!vis[y]) {
                count += dfs(y, g, vis);
            }
        }

        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,3],[6,1,4]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1,5],[10,10,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]\n
// @lcpr case=end

 */

