/*
 * @lc app=leetcode.cn id=2684 lang=java
 * @lcpr version=20004
 *
 * [2684] 矩阵中移动的最大次数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    int res = 0;
    public int maxMoves(int[][] grid) {
        int m = grid.length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
    
        }

        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        res = Math.max(res, j);
        if (res == grid[0].length - 1) {
            return ;
        }
        
        // 遍历三个点
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(grid, k, j + 1);
            }
        }

        grid[i][j] = 0;
    }

}
// @lc code=end



/*
// @lcpr case=start
// [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,2,4],[2,1,9],[1,1,7]]\n
// @lcpr case=end

 */

