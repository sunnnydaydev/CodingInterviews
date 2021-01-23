package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb on 2021/1/21 13:13
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthNodeInLinkedList {
    // node
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    // main test
    public static void main(String[] args) {

    }

    /**
     * K 从1 开始计数：k的取值范围问题。
     * <p>
     * 方法1：遍历一遍链表，记录每个节点的值到集合。 然后集合中取。时间复杂度O（n）
     * <p>
     * 支持条件：既然是倒数第k个节点，那么一定知道了总的节点数目才能计算倒数。应该只有上述一种方法。时间复杂度上。
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int nodeCount = 0;
        List<ListNode> mList = new ArrayList<>();
        while (head != null) {// 遍历链表所有元素，得到链表元素个数。同时遍历的元素加入集合。
            nodeCount++;
            mList.add(head);
            head = head.next;
        }

        if (k <= 0 || k > nodeCount) { // k 节点合法判断
            return null;
        }

        //0,1,2,3,,,,,count-1,count
        // 倒数第k和数
        return mList.get(nodeCount - k); // 集合中取倒数第k个元素（nodeCount -k + 1-1）
    }

    /**
     * 方法2：键值offer 给出的答案
     * 定义两个指针：
     * 第一个指针先遍历链表，从链表头开始到k-1 位置。
     * 第二个指针指向链表头部
     * <p>
     * 当第一个指针遍历到k位置时，第二个指针开始走，第一个指针走完，遍历完链表，第二个指针正好走到 n-k+1 位置。也即倒数第k个节点（n为节点总数）
     */
    public ListNode getKth(ListNode head, int k) {
        if (head == null || k == 0) { // 不存在情况
            return null;
        }

        ListNode pFast = head;//走的较快的指针
        ListNode pSlow = head;// 走的较慢的指针

        for (int i = 0; i < k - 1; i++) {
            if (pFast.next != null) {
                pFast = pFast.next;
            } else { // 后续无元素。链表节点总数 n < k  (k 指定的数字较大) 这里的else 容易忽略。
                return null;
            }
        }

        while (pFast.next != null) { // pFast 走到链表的结尾时，pSlow正好走到 n-k+1 处。正好为链表的倒数第k个节点。
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pSlow;
    }

     // 收获：注意两个方法中的遍历方式：
    // 方法1：head!=null 遍历
    // 方法2：pFast.next != null 遍历

}
