package Recursive.BinaryTreeMaximumPathSum_124;

import utils.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution {
    //得到叶节点的最大贡献值之后，再计算非叶节点的最大贡献值。
    //
    //上述计算过程是递归的过程，因此，对根节点调用函数 maxGain，即可得到每个节点的最大贡献值。
    //
    //根据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？
    // 对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，如果子节点的最大贡献值为正，
    // 则计入该节点的最大路径和，否则不计入该节点的最大路径和。维护一个全局变量 maxSum 存储最大路径和，
    // 在递归过程中更新 maxSum 的值，最后得到的 maxSum 的值即为二叉树中的最大路径和。
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    public int maxGain(TreeNode root){
        //节点为空则贡献值为空
        if (root==null){
            return 0;
        }
        //递归计算左右两个子节点的最大贡献值
        //但是只能用得上大于0的值
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);
        //该点的最大路径和取决于这个点和左右子节点的贡献值
        int curMaxPath = root.val+leftGain+rightGain;
        //更新全局的最大路径
        max = Math.max(max,curMaxPath);

        return root.val+Math.max(leftGain,rightGain);
    }
}
