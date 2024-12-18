/*
 * @lc app=leetcode.cn id=870 lang=java
 * @lcpr version=20004
 *
 * [870] 优势洗牌
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

// 田忌赛马题
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int len = nums1.length;
        int ans[] = new int[len];
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }

        // 神奇操作，不能直接排序nums2，可以根据nums2排序一个索引数组，然后通过索引数组
        Arrays.sort(index, (a, b) -> nums2[a] - nums2[b]);

        int left = 0;
        int right = len - 1;

        // 遍历田忌的马
        for(int num : nums1) {
            // 打得过齐王的马就打，打不过用最差（当前）的马去比赛齐王最好的马
            int i = num > nums2[index[left]] ? index[left++] : index[right--];
            ans[i] = num;
        }

        return ans;
    }

}
// @lc code=end



/*
// @lcpr case=start
// [2,7,11,15]\n[1,10,4,11]\n
// @lcpr case=end

// @lcpr case=start
// [12,24,8,32]\n[13,25,32,11]\n
// @lcpr case=end

 */

