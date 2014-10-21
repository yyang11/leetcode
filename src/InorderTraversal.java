import undone.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode node = root;
    while(node != null || !stack.isEmpty()) {
      while(node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      result.add(node.val);
      node = node.right;
    }
    return result;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    List<Integer> result = new InorderTraversal().inorderTraversal(root);
    System.out.println(result);
  }
}
