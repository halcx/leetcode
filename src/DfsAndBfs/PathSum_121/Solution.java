package DfsAndBfs.PathSum_121;

import utils.TreeNode;

//给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
// 如果存在，返回 true ；否则，返回 false 。
//
//叶子节点 是指没有子节点的节点。

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    public static void main(String[] args) {

    }
}
