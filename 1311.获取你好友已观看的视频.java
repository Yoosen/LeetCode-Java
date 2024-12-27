/*
 * @lc app=leetcode.cn id=1311 lang=java
 * @lcpr version=20004
 *
 * [1311] 获取你好友已观看的视频
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        int n = friends.length;
        boolean[] vis = new boolean[n];
        
        q.offer(id);
        vis[id] = true;

        while(!q.isEmpty() && level > 0) {
            level--;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                for (int j = 0; j < friends[x].length; j++) {
                    if (!vis[friends[x][j]]) {
                        q.offer(friends[x][j]);
                        vis[friends[x][j]] = true;
                    }
                }
            }
        }

        // 统计目标层级好友的视频观看频率
        Map<String, Integer> cnts = new HashMap<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (String video : watchedVideos.get(cur)) {
                cnts.put(video, cnts.getOrDefault(video, 0) + 1);
            }
        }

        // 按照观看次数和字典序排序
        List<String> ans = new ArrayList<>(cnts.keySet());
        ans.sort((a, b) -> cnts.get(a).equals(cnts.get(b)) ? a.compareTo(b) : cnts.get(a) - cnts.get(b));
        
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["A","B"],["C"],["B","C"],["D"]]\n[[1,2],[0,3],[0,3],[1,2]]\n0\n1\n
// @lcpr case=end

// @lcpr case=start
// [["A","B"],["C"],["B","C"],["D"]]\n[[1,2],[0,3],[0,3],[1,2]]\n0\n2\n
// @lcpr case=end

 */

