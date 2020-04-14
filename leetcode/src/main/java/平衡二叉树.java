/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 * @Classname 平衡二叉树
 * @Description TODO
 * @Date 2020/3/31 11:02
 * @Created by Ma
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {

        return recur(root) != -1;

    }
    private int recur(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(right - left) <= 1 ? Math.max(recur(root.left), recur(root.right)) + 1 : -1;
    }
}
