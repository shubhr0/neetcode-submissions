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
    public int pairSum(ListNode head) {
        ListNode last=head;
        List<Integer> list=new ArrayList<>();
        while(last!=null){
            list.add(last.val);
            last=last.next;
        }
        int size=list.size();
        int count=0;
        for(int i=0;i<size;i++){
            int value=list.get(i)+list.get(size-1);
            if(value > count){
                count=value;
            }
            size--;
        }

        return count;
        
    }
}