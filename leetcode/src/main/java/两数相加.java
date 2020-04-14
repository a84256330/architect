/**
 * 难度中等4148收藏分享切换为英文关注反馈给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Classname 两数相加
 * @Description TODO
 * @Date 2020/4/8 7:01
 * @Created by Ma
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 设置哑节点
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;

        while(l1 != null || l2 != null){
            int p = l1 != null ? l1.val : 0;
            int q = l2 != null ? l2.val : 0;

            int sum = p + q + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            if(carry==1) cur.next = new ListNode(carry);
        }
        return head.next;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}