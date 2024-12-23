/*
 * @lc app=leetcode.cn id=2358 lang=java
 * @lcpr version=20004
 *
 * [2358] 分组的最大数量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/*
其实就是排序后，第1个人一组，2~3两个人一组，然后4~6三个人一组......k个人一组，直到这些组的 累加人数总和 为不超过 n 的最大值
第一组 1 个人，第二组 2 个人，第三组 3 个人...第 k 组 k 个人。
所有组的人数总和：1+2+3+4+..+k = (k*(k + 1))/2 不超过总人数 n
因此答案就是满足 (k*(k + 1))/2  ≤ n  的最大的 k，凑个完全平方式取正解即可。*/


class Solution {
    public int maximumGroups(int[] grades) {
        //学生总人数
        int n = grades.length;

        //排序都不需要了，只需要结果
        double ans = Math.sqrt(0.25 + 2 * n) - 0.5;

        //取下整返回
        return (int)Math.floor(ans);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,6,12,7,3,5]\n
// @lcpr case=end

// @lcpr case=start
// [8,8]\n
// @lcpr case=end

 */

