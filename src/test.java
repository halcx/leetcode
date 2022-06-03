import utils.List;
import utils.ListNode;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] values = new int[]{1,2,6,4,5};
        List l = new List(values);
        ArrayList show = l.Show();
        System.out.println(show);
    }
}
