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
        ListNode node1=l1;
        ListNode node2=l2;
        ListNode head=null;
        ArrayDeque<Integer> stack1=new ArrayDeque<>();
        ArrayDeque<Integer> stack2=new ArrayDeque<>();
        int carry=0;
        int ones=0;
        while(node1!=null){
            stack1.push(node1.val);
            node1=node1.next;
        }
        while(node2!=null){
            stack2.push(node2.val);
            node2=node2.next;
        }
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            carry=sum/10;
            ones=sum%10;
            ListNode node=new ListNode(ones);
            node.next=head;
            head=node;
        }
        return head;


    }
}