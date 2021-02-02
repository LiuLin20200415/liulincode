class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class zuoye {
    public Node head;
    public void create() {
        Node node=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node3;
        this.head=node;
    }
        public Node theListNode(){
        if(head==null){
            return null;
        }
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
            if(fast==null||fast.next==null) {
                return null;
            }
            slow=this.head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
    }
    public void display() {
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
