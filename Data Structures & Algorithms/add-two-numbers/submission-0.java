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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode temp3 = dummy;

        int carry = 0;

        while (temp1 != null || temp2 != null || carry != 0) {

            int value1 = 0;
            int value2 = 0;

            if (temp1 != null) {
                value1 = temp1.val;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                value2 = temp2.val;
                temp2 = temp2.next;
            }

            int sum = value1 + value2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            temp3.next = new ListNode(digit);
            temp3 = temp3.next;
        }

        return dummy.next;
    }
}