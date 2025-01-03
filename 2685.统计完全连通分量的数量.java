/*
 * @lc app=leetcode.cn id=2685 lang=java
 * @lcpr version=20004
 *
 * [2685] 统计完全连通分量的数量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer>[] g;
    boolean[] vis;
    int v, e;       // 点,边

    public int countCompleteComponents(int n, int[][] edges) {
        vis = new boolean[n];
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                v = 0;
                e = 0;
                dfs(i);
                if (e == v * (v - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int x) {
        vis[x] = true;
        v++;
        e += g[x].size();
        for (int y : g[x]) {
            if (!vis[y]) {
                dfs(y);
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 6\n[[0,1],[0,2],[1,2],[3,4]]\n
// @lcpr case=end

// @lcpr case=start
// 6\n[[0,1],[0,2],[1,2],[3,4],[3,5]]\n
// @lcpr case=end

 */

