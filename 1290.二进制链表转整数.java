/*
 * @lc app=leetcode.cn id=1290 lang=java
 * @lcpr version=30201
 *
 * [1290] 二进制链表转整数
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]\n
// @lcpr case=end

// @lcpr case=start
// [0,0]\n
// @lcpr case=end

 */

