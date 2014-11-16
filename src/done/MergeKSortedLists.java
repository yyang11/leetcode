/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==0)
            return null;
        while(lists.size()!=1) {
            int len=lists.size();
            for(int i=0;i<len-1;i+=2){
                ListNode n=mergeTwoLists(lists.get(0),lists.get(1));
                lists.remove(0);
                lists.remove(1);
                lists.add(n);
            }
        }
        return lists.get(0);
    }
    public ListNode mergeTwoLists(ListNode a,ListNode b){
        ListNode head=new ListNode(0),n=head;
        while(a!=null&&b!=null){
            ListNode min=a.val<b.val?a:b;
            if(a.val<b.val)
                a=a.next;
            else
                b=b.next;
            n.next=min;
            n=n.next;
        }
        if(a!=null){
            n.next=a;
        }
        else if(b!=null){
            n.next=b;
        }
        return head.next;
    }
}
