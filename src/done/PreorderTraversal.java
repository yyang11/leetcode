package done;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    List<Integer> result = new ArrayList<Integer>();
    stack.push(root);
    while(root != null && !stack.isEmpty()) {
      root = stack.pop();
      result.add(root.val);
      if(root.right != null)
        stack.push(root.right);
      if(root.left != null)
        stack.push(root.left);
    }
    return result;
  }

  public static void main(String args[]) {

  }
}
