/*
 * @lc app=leetcode.cn id=853 lang=java
 * @lcpr version=20004
 *
 * [853] 车队
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];     // 每个位置到达终点的时间
        for(int i = 0; i < position.length; ++i) {
            time[position[i]] = (target - position[i]) / (double)speed[i];
        }

        Stack<Double> st = new Stack<>();
        for (int i = 0; i < target; i++) {
            if (time[i] > 0) {
                // 当前车的速度过慢，以当前车为准，前车速度快也只能和当前车一个队伍
                while (!st.isEmpty() && time[i] >= st.peek()) {
                    st.pop();
                }
                st.push(time[i]);
            }
        }

        return st.size();
    }
}
// @lc code=end



/*
// @lcpr case=start
// 12\n[10,8,0,5,3]\n[2,4,1,1,3]\n
// @lcpr case=end

// @lcpr case=start
// 10\n[3]\n[3]\n
// @lcpr case=end

// @lcpr case=start
// 100\n[0,2,4]\n[4,2,1]\n
// @lcpr case=end

 */

