package review;

public class 链表入口节点 {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode slow2= head;
                while(slow!=slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }


        }
        return null;
    }
}
