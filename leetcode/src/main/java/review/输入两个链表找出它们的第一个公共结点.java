package review;

public class 输入两个链表找出它们的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null){
            return null;
        }
        ListNode p = pHead1;
        ListNode p2 = pHead2;
        while(p!=p2){
            p = p == null?pHead1:p.next;
            p2 = p2 == null?pHead2:p2.next;
        }
        return p;
    }
}
