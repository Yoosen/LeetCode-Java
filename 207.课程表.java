/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=20004
 *
 * [207] 课程表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] vis = new int[numCourses];

        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0 && dfs(i, g, vis)) {
                return false; // 有环
            }
        }
        return true;
    }

    boolean dfs(int x, List<Integer>[] g, int[] vis) {
        vis[x] = 1;
        for (int y : g[x]) {          
            if (vis[y] == 1 || (vis[y] == 0 && dfs(y, g, vis))) {
                return true;
            }
        }
        vis[x] = 2;
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

