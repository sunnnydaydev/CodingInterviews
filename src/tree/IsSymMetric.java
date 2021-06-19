package tree;



/**
 * Created by zb on 2021/6/11 10:29
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsSymMetric {

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
     * 一、图解
     *    1 root
     *    / \
     * L  2   2    R
     *  / \ / \
     * 3  4 4  3
     * <p>
     * 3:L.left.val
     * 3:R.right.val
     * <p>
     * 二、 对称二叉树满足条件：
     * 1、L.val = R.val
     * 2、L.left.val = R.right.val
     * 3、L.right.val = R.left.val
     * <p>
     * 三、递归遍历：isSymMetric(L,R) 依次递归遍历到底部叶子节点。
     * <p>
     * 四、递归终止条件
     * 1、L与R都同时递归到底部，再往下L==R==null，二叉树为对称。 返回true
     * 2、L或者R有越过叶子节点，树不对称。
     * 3、L 节点值 !=R 节点值 不对称。
     */

    static boolean isSymMetric(TreeNode root) {
        return root == null || isSymMetric(root.left, root.right);
    }

    static boolean isSymMetric(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true; //满二叉树（1、只存在一个父节点2、存在多个节点时遍历完毕）
        if (L == null || R == null || L.val != R.val) return false; //不对称，直接false
        return isSymMetric(L.left, R.right) && isSymMetric(L.right, R.left); // 递归遍历
    }
}
