public class Tree {
    /*class Solution {
    public int preIndex=0;
     public TreeNode buildTreeChild(int[] preorder, int[] inorder,int inbegin,int inend) {
         if(inbegin>inend){
             return null;
         }
         TreeNode root=new TreeNode(preorder[preIndex]);
         //找到中序遍历数组对应的下标，来确定左右树
         int index=find(inorder,preorder[preIndex],inbegin,inend);
         preIndex++;
         root.left=buildTreeChild(preorder,inorder,inbegin,index-1);
         root.right=buildTreeChild(preorder,inorder,index+1,inend);
         return root;
    }
    public int find(int[] inorder,int key,int inbegin,int inend){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i]==key){
                return i;
            }
        }
         return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null){
            return null;
        }
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
}*/
    /*class Solution {
    public int preIndex=0;
    public TreeNode buildTreeChild(int[] postorder,int[] inorder,int inbegin,int inend){
        if(inbegin>inend){
            return null;
        }
        TreeNode root=new TreeNode(postorder[preIndex]);
        int index=findValInorder(inorder,postorder[preIndex],inbegin,inend);
        preIndex--;
        root.right=buildTreeChild(postorder,inorder,index+1,inend);
        root.left=buildTreeChild(postorder,inorder,inbegin,index-1);
        return root;

    }
    public int findValInorder(int[] inorder,int key,int inbegin,int inend) {
        for(int i = inbegin;i <= inend; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null) return null;
        if(postorder.length == 0|| inorder.length == 0) return null;
        preIndex = postorder.length-1;
        return buildTreeChild(postorder,inorder,0,inorder.length-1);
    }

}*/

}
