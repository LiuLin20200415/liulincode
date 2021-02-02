import java.util.*;

class BTNode {
    public char val;
    public BTNode left;//左子树的引用
    public BTNode right;//右子树的引用

    public BTNode(char val) {
        this.val = val;
    }
}
public class BiranTree {
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }


    // 前序遍历
    void preOrderTraversal(BTNode root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
      void inOrderTraversal(BTNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
     }
    //后序遍历
        void postOrderTraversal(BTNode root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
     }
     static  int size=0;
     void size(BTNode root){
        if(root==null){
            return;
        }
        size++;
        size(root.left);
        size(root.right);
     }
     int size1(BTNode root){
         if(root==null){
             return 0;
         }
         return size1(root.left)+size1(root.right)+1;
         }
         static int leaf=0;
     void leafSize(BTNode root){
         if(root==null){
             return;
         }
         if(root.left==null&&root.right==null){
             leaf++;
         }

         leafSize(root.left);
         leafSize(root.right);
     }
     int leftSize1(BTNode root){
         if(root==null){
             return 0;
         }
         if(root.left==null&&root.right==null){
             return 1;
         }
         return leftSize1(root.left)+leftSize1(root.right);
     }
     int nodeKSize(BTNode root,int k){
         if(root==null){
             return 0;
         }
         if(k==1){
             return 1;
         }
         return nodeKSize(root.left,k-1)+nodeKSize(root.right,k-1);
     }
     int heightSize(BTNode root){
         if(root==null){
             return 0;
         }
         if(root.left==null&&root.right==null){
             return 1;
         }
         return Math.max(heightSize(root.left),heightSize(root.right))+1;
     }
    BTNode find(BTNode root, char val){
         if(root==null){
             return null;
         }
         if(val==root.val){
             return root;
         }
         find(root.left,val);
         find(root.right,val);
         return null;
    }
    void levelOrderTraversal(BTNode root){
         if(root==null){
             return;
         }
        Queue<BTNode> queue =new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             BTNode cur=queue.poll();
             System.out.print(cur.val+" ");
             if(cur.left!=null){
                 queue.add(cur.left);
             }
             if(cur.right!=null){
                 queue.add(cur.right);
             }
         }
    }
    boolean isCompleteTree(BTNode root){
        if(root==null){
            return true;
        }
        Queue<BTNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BTNode cur=queue.poll();
            if(cur!=null){
                queue.add(cur.left);
                queue.add(cur.right);
            }else{
                break;
            }
        }
        //看队列里还有节点没
        while(!queue.isEmpty()){
            BTNode cur=queue.peek();
            if(cur!=null){
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }
    //前中后序的非递归实现
    void preOrderTraversal2(BTNode root){
        if(root==null) {
            return;
        }
        Stack<BTNode> stack=new Stack<>();
        BTNode cur=root;
        while(cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                System.out.print(cur.val+" ");
                cur = cur.left;
            }
            //当cur=null时让cur指向top.right，每次让top=栈顶元素
            BTNode top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }
    void inOrderTraversal2(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while(cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
        System.out.println();
    }
    void postOrderTraversal2(BTNode root){
         if(root==null){
             return;
         }
         Stack<BTNode> stack=new Stack<>();
         BTNode cur=root;
         BTNode prev=null;
         while(cur!=null||!stack.isEmpty()){
             while(cur!=null){
                 stack.push(cur);
                 cur=cur.left;
             }
             BTNode top=stack.peek();
             if(top.right==null||top.right==prev){
                 stack.pop();
                 System.out.print(top.val+" ");
                 prev=top;
             }else{
                 cur=top.right;
             }
         }
        System.out.println();
    }

}

