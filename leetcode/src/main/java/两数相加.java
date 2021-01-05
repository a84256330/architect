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

        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int ca = 0;
        ListNode v1 = l1;
        ListNode v2 = l2;
        ListNode pre = null;
        ListNode node =null;

        while (v1!=null || v2!=null){
            n1 = v1!=null?v1.val:0;
            n2 = v2!=null?v2.val:0;

            n = n1 + n2 + ca;

            pre = node;
            node = new ListNode(n%10);
            node.next = pre;

            ca = n/10;

            v1 = v1!=null?v1.next:null;
            v2 = v2!=null?v2.next:null;
        }

        if (ca==1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return reverseList(node);
    }

    /**
     * 7 -> 0 -> 8 ==> 8 -> 0 -> 7
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;// next = 0 , head.next = 0
            head.next = pre;// pre = null , head.next = null
            pre = head;// pre = 7 , head.next = null
            head = next;// head = 0 , head.next = 0
        }
        return pre;
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

    public static void main(String[] args) {

         StringBuilder sb = new StringBuilder();
        System.out.println(sb.length());
    }
}