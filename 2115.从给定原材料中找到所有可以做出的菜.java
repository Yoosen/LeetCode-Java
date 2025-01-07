/*
 * @lc app=leetcode.cn id=2115 lang=java
 * @lcpr version=20004
 *
 * [2115] 从给定原材料中找到所有可以做出的菜
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // 建图
        Map<String, List<String>> graph = new HashMap<>();
        // 每个菜入度
        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];  // 每道菜
            List<String> ingList = ingredients.get(i); // 菜对应的原材料

            // 遍历原材料
            for (String ing : ingList) {
                graph.putIfAbsent(ing, new ArrayList<>());
                graph.get(ing).add(recipe); // 原材料指向菜
            }

            inDegree.put(recipe, ingList.size());
        }

        // 将初始原材料加入队列
        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (!graph.containsKey(cur)) continue;

            // 遍历当前原材料指向的所有的菜
            for (String recipe : graph.get(cur)) {
                inDegree.put(recipe, inDegree.get(recipe) - 1); // 满足一个条件，当前菜的入度减一
                // 入度为0，满足条件，加入到结果集中
                if (inDegree.get(recipe) == 0) {
                    result.add(recipe);
                    // 加入到原材料集合中
                    queue.offer(recipe);
                }
            }
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["bread"]\n[["yeast","flour"]]\n["yeast","flour","corn"]\n
// @lcpr case=end

// @lcpr case=start
// ["bread","sandwich"]\n[["yeast","flour"],["bread","meat"]]\n["yeast","flour","meat"]\n
// @lcpr case=end

// @lcpr case=start
// ["bread","sandwich","burger"]\n[["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]]\n["yeast","flour","meat"]\n
// @lcpr case=end

// @lcpr case=start
// ["bread"]\n[["yeast","flour"]]\n["yeast"]\n
// @lcpr case=end

 */

