package review;

public class 删除链表的倒数第n个节点 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head==null || n<1){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
         slow.next= slow.next.next;
        return head;
    }
}
