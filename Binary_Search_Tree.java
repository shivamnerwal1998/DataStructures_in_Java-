package DataStructures;


class TreeNode{
    private int data ;
    private TreeNode left ;
    private TreeNode right ;
    public TreeNode(){
    }
    public TreeNode(int info)
    {
        this.data = info ;
    }
    public void setData(int info) {
        this.data = info;

    }
    public void setLeftNode(TreeNode left)  { this.left = left ; }
    public void setRightNode( TreeNode right ){ this.right = right ;   }

    public TreeNode getLeftNode(){ return this.left ; }
    public TreeNode getRightNode(){ return this.right ; }
    public int getData() {  return this.data  ;  }

}
class BST{
    public TreeNode createEmpty(){
        return null ;
    }
    public TreeNode insertNode(TreeNode root , int info)
    {
        TreeNode node = new TreeNode(info) ;
        node.setLeftNode(null);
        node.setRightNode(null);
        if( root == null  ) return node ;

        TreeNode slow = null   ;
        TreeNode fast = root  ;
        while( fast != null  ){
            slow = fast ;
            if( fast.getData() < info  )  fast = fast.getRightNode() ;
            else fast = fast.getLeftNode() ;
        }
        if( slow.getData() < info  )
            slow.setRightNode(node);
        else
            slow.setLeftNode(node);
        return root ;

    }
    public int findLargest(TreeNode root)
    {
        if( root == null ){
            System.out.println("empty ");
            return -1 ;
        }
        while( root.getRightNode() != null )
            root = root.getRightNode() ;
        return root.getData();


    }
    public TreeNode deleteNode(TreeNode root , int info ){

        if( root == null ){
            return null ;
        }
        else if( info > root.getData() )
            root.setRightNode( this.deleteNode(root.getRightNode() , info) );
        else if( info < root.getData() )
            root.setLeftNode( this.deleteNode( root.getLeftNode() , info) ) ;
        else
        {
            TreeNode val  ;
            if( root.getRightNode() == null  ){
                val = root ;
                root = root.getLeftNode() ;
                val = null ;
            }
            else if ( root.getLeftNode() == null  ){
                val = root ;
                root = root.getRightNode() ;
                val = null ;
            }
            else{
                int art = this.findLargest(root.getLeftNode()) ;
                System.out.println(art);
                root.setData(art);
                root.setLeftNode( this.deleteNode(root.getLeftNode() , art )) ;

            }

            return root ;
        }
        return root;

    }
    public void inorderTraversal(TreeNode root){
        if( root != null ){
            this.inorderTraversal(root.getLeftNode());
            System.out.print(root.getData());
            System.out.print("\t");
            this.inorderTraversal(root.getRightNode());
        }
    }
    public void preorderTraversal(TreeNode root){
        if( root != null ){
            System.out.print(root.getData());
            System.out.print("\t");
            this.preorderTraversal(root.getLeftNode());
            this.preorderTraversal(root.getRightNode());
        }

    }
    public void postorderTraversal(TreeNode root){
        if( root != null ){
            this.postorderTraversal(root.getLeftNode());
            this.postorderTraversal(root.getRightNode());
            System.out.print(root.getData());
            System.out.print("\t");
        }

    }



}
public class Binary_Search_Tree{
    public static void main(String[] args) {
        TreeNode root = new TreeNode() ;
        BST T = new BST();
        root = T.createEmpty() ;
        root = T.insertNode(root ,20 ) ;
        root = T.insertNode(root ,10 ) ;
        root = T.insertNode(root ,30 ) ;
        root = T.insertNode(root ,21 ) ;
        root = T.insertNode(root ,60 ) ;
        T.inorderTraversal(root);
        System.out.println("");
        root = T.deleteNode(root,30 ) ;
        T.inorderTraversal(root);
        System.out.println(" ");
        T.preorderTraversal(root);
        System.out.println(" ");
        T.postorderTraversal(root);

    }

}


