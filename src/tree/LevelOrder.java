package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zb on 2021/6/15 13:46
 * <p>
 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

  

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

  3
 / \
 9  20
 /  \
 15   7
 返回：

 [3,9,20,15,7]
  

 提示：

 节点总数 <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LevelOrder {

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
     * 本题考查广度优先遍历写法。
     *
     * 1、广度优先遍历非递归写法使用队列实现。
     *
     *    因为先访问的要先输出。符合队列思想。
     *
     * 2、如果考查深度优先遍历可以使用栈实现。
     *    因为先一条深度上，先访问的后输出。栈具有回溯功能。
     *
     *    ps:深度优先遍历也可使用递归实现。递归和栈具有相同的功能。
     *
     * */
    public static int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 1、首先从根节点开始，根节点入栈

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll(); // 2、节点出栈，同时记录出栈节点。
            list.add(cur.val);

            //2、一次判断左右节点是否为空，非空入栈。
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        int arr [] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
