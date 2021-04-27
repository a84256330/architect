package review;

public class 判断给定的链表中是否有环 {
    public boolean hasCycle(ListNode head) {
        ListNode fast =head;
        ListNode slow =head;
        while (fast!=null && fast.next != null){
            fast=fast.next.next;
            slow = slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}
