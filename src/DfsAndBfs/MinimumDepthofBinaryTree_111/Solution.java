package DfsAndBfs.MinimumDepthofBinaryTree_111;

import utils.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Solution {
    //这个题还是比较简单的，直接用深度优先搜索遍历所有的路径，然后记录下来最小值就行了
    //这里讲一个深度优先搜索的一个思路吧，可以把大问题分解为小问题，想一想如果是叶子结点怎么搞
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left!=null){
            minDepth = Math.min(minDepth,minDepth(root.left));
        }
        if(root.right!=null){
            minDepth = Math.min(minDepth,minDepth(root.right));
        }
        return minDepth+1;
    }
}
