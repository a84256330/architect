/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @Classname 反转链表
 * @Description TODO
 * @Date 2020/4/25 19:58
 * @Created by Ma
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {

        ListNode a = head;
        ListNode b = null;

        while(a!=null){
            ListNode temp = a.next;
            a.next = b;
            b = a;
            a = temp;
        }
        return b;
    }
}
