/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer{
    /* better sln from from PaladinHL that only costs O(1) space
    RandomListNode *copyRandomList(RandomListNode *head) {
    if(head == NULL) return NULL;
    RandomListNode *p = head;
    do {
        RandomListNode *q = p->next;
        p->next = new RandomListNode(p->label);
        p->next->next = q;
        p = q;
    } while(p != NULL);
    p = head;
    do {
        p->next->random = (p->random == NULL) ? NULL : p->random->next;
        p = p->next->next;
    } while(p != NULL);
    p = head;
    RandomListNode *r = head->next;
    for(RandomListNode *q = r;;) {
        p->next = q->next;
        p = p->next;
        if(p == NULL) break;
        q->next = p->next;
        q = q->next;
    }
    return r;
    }
     */
     
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode nhead=null;
        RandomListNode last=null,np=null,p=head;
        while(p!=null) {
            np=new RandomListNode(p.label);
            if(last!=null)
                last.next=np;
            if(nhead==null)
                nhead=np;
            map.put(p,np);
            p=p.next;
            last=np;
        }
        p=head;
        np=nhead;
        while(p!=null) {
            np.random=map.get(p.random);
            p=p.next;
            np=np.next;
        }
        return nhead;
    }
}
