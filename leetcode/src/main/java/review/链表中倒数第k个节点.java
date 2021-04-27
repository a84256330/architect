package review;

public class 链表中倒数第k个节点 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if(pHead==null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast!=null && k-- >0){
            fast = fast.next;
        }
        if(k>0){
            return null;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        // write code here
    }
}
