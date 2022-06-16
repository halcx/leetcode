package DfsAndBfs.PopulatingNextRightPointersinEachNode_116;

import utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class Solution {
    //这个题是一个非常经典的广度优先搜索问题，只需要层次遍历就可以了
    public Node connect(Node root) {
        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            //记录下来该层的节点数
            int size = queue.size();
            //遍历这一层所有的节点
            for (int i = 0; i < size; i++) {
                //队首部取出来
                Node poll = queue.poll();
                //连接到下一个，下一个就是此时的队首，但是要注意最后一个连接null
                if(i<size-1){
                    poll.next = queue.peek();
                }
                //扩展下一层的节点
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return head;
    }
}
