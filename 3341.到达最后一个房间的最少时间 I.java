/*
 * @lc app=leetcode.cn id=3341 lang=java
 * @lcpr version=20004
 *
 * [3341] 到达最后一个房间的最少时间 I
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});   // {time, x, y}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], x = cur[1], y = cur[2];

            if (x == m - 1 && y == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int waitTime = Math.max(moveTime[nx][ny], time) + 1;
                    if (waitTime < dist[nx][ny]) {
                        dist[nx][ny] = waitTime;
                        pq.offer(new int[]{waitTime, nx, ny});
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
// [[0,4],[4,4]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,0],[0,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1],[1,2]]\n
// @lcpr case=end

 */

