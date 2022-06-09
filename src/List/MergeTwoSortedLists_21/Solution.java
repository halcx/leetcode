package List.MergeTwoSortedLists_21;

import utils.List;
import utils.ListNode;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class Solution {
    //递归：
    //如果l1<l2的话，则l1.next = merge(l1.next,l2)
    //如果l2<l1的话，则l2.next = merge(l2.next,l1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        else if(list2==null){
            return list1;
        }
        else if (list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list2.next,list1);
            return list2;
        }
    }

    public static void main(String[] args) {

    }
}
