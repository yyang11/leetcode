package undone;

import done.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    pathSum(root, sum, path, result);
    return result;
  }

  public void pathSum(TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> result) {
    if(root == null)
      return;
    path.add(root.val);
    if(root.left == null && root.right == null && root.val == sum) {
      result.add(new ArrayList<Integer>(path));
      path.removeLast();
      return;
    }
    if(root.left != null)
      pathSum(root.left, sum - root.val, path, result);
    if(root.right != null)
      pathSum(root.right, sum - root.val, path, result);
    path.removeLast();
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    System.out.println(new PathSumII().pathSum(root, 1));
  }
}
