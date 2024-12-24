/*
 * @lc app=leetcode.cn id=1971 lang=java
 * @lcpr version=20004
 *
 * [1971] 寻找图中是否存在路径
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // List<Integer>[] g = new ArrayList[n];
        // Arrays.setAll(g, i -> new ArrayList<>());

        // for (int[] e : edges) {
        //     g[e[0]].add(e[1]);
        //     g[e[1]].add(e[0]);
        // }

        // boolean[] visited = new boolean[n];
        // dfs(source, g, visited);

        // return visited[destination];

        UF uf = new UF(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }

        return uf.find(source) == uf.find(destination);
    }

    class UF {
        int size;
        int[] p;
        UF(int size) {
            this.size = size;
            this.p = new int[size];

            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
        }

        void union(int x, int y) {
            int pa = find(x);
            int pb = find(y);

            if (pa == pb) {
                return ;
            }

            p[pa] = pb;
            size--;
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }

            return p[x];
        }
    }

    // void dfs(int source, List<Integer>[] g, boolean[] visited) {
    //     visited[source] = true;
    //     for(int x : g[source]) {
    //         if (!visited[x]) {   
    //             dfs(x, g, visited);
    //         }
    //     }
    // }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n[[0,1],[1,2],[2,0]]\n0\n2\n
// @lcpr case=end

// @lcpr case=start
// 6\n[[0,1],[0,2],[3,5],[5,4],[4,3]]\n0\n5\n
// @lcpr case=end

 */

