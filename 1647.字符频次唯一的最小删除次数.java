/*
 * @lc app=leetcode.cn id=1647 lang=java
 * @lcpr version=20004
 *
 * [1647] 字符频次唯一的最小删除次数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int res = 0;
        Set<Integer> set = new HashSet<>();

        // 4 4 3 2 1
        for (int i : cnt) {
            if (i != 0) {
                while (set.contains(i)) {
                    i--;
                    res++;
                }
            }
            if (i != 0) {
                set.add(i);
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "aab"\n
// @lcpr case=end

// @lcpr case=start
// "aaabbbcc"\n
// @lcpr case=end

// @lcpr case=start
// "ceabaacb"\n
// @lcpr case=end

 */

