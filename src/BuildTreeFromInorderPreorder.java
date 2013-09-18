import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPreorder {

	Map<Integer, Integer> map;
	int preIndex;

	/**
	 * http://leetcode.com/oldoj#question_105
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preIndex = 0;
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return build(preorder, inorder, 0, inorder.length);
	}

	private TreeNode build(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
		if (preIndex >= preorder.length || inorderLeft >= inorderRight) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[preIndex]);
		int inIndex = map.get(preorder[preIndex]);
		preIndex++;
		TreeNode left = build(preorder, inorder, inorderLeft, inIndex);
		TreeNode right = build(preorder, inorder, inIndex + 1, inorderRight);
		node.left = left;
		node.right = right;
		return node;
	}

	public static void main(String[] args) {
		int[] pre = new int[] { 3, 1, 2, 4 };
		int[] ino = new int[] { 1, 2, 3, 4 };
		BuildTreeFromInorderPreorder bp = new BuildTreeFromInorderPreorder();

		TreeNode root = bp.buildTree(pre, ino);
		System.out.println(root);
	}

}
