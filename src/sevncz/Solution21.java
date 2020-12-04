package sevncz;

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode dummy = header;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }else{
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
        }
        if(l1 != null) {
            dummy.next = l1;
        }
        if(l2 != null) {
            dummy.next = l2;
        }
        return header.next;
    }
}