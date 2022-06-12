package Tree.BinaryTreeZigzagLevelOrderTraversal_103;

import utils.TreeNode;

import java.util.*;

//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]

//广度优先搜索
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(flag) level.offerFirst(node.val);
                if(!flag)level.offerLast(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(new ArrayList<>(level));
            flag = !flag;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
