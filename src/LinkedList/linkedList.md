###### 1、从尾到头打印链表
>[题目](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
>
>[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/LinkedList/ReversePrint.java)

```java
    public int[] reversePrint(ListNode head) {
        int[] arr;
        int size = 0;

        ListNode node = head;
        while (null != node) {
            size++;
            node = node.next;
        }

        arr = new int[size];//此时数组元素默认都是0
        int index = size - 1;
        while (null != head) {
            arr[index--] = head.val; // 动态修改数组元素值
            head = head.next;
            //index--; // 优化
        }
        return arr;
    }

```

###### 2、链表中倒数第k个节点
   >[题目](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
   >
   >[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/LinkedList/KthNodeInLinkedList.java)

   ```java
        /**
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

```

###### 3、反转链表
>[题目](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)
>
>[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/LinkedList/ReverseLinkedList.java)

```java
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

```


###### 4、合并两个排序的链表
>[题目](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)
>
>[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/LinkedList/ReverseLinkedList.java)

```java
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

```