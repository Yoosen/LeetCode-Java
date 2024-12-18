/*
 * @lc app=leetcode.cn id=1889 lang=java
 * @lcpr version=20004
 *
 * [1889] 装包裹的最小浪费空间
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        long ans = Long.MAX_VALUE;

        Arrays.sort(packages);
        // 构建前缀和数组是为了加速计算浪费的空间
        int n = packages.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + packages[i - 1];
        }

        // 1.遍历每个供应商
        for (int[] box : boxes) {
            // 当前供应商的一些参数
            long cur = 0;           // 当前供应商浪费的空间
            Arrays.sort(box);
            // 上一个盒子可以装下的下标
            int preIndex = 0;

            // 2. 遍历供应商每个箱子，尽可能让箱子装较大的包裹，减少浪费的空间
            for (int v : box) {
                int index = bSearch(packages, v);

                if (index != -1) {
                    cur += (index - preIndex + 1) * (long)v - (preSum[index + 1] - preSum[preIndex]);
                    preIndex = index + 1;
                }
            }

            if (preIndex == n) {
                ans = Math.min(ans, cur);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : (int) (ans % (int) (1e9+7));
        
    }

    // 在nums中找到最后一个小于等于v的元素，返回其索引，如果没有找到，返回-1
    public int bSearch(int[] a, int value) {
        int low = 0;
        int high = a.length-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == high || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,5]\n[[4,8],[2,8]]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n[[1,4],[2,3],[3,4]]\n
// @lcpr case=end

// @lcpr case=start
// [3,5,8,10,11,12]\n[[12],[11,9],[10,5,14]]\n
// @lcpr case=end

 */

