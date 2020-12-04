package sevncz;

class Solution23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        if (lists.length==1) {
            return lists[0];
        }
        ListNode tmp = lists[0];
        int j = 1;
        while (j < lists.length) {
            tmp = mergeTwo(tmp, lists[j]);
            j++;
        }
        return tmp;
    }

    public ListNode mergeTwo(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode header = dummy;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                header.next = node1;
                node1 = node1.next;
                header = header.next;
            } else {
                header.next = node2;
                node2 = node2.next;
                header = header.next;
            }
        }
        if(node1 != null) {
            header.next = node1;
        }
        if(node2 != null) {
            header.next = node2;
        }
        return dummy.next;
    }
}