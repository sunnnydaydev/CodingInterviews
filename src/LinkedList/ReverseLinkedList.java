package LinkedList;

/**
 * Create by SunnyDay on 2021/01/27 19:28
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 思考：链表反转有两种方法
     * <p>
     * 方法1：遍历链表，同时吧遍历的链表节点放入集合。二次遍历链表时把存入集合的节点倒叙替换给链表即可。
     * <p>
     * 方法2：遍历链表，同时修改指针方向，指针反转即可。遍历完毕吧之前的尾结点变更为头结点即可。
     * <p>
     * 对比：方法2一次遍历、也是对方法1空间复杂度的优化。
     *
     * 总结-收获：
     * 1、注意指针的使用这里使用了3个指针。即当前节点，前一节点，后一节点。
     * 2、当前、前一节点不断遍历即可。
     * 3、核心之处，不断修改当前节点指向。
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null; //无头结点直接return 空

        ListNode reverseHead = null;// 反转后的头结点
        ListNode currentNode = head;//当前节点
        ListNode preNode = null;//当前节点的前一节点

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;// 当前节点的下一节点
            if (nextNode == null) reverseHead = currentNode;

             //修改指针：当前节点的next 指向前方节点
            currentNode.next = preNode;

            // 修改指针：
            preNode = currentNode; // 当前节点的前一节点后移一位。（向下遍历）
            currentNode = nextNode;//  当前节点后移一位，向下遍历
        }
        return reverseHead;
    }
}
