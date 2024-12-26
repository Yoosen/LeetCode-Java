/*
 * @lc app=leetcode.cn id=3243 lang=java
 * @lcpr version=20004
 *
 * [3243] 新增道路查询后的最短距离 I
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new ArrayList[n - 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            g[i].add(i + 1);
        }

        int[] ans = new int[queries.length];
        int[] vis = new int[n - 1];
        for (int i = 0; i < queries.length; i++) {
            g[queries[i][0]].add(queries[i][1]);
            ans[i] = bfs(i + 1, g, vis, n);
        }

        return ans;
    }

    int bfs(int i, List<Integer>[] g, int[] vis, int n) {
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0] = i;

        int step = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            step++;
            for (int j = 0; j < size; j++) {
                int x = que.poll();
                for (int y : g[x]) {
                    if (y == n - 1) return step;
                    if (vis[y] != i) {
                        vis[y] = i;
                        que.add(y);
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n[[2, 4], [0, 2], [0, 4]]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[[0, 3], [0, 2]]\n
// @lcpr case=end

 */

