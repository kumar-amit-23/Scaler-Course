package trees;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPreorder {
	HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		// store values of inorder values in HashMap
		for (int i = 0; i < B.size(); i++) {
			map.put(B.get(i), i);
		}

		return create(B, A, 0, B.size()-1, 0, A.size()-1);
	}

	public TreeNode create(ArrayList<Integer> In, ArrayList<Integer> Pre, int inStart, int inEnd, int preStart,
			int preEnd) {

		if (preEnd < preStart) {
			return null;
		}

		int rootValue = Pre.get(preStart);
		TreeNode node = new TreeNode(rootValue);
		int indx = map.get(rootValue);
		int valuesInLST = indx - inStart;
		node.left = create(In, Pre, inStart, indx - 1, preStart + 1, preStart + valuesInLST);
		node.right = create(In, Pre, indx + 1, inEnd, preStart + valuesInLST + 1, preEnd);

		return node;
	}
}
