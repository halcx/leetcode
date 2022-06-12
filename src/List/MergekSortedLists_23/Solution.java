package List.MergekSortedLists_23;

import utils.List;
import utils.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if (lists.length==1){
            return lists[0];
        }
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ans = mergeTwo(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwo(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }else if (l1.val<l2.val){
            l1.next = mergeTwo(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwo(l2.next,l1);
            return l2;
        }
    }


    //思路巨简单，难得一次都不用调试！！!循环直接搞定，什么分治大法我不懂！
    //
    //用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，，然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            //最小堆中最小的出队，并且加入链表
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            //如果出堆的节点的next不为空，把这个节点next入队即可
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        List list1 = new List(new int[]{1,4,5});
        List list2 = new List(new int[]{1,3,4});
        List list3 = new List(new int[]{2,6});
        ListNode listNode = new Solution().mergeKLists1(new ListNode[]{list1.head,list2.head,list3.head});
        ArrayList show = listNode.Show();
        System.out.println(show);
    }

}
