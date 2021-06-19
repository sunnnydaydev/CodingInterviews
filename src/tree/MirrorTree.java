package tree;

/**
 * Created by zb on 2021/6/11 13:27
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MirrorTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 1、二叉树镜像：只需要把二叉树的每个左右节点都交换即可获取镜像。
     * <p>
     * <p>
     * <p>
     * <p>
     * * 例如输入：
     * *
     * *      4
     * *    /   \
     * *   2     7
     * *  / \   / \
     * * 1   3 6   9
     * * 镜像输出：
     * *
     * *      4
     * *    /   \
     * *   7     2
     * *  / \   / \
     * * 9   6 3   1
     * <p>
     * 2、 遍历过程中 使用变量临时存 左或者右节点。这里取左 TreeNode temp =  root.left
     *
     * （1）递归遍历右节点，返回值作为左节点。
     * （2）递归遍历temp节点返回值作为右节点。
     */
    public  TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left; // 记录左节点的临时值，
        root.left = mirrorTree(root.right); // 遍历右节点，遍历结果赋值给左节点。
        root.right = mirrorTree(temp); // 遍历左节点，遍历结果赋值给右节点。
        return root;
    }
}
