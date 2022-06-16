package Tree.SumofLeftLeaves_404;

import utils.TreeNode;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        int ans = 0;
        if(root.left!=null){
            if(isLeafNode(root.left)){
                ans += root.left.val;
            }else {
                ans += dfs(root.left);
            }
        }
        if(root.right!=null && !isLeafNode(root.right)){
            ans += dfs(root.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode root){
        return root.right==null&&root.left==null;
    }
}
