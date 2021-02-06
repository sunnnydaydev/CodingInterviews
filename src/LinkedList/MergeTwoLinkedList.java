package LinkedList;

/**
 * Create by SunnyDay on 2021/02/06 11:41
 * 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 递归解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //l1,l2 都为空
        //l1，l2 有一个为空
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // l1,l2 都不为空
        ListNode mergeHead = null;
        if (l1.val <= l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);// 参数位置无所谓
        }
        return mergeHead;
    }


    // 非递归解法
    public ListNode merge(ListNode l1, ListNode l2) {

        // l1,l2 都不为空
        ListNode dummyHead = new ListNode(0); // 虚拟 头结点
        ListNode curHead = dummyHead; // 当前头结点

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curHead.next = l1;
                l1 = l1.next;
            } else {
                curHead.next = l2;
                l2 = l2.next;
            }
            curHead = curHead.next;
        }

        //l1,l2 都为空
        //l1，l2 有一个为空
        curHead.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }
}
