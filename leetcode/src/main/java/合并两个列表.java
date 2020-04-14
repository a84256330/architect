/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @Classname 合并两个列表
 * @Description TODO
 * @Date 2020/4/8 8:07
 * @Created by Ma
 */
public class 合并两个列表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode b = a.next;
        b.next = new ListNode(4);

        ListNode c = new ListNode(1);
        c.next = new ListNode(3);
        ListNode d = c.next;
        d.next = new ListNode(4);

        合并两个列表 he = new 合并两个列表();

        ListNode result = he.mergeTwoLists(a,c);

        System.out.println(result.toString());
    }
}
