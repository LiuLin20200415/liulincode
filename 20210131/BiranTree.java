
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
}

