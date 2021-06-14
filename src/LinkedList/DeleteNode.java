package LinkedList;

/**
 * Create by SunnyDay on 2021/06/14 10:04
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class DeleteNode {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * @param head 头结点
     * @param val  要删除节点
     *             <p>
     *             虚拟头结点写法。这种做法有个弊端只能删除首次出现的元素。不过题中已经明确元素不会重复.
     *             <p>
     *             如何删除多个重复的元素，这里有个想法：
     *             <p>
     *             1、直观的想法，不断查询，存在就删除。弊端大量查询，遍历。
     *             <p>
     *             2、标记清除法，遍历一遍，记录索引标记。然后标记的统一删除。
     */
    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummyHead  = new ListNode(0, head); //1、定义要删除节点的前一节点，默认为虚拟头结点。指向头结点。

        ListNode prev = dummyHead; // 谨记：头结点不能操作。创建副本。

        while (prev.next != null) { //2、查找要删除节点的前一节点。
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next; //3、返回头结点
    }

    /**
     * @param val  要删除的节点
     * @param head 头结点
     *
     *  不用虚拟头结点写法，需要判断头结点是否为空。否则下面while会空指针。
     */
    public ListNode deleteTargetElement(ListNode head, int val) {
        if (head == null) return null; // 1、头为空
        if (head.val == val){//2、刚好是头结点
            ListNode node = head;
            head = node.next;
            return head;
        }

        ListNode pre = head; //3、是头结点以后的元素
        while (pre.next != null) {
            if (pre.next.val == val) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            ListNode delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
        }

        return head;
    }

}