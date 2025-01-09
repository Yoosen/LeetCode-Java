/*
 * @lc app=leetcode.cn id=886 lang=java
 * @lcpr version=20004
 *
 * [886] 可能的二分法
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    boolean[] vis;
    boolean[] color;
    boolean ok = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] g = new ArrayList[n + 1];
        vis = new boolean[n + 1];
        color = new boolean[n + 1];

        Arrays.setAll(g, e -> new ArrayList<>());

        for (int[] dis : dislikes) {
            g[dis[0]].add(dis[1]);
            g[dis[1]].add(dis[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(g, i);
            }
        }

        return ok;
    }

    void dfs(List<Integer>[] g, int x) {
        vis[x] = true;

        if (!ok) return ;

        for (int y : g[x]) {
            if (!vis[y]) {
                color[y] = !color[x];
                dfs(g, y);
            } else {
                if (color[y] == color[x]) {
                    ok = false;
                    return ;
                }
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n[[1,2],[1,3],[2,4]]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[[1,2],[1,3],[2,3]]\n
// @lcpr case=end

// @lcpr case=start
// 5\n[[1,2],[2,3],[3,4],[4,5],[1,5]]\n
// @lcpr case=end

 */

