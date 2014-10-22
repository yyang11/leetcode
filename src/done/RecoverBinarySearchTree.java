package undone;

import done.TreeNode;

import java.util.Stack;

public class RecoverBinarySearchTree {
  public void recoverTree(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode node = root, prev = null;
    TreeNode a = null, b = null;
    while(node != null || !stack.isEmpty()) {
      while(node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      if(prev != null && prev.val > node.val) {
        if(a == null) {
          a = prev;
          b = node;
        }
        else {
          b = node;
        }
      }
      prev = node;
      node = node.right;
    }
    int tmp = a.val;
    a.val = b.val;
    b.val = tmp;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    new RecoverBinarySearchTree().recoverTree(root);
    return;
  }
}
