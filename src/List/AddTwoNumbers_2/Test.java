package List.AddTwoNumbers_2;

import utils.List;
import utils.ListNode;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] value1 = new int[]{2, 4, 3};
        int[] value2 = new int[]{5,6,4};
        List l1 = new List(value1);
        List l2 = new List(value2);
        ListNode listNode = solution.addTwoNumbers(l1.head, l2.head);
        ArrayList show = listNode.Show();
        System.out.println(show);
    }
}
