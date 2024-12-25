/*
 * @lc app=leetcode.cn id=1319 lang=java
 * @lcpr version=20004
 *
 * [1319] 连通网络的操作次数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {
        UF uf = new UF(n);
        for (int[] e : connections) {
            uf.union(e[0], e[1]);
        }

        // uf size代表几棵树，需要多少个边
        int l = connections.length;     // 总边数
        if (uf.size - 1 > uf.rest) {
            return -1;
        } 
        return uf.size - 1;
    }

    class UF {
        int size;   // 连通分量
        int[] p;
        int rest;   // 多余边数

        UF(int size) {
            this.size = size;
            p = new int[size];

            for (int i = 0; i < size; i++) {
                p[i] = i;
            }

            rest = 0;
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                p[pa] = pb;
                size--;
            } else {
                rest++;
            }
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }

            return p[x];
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n[[0,1],[0,2],[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// 6\n[[0,1],[0,2],[0,3],[1,2],[1,3]]\n
// @lcpr case=end

// @lcpr case=start
// 6\n[[0,1],[0,2],[0,3],[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// 5\n[[0,1],[0,2],[3,4],[2,3]]\n
// @lcpr case=end

 */

