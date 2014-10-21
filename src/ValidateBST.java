import undone.TreeNode;

import java.util.Stack;

public class ValidateBST {
  //non-recursive
  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode node = root;
    int prev = Integer.MIN_VALUE;
    while(node != null || !stack.isEmpty()) {
      while(node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      if(prev >= node.val)
        return false;
      prev = node.val;
      node = node.right;
    }
    return true;
  }

//  public boolean isValidBST(TreeNode root) {
//    if(root == null)
//      return true;
//    int[] ret = new int[2];
//    return isValidBST(root, ret);
//  }
//
//  boolean isValidBST(TreeNode root, int[] ret) {
//    int min = root.val, max = root.val;
//    if(root.left != null) {
//      if(!isValidBST(root.left, ret) || ret[1] >= root.val)
//        return false;
//      min = ret[0];
//    }
//    if(root.right != null) {
//      if(!isValidBST(root.right, ret) || ret[0] <= root.val)
//        return false;
//      max = ret[1];
//    }
//    ret[0] = min;
//    ret[1] = max;
//    return true;
//  }

    public static void main(String args[]) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    boolean result = new ValidateBST().isValidBST(root);
    System.out.println(result);
  }
}
