public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null)  return null;
        do {
            if(fast == null) {
                return null;   
            } 
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
            if(slow != null) {
                slow = slow.next;
            } else {
                return null;
            }
        } while(fast != slow);
        ListNode ptr1 = head;
        ListNode ptr2 = fast;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}