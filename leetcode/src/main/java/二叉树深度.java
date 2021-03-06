
/**
 * 难度简单11收藏分享切换为英文关注反馈输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 * @Classname 二叉树深度
 * @Description TODO
 * @Date 2020/3/31 10:33
 * @Created by Ma
 */
public class 二叉树深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
        return 0;
    }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

}
}
class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
