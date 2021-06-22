package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb on 2021/6/22 14:50
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class KthLargest {

    private static List<TreeNode> list = new ArrayList<>();

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

    /**
     * 一、规律：二分搜索树每个节点作为根节点时总有如下规律
     * 1、根节点大于左子树
     * 2、根节点小于右子树
     * 3、二分搜索树的中序遍历规律：所有元素会按照从小到大排列
     * <p>
     * 二、题解
     * 1、根据规律直接从根节点开始遍历所有的元素树即可。得到的元素自小到大有序。
     * 2、把这些元素一次放入集合。
     * 3、根据索引直接取即可。
     */

    public static int kthLargest(TreeNode root, int k) {
        //1 ≤ k ≤ 二叉搜索树元素个数.这个题目已经限定。不同再额外判断。

        dfs(root); //中序遍历元素存入集合

        if (k > list.size()) return 0; //k 与 集合元素做比较。大于时也不满足情况。

        // 1、第一大的是倒数第一个。则第k大的是倒数第k个。
        // 2、总数nodeList.size，去掉K个则剩 nodeList.size-k个元素。倒数第K个则为第nodeList.size-k+1 个元素。
        // 3、这里只需寻找第nodeList.size-k+1 个元素即可。由于数组索引从零开始。这里减去1即可。（我们从1开始算的）

        return list.get(list.size() - k).val;
    }


    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left); // 左
        list.add(root);
        dfs(root.right);// 右
    }

    /**
     * 引申：其实还有个规律，中序遍历的 左右子树变换先后访问顺序就可到的从大到小的排列
     *
     * */
}
