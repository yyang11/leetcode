package done;

import done.TreeNode;

public class MaxPathSum {
  int maxSum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    if(root == null)
      return 0;
    maxPath(root);
    return maxSum;
  }

  int maxPath(TreeNode root) {
    int l = 0, r = 0;
    if(root.left != null)
      l = maxPath(root.left);
    if(root.right != null)
      r = maxPath(root.right);
    maxSum = l + r + root.val > maxSum ? l + r + root.val : maxSum;
    return Math.max(Math.max(l, r) + root.val, 0);
  }
}
