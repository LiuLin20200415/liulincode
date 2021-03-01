class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
    }
}
class MyHashSet {
    public Node[] elem;
    int len=1000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.elem=new Node[len];
    }

    public void add(int key) {
        int index=key%len;
        if(elem[index]==null){
            elem[index]=new Node(key);
            return;
        }
        Node ret=elem[index];
        while(ret.next!=null){
            if(ret.val==key){
                return;
            }
            ret=ret.next;
        }
        if(ret.val==key){
            return;
        }
        ret.next=new Node(key);
    }

    public void remove(int key) {
        int index=key%len;
        Node ret=elem[index];
        Node pre=null;
        while(ret!=null){
            if(ret.val==key){
                if(pre==null){
                    elem[index]=elem[index].next;
                }else{
                    pre.next=ret.next;
                }
                return;
            }else{
                pre=ret;
                ret=ret.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=key%len;
        Node ret=elem[index];
        while(ret!=null){
            if(ret.val==key){
                return true;
            }
            ret=ret.next;
        }
        return false;
    }
}