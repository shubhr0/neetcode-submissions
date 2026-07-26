class MyLinkedList {

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    
    }
    ListNode head;

    public MyLinkedList() {
        head=null;
    }
    
    public int get(int index) {
        if(index<0){
            return -1;
        }
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            if(count==index){
                return curr.val;
            }
            count++;
            curr=curr.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode node=new ListNode(val);
        ListNode curr=head;
        node.next=curr;
        head=node;      
    }
    
    public void addAtTail(int val) {
        ListNode node=new ListNode(val);
        ListNode curr=head;
        if(head==null){
            head=node;
            return;
        }
        while(curr.next!=null){
            curr=curr.next;
        }
        node.next=null;
        curr.next=node;
    }
    
    public void addAtIndex(int index, int val) {

    if(index == 0){
        addAtHead(val);
        return;
    }

    ListNode curr = head;
    int count = 0;

    while(curr != null && count < index - 1){
        curr = curr.next;
        count++;
    }

    if(curr == null){
        return;
    }

    ListNode newNode = new ListNode(val);
    newNode.next = curr.next;
    curr.next = newNode;
}
    
    public void deleteAtIndex(int index) {

    if(head == null){
        return;
    }

    if(index == 0){
        head = head.next;
        return;
    }

    ListNode curr = head;
    int count = 0;

    while(curr != null && count < index - 1){
        curr = curr.next;
        count++;
    }

    if(curr == null || curr.next == null){
        return;
    }

    curr.next = curr.next.next;
}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */