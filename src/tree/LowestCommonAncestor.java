package tree;

/**
 * Created by zb on 2021/6/29 20:49
 * <p>
 * <p>
 * 68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 */
class LowestCommonAncestor {
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
     * 一、祖先： 若节点 p 在节点 root 的左（右）子树中，或 p=root，则称 root 是 p 的祖先。
     * <p>
     * 二、最近公共祖先： 设节点 root 为节点 p,q 的某公共祖先，
     * 若其左子节点 root.lef和右子节点 root.right 都不是 p,q的公共祖先，则称root 是 “最近的公共祖先”
     * <p>
     * ps：这个定义决定了p，q 不能再root左右子树的同侧了。同侧谁在前谁就是公共祖先了，而不是root了。
     * <p>
     * 1、若root是pq的公共祖先，则只能满足下列条件：
     * <p>
     * pq为root的左右子树中（root的异侧）
     * <p>
     * 2、特殊情况：
     * <p>
     * p==root时，q可在root的两侧都行
     * <p>
     * q==root时，p可在root的两侧都行
     * <p>
     * 三、本题信息
     * <p>
     * 1、给定的为二分搜索树
     * 2、二分搜索树的元素不同
     * <p>
     * p q 与 root 关系如下：
     * <p>
     * 若root.val < p.val 则 p在root右子树中 （二分搜索树特点，root 大于左子树所有节点值）
     * <p>
     * 若root.val > p.val 则 p在root左子树中  （二分搜索树特点，root 小于右子树所有节点值）
     * <p>
     * 若root.val = p.val 则 p和root指向同一节点
     * <p>
     * 四、循环遍历解决
     * <p>
     * 当节点root为空，跳出循环。代表空树。树非空遍历寻找
     * <p>
     * 1、pq都在root的右侧时，root.right遍历寻找
     * 2、pq都在root的左侧时，root.left 遍历寻找
     * 3、 1,2 都不满足时直接break，找到目标元素（这里不理解时建议 跟着程序 p，q root模拟个值 自己推算一遍程序）
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) { // p q 在当前root节点右侧
                root = root.right; // 右侧遍历
            } else if (root.val > p.val && root.val > q.val) { // p q在当前节点的左侧
                root = root.left;
            } else {
                /**
                 * 在两侧时直接就是最近公共祖先（三种情况如下：

                         6

                 2               8

             0     4           7     9

                 3   5


                 case1： root = 6， p = 3， q = 5.    p、q 直接整体就在root 两侧

                 case2： 最近祖先root = 4， p = 3， q = 5.    p、q 直接在整体祖先root左侧，但是往下遍历后，最终p，q在最近祖先两侧。

                 case3： 最近祖先root = 4， p = 4， q = 3.    p或q 与最近祖先重合一个。符合同侧特例。直接同侧寻找即可。

                 */



                break;
            }

        }
        return root;
    }
}
