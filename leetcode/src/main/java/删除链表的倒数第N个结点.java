/**
 * @Author: mc
 * @DateTime: 2021/1/25 9:04
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class 删除链表的倒数第N个结点 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;

        ListNode pre = null;

        Boolean enough = false;

        while (cur!=null){
            n--;
            if (n<=0) {
                if (n==0) {
                    enough=true;
                }else if (n==-1){
                    pre = head;
                }else{
                    pre = pre.next;
                }
            }
            cur = cur.next;
        }

        if(!enough){
            return head;
        }

        if(pre==null){
            return head.next;
        }

        pre.next = pre.next.next;

        return head;

    }
}
