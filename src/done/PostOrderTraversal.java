package done;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    LinkedList<Integer> result = new LinkedList<Integer>();
    stack.push(root);
    while(root != null && !stack.isEmpty()) {
      root = stack.pop();
      result.addFirst(root.val);
      if(root.left != null)
        stack.push(root.left);
      if(root.right != null)
        stack.push(root.right);
    }
    return result;
  }
}
