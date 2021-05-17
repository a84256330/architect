package review;

import java.util.Stack;

public class 回文字链表 {
    public boolean isPail (ListNode head) {
        // write code here
        if(head==null){
            return true;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            stack.add(temp);
            temp = temp.next;
        }

        temp = head;
        while(temp!=null){
            if(temp.val!=stack.pop().val){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
