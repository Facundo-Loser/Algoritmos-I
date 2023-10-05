public class TreeNode<T>{
    private T element; // elemento del nodo
    private TreeNode left; // hijo izquierdo
    private TreeNode right; // hijo derecho
    
    // constructor del NodoArbol por defecto
    public TreeNode(){
        element = null;
        left = null;
        right = null;
    }
    
    public TreeNode(T element){
      this.element = element;
      left = null;
      right = null;
    }
   
   public TreeNode(TreeNode left, T element, TreeNode right){
        this.element = element;
        this.left = left;
        this.right = right;
   }
   
   
   @Override 
   public String toString(){
     return "(" + left + "  " + element + "  " + right + ")";
   }
   
   public static void main(String[] args){
       TreeNode<Integer> tree = new TreeNode<>((new TreeNode(2)), 1, (new TreeNode(3)));
       
       System.out.println(tree.toString());
   }
}
