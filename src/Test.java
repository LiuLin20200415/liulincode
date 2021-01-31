public class Test {
    public static void main(String[] args) {
        BiranTree biranTree=new BiranTree();
        BTNode root=biranTree.createTree();
        biranTree.size(root);
        System.out.println(BiranTree.size);
        System.out.println(biranTree.size1(root));
        biranTree.leafSize(root);
        System.out.println(BiranTree.leaf);
        System.out.println(biranTree.leftSize1(root));
        System.out.println(biranTree.nodeKSize(root, 3));
        System.out.println(biranTree.heightSize(root));
        BTNode a=biranTree.find(root,'A');
        System.out.println(a.val);
    }
}
