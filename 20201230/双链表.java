class MyLinkedList {
    
    class MyListNode {
        
        int val;
        MyListNode prev;
        MyListNode next;
        
        MyListNode() {
            val = -1;
        }
        
        MyListNode(int x) {
            val = x;
        }
    }
    
    int size;
    MyListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new MyListNode();
        head.next = head;
        head.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size) {
            return -1;
        }
        MyListNode cur = head;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyListNode ins = new MyListNode(val);
        ins.next = head.next;
        ins.prev = head;
        head.next = ins;
        ins.next.prev = ins;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyListNode ins = new MyListNode(val);
        ins.next = head;
        ins.prev = head.prev;
        ins.prev.next = ins;
        head.prev = ins;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        MyListNode cur = head;
        MyListNode ins = new MyListNode(val);
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        ins.next = cur;
        ins.prev = cur.prev;
        cur.prev.next = ins;
        cur.prev = ins;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        MyListNode cur = head;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }
}