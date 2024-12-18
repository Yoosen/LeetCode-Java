/*
 * @lc app=leetcode.cn id=784 lang=java
 * @lcpr version=20003
 *
 * [784] 字母大小写全排列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        char[] arr = s.toCharArray();
        backtrack(arr, 0);

        return res;
    }

    void backtrack(char[] arr, int index) {
        if (index == arr.length) {
            res.add(new String(arr));
            return ;
        }

        backtrack(arr, index + 1);
        if(Character.isLetter(arr[index])) {

            arr[index] ^= 1 << 5;
            backtrack(arr, index + 1);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "a1b2"\n
// @lcpr case=end

// @lcpr case=start
// "3z4"\n
// @lcpr case=end

 */

