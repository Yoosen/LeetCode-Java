/*
 * @lc app=leetcode.cn id=3310 lang=java
 * @lcpr version=20004
 *
 * [3310] 移除可疑的方法
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        // 遍历所有方法调用对，构造邻接表
        for (int[] e : invocations) {
            g[e[0]].add(e[1]);
        }

        // 深度遍历标记所有可疑方法
        boolean[] isSuspicious = new boolean[n];
        dfs(k, g, isSuspicious);

        // 检查是否有【非可疑方法】->【可疑方法】的边
        for (int[] e : invocations) {
            if (!isSuspicious[e[0]] && isSuspicious[e[1]]) {
                // 无法移除可疑方法
                List<Integer> ans = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // 移除所有可疑方法
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    void dfs(int k, List<Integer>[] g, boolean[] isSuspicious) {
        isSuspicious[k] = true;
        for (int y : g[k]) {
            if (!isSuspicious[y]) {
                dfs(y, g, isSuspicious);
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n1\n[[1,2],[0,1],[3,2]]\n
// @lcpr case=end

// @lcpr case=start
// 5\n0\n[[1,2],[0,2],[0,1],[3,4]]\n
// @lcpr case=end

// @lcpr case=start
// 3\n2\n[[1,2],[0,1],[2,0]]\n
// @lcpr case=end

 */

