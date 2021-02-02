class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode cur=root;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null&&cur==null){
                return false;
            }
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
            }
            cur=node;
        }
        return true;
    }
}