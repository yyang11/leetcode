
public class RotateList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode tail, newTail;
        ListNode iterator = head;
        int len = 1;
        while(iterator.next != null) {
            len++;
            iterator = iterator.next;
        }
        tail = iterator;
        n = n % len;

        iterator = head;
        for(int i=0; i<len-n-1; i++)
            iterator = iterator.next;
        newTail = iterator;

        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;
        ListNode result = new RotateList().rotateRight(l1, 0);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
