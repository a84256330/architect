package review;

import java.util.ArrayList;
import java.util.List;

public class 单链表排序 {
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head==null || head.next==null){
            return head;
        }

        ListNode tep = head;
        List<Integer> list = new ArrayList<>(16);
        while(tep!=null){
            list.add(tep.val);
            tep = tep.next;
        }
        list.sort((a,b)-> a-b);
        ListNode temp = head;
        int i = 0;
        while(tep!=null){
            temp.val = list.get(i++);
            temp = temp.next;
        }
        return head;
    }
}
