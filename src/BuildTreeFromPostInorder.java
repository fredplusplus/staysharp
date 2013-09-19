import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPostInorder {
	Map<Integer, Integer> map;
	int postIndex = 0;

	/**
	 * http://leetcode.com/oldoj#question_106
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		postIndex = postorder.length - 1;
		return build(inorder, postorder, 0, inorder.length);
	}

	private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
		if (postIndex < 0 || inStart >= inEnd) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[postIndex]);
		int inIndex = map.get(postorder[postIndex]);
		postIndex--;
		TreeNode right = build(inorder, postorder, inIndex + 1, inEnd);
		TreeNode left = build(inorder, postorder, inStart, inIndex);
		node.left = left;
		node.right = right;
		return node;
	}

	public static void main(String[] args) {
		BuildTreeFromPostInorder bp = new BuildTreeFromPostInorder();
		TreeNode root = bp.buildTree(new int[] { 2, 1, 3 }, new int[] { 2, 3, 1 });
		System.out.println(root);
	}
}
