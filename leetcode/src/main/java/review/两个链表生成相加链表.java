package review;

public class 两个链表生成相加链表 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (head1!=null || head2!=null){
            int num1 = head1==null?0:head1.val;
            int num2 = head2==null?0:head2.val;

            int num = num1 + num2 + carry;
            carry = num/10;

            cur.next = new ListNode(num%10);

            head1 = head1==null?null:head1.next;
            head2 = head2==null?null:head2.next;
            cur = cur.next;
        }
        if (carry==1) {
            cur.next=new ListNode(carry);
        }
        return ans.next;
    }
}
