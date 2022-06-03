package utils;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ArrayList Show(){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(this.val);
        ListNode ptr = new ListNode();
        ptr.next = this.next;
        while (ptr.next!=null){
            ptr = ptr.next;
            res.add(ptr.val);
        }
        return res;
    }
}
