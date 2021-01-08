class Node{
    public int val;
    public Node next;
    public Node(){
    }
    public Node(int val){
        this.val=val;
    }
}
public class Test{
    public Node head;//表示当前节点的头 默认为null
    //创建链表
    public void createLinked(){
        this.head=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(1);
        Node node4=new Node(4);
        //是单个节点头尾相连
        this.head.next=node2;
        node2.next=node3;
        node3.next=node4;
    }
    //打印链表
    public void display(){
        Node var=this.head;//使var指向头结点
        //当var走向链表的尾结点时循化停止
        while(var!=null){
            System.out.print(var.val+" ");
            var=var.next;
        }
        System.out.println();
    }
    //找到最后一个节点
    public void findLastNode(){
        Node var=this.head;
        if(this.head==null){
            System.out.println("没有节点");
        }
        while(var.next!=null){
            var=var.next;
        }
        System.out.println("最后一个节点是"+var.val);
    }
    //找到倒数第二个节点
    public void findSecondLastNode(){
        Node var=this.head;
        if(this.head==null){
            System.out.println("没有节点");
        }else if(var.next==null){
            System.out.println("只有一个节点");
        }
        while(var.next.next!=null){
            var=var.next;
        }
        System.out.println("倒数第二个节点是"+var.val);
    }
    //获取单链表的长度
    public int size(){
        Node var=this.head;
        int count=0;
        while(var!=null){
            var=var.next;
            count++;
        }
        return count;
    }
    //找到第N个节点
    public void findN(int num){
        Node var=this.head;
        if(num<=0||num>size()){
            System.out.println("找不到此节点");
        }
        int count=1;
        while(count!=num){
            count++;
            var=var.next;
        }
        System.out.println("这个节点是"+var.val);
    }
    //查找单链表是否包含关键字key
    public void contain(int key){
        Node var=this.head;
        while(var!=null){
            if(var.val==key){
                System.out.println("包含");
                return;
            }
            var=var.next;
        }
        System.out.println("不包含");
    }
    //头插法
    public void addFirstNode(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
        }
        node.next=this.head;
        this.head=node;
    }
    //尾插法
    public void addListNode(int data){
        Node node=new Node(data);
        Node var=this.head;
        if(this.head==null){
            this.head=node;
        }
        while(var.next!=null){
            var=var.next;
        }
        var.next=node;
    }
    //在任意地方插入，第一个数据节点是0号下标
    public void addIndex(int index,int data){
        Node node=new Node(data);
        if(index<0||index>size()){
            System.out.println("插不了");
            return;
        }
        if(index==0){
            addFirstNode(data);
            return;
        }
        if(index==size()){
            addListNode(data);
            return;
        }
            Node var=this.head;
            int count=0;
            while(count!=index-1){
                var=var.next;
                count++;
            }
            node.next=var.next;
            var.next=node;

    }
    //删除所有出现key的节点
    public void delIndex(int key){
        if(this.head==null){
            return;
        }
        Node cur=this.head.next;
        Node prev=this.head;
        while(cur!=null){
            if(cur.val==key){
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
        }
        if(this.head.val==key){
            this.head=this.head.next;
        }
    }
    public void fanZh(){
        if(this.head==null){
            return;
        }
        //prev:代表当前需要反转的节点的前驱
        //curNext:代表需要反转的下一个节点
        Node cur=this.head;
        Node prev=null;
        Node newHead=null;
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
}
    public void clean(){
        this.head=null;
    }
}

public class TestDome{
    public static void main(String[] args) {
        Test myLinkedList=new Test();
        myLinkedList.createLinked();
        myLinkedList.display();
        myLinkedList.findLastNode();
        myLinkedList.findSecondLastNode();
        myLinkedList.findN(3);
        myLinkedList.contain(9);
        myLinkedList.addFirstNode(6);
        myLinkedList.display();
        myLinkedList.addListNode(7);
        myLinkedList.display();
        myLinkedList.addIndex(1,8);
        myLinkedList.display();
        myLinkedList.addIndex(0,1);
        myLinkedList.display();
        myLinkedList.delIndex(1);
        myLinkedList.display();
        myLinkedList.clean();
        myLinkedList.display();
    }
}

