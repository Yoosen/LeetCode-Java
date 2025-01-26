/*
 * @lc app=leetcode.cn id=85 lang=java
 * @lcpr version=20004
 *
 * [85] 最大矩形
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int res = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            res = Math.max(largestRectangleArea(heights), res);
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length + 2;
        int[] newHeights = new int[len];
        newHeights[0] = newHeights[len - 1] = 0;

        for (int i = 1; i < len - 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        Deque<Integer> st = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && newHeights[i] < newHeights[st.peek()]) {
                int cur = st.pop();
                int left = st.peek();
                int right = i;

                res = Math.max(res, (right - left - 1) * newHeights[cur]);
            }
            st.push(i);
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["1"]]\n
// @lcpr case=end

 */

