/*
 * @lc app=leetcode.cn id=1338 lang=java
 * @lcpr version=30005
 *
 * [1338] 数组大小减半
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // 用最大堆排序频率
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(mp.values());

        int res = 0, count = 0;
        while (!maxHeap.isEmpty()) {
            count += maxHeap.poll();
            res++;
            if (count >= n / 2) {
                break;
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,3,3,3,5,5,5,2,2,7]\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7,7,7]\n
// @lcpr case=end

 */

