package utils;

import java.sql.Array;
import java.util.ArrayList;

public class List {
    public ListNode head;
    public int[] values;

    public List(int[] values) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        for (int value : values) {
            ptr.next = new ListNode();
            ptr = ptr.next;
            ptr.val = value;
        }
        this.head = head.next;
    }

    public ArrayList Show(){
        ListNode ptr = this.head;
        ArrayList res = new ArrayList();
        while (ptr != null){
            res.add(ptr.val);
            ptr = ptr.next;
        }
        return res;
    }
}
