import done.TreeNode;

import java.util.Stack;

//classic
public class ValidateBST {
  //iterative
//  public boolean isValidBST(TreeNode root) {
//    Stack<TreeNode> stack = new Stack<TreeNode>();
//    TreeNode node = root;
//    int prev = Integer.MIN_VALUE;
//    while(node != null || !stack.isEmpty()) {
//      while(node != null) {
//        stack.push(node);
//        node = node.left;
//      }
//      node = stack.pop();
//      if(prev >= node.val)
//        return false;
//      prev = node.val;
//      node = node.right;
//    }
//    return true;
//  }

  //revursive
  int prev = Integer.MIN_VALUE;
  public boolean isValidBST(TreeNode root) {
    if(root == null)
      return true;
    if(!isValidBST(root.left) || prev >= root.val)
      return false;
    prev = root.val;
    return isValidBST(root.right);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    boolean result = new ValidateBST().isValidBST(root);
    System.out.println(result);
  }
}
