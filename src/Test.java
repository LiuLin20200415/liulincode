import java.util.*;
class BTNode{
    public char val;
    public BTNode left;
    public BTNode right;
    public BTNode(char val){
        this.val=val;
    }
}
public class Test{
    public static int i=0;
    public static BTNode createTree(String str){
        if(str==null||str.length()==0){
            return null;
        }
        BTNode root=null;
        if(str.charAt(i)!='#'){
            root=new BTNode(str.charAt(i));
            i++;
            root.left=createTree(str);
            root.right=createTree(str);
        }else{
            i++;
        }
        return root;
    }
    public static void inorderTree(BTNode root){
        if(root==null){
            return;
        }
        inorderTree(root.left);
        System.out.print(root.val+" ");
        inorderTree(root.right);
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            BTNode root=createTree(str);
            inorderTree(root);
        }
    }
}