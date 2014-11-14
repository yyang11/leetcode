package undone;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  //marvelous
  private class Node {
    int key,value;
    Node prev,next;
    public Node() {}
    public Node(int key,int value) {
      this.key=key;
      this.value=value;
    }
  }
  private class DLList {
    Node head,tail;
    int size=0;
    public DLList() {
      head=new Node();
      tail=new Node();
      head.prev=null;
      head.next=tail;
      tail.prev=head;
      tail.next=null;
    }
    void addFirst(Node n) {
      head.next.prev=n;
      n.next=head.next;
      n.prev=head;
      head.next=n;
      size++;
    }
    void remove(Node n) {
      if(n!=head&&n!=tail) {
        n.prev.next=n.next;
        n.next.prev=n.prev;
        size--;
      }
    }
    Node removeLast() {
      Node n=tail.prev;
      remove(n);
      return n;
    }
  }
  int capacity;
  DLList list=new DLList();
  Map<Integer,Node> map=new HashMap<Integer,Node>();
  public LRUCache(int capacity) {
    this.capacity=capacity;
  }

  public int get(int key) {
    if(!map.containsKey(key))
      return -1;
    list.remove(map.get(key));
    list.addFirst(map.get(key));
    return map.get(key).value;
  }

  public void set(int key, int value) {
    if(map.containsKey(key)) {
      list.remove(map.get(key));
      list.addFirst(map.get(key));
      map.get(key).value=value;
    }
    else {
      Node n=new Node(key,value);
      list.addFirst(n);
      if(list.size>capacity) {
        map.remove(list.removeLast().key);
      }
      map.put(key, n);
    }
  }

  //set(2,1),get(2),set(3,2),get(2),get(3)
  public static void main(String args[]) {
    LRUCache cache=new LRUCache(1);
    cache.set(2,1);
    System.out.println(cache.get(2));
    cache.set(3,2);
    System.out.println(cache.get(2));
  }
}
