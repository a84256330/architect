package review;

import java.util.List;

public class 合并有序链表 {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode pre = new ListNode(0);
        ListNode head = pre;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = (l1==null)?l2:l1;
        return pre.next;
    }
}
