package trees;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPostorder {
	HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

		// store values of inorder values in HashMap
		for (int i = 0; i < A.size(); i++) {
			map.put(A.get(i), i);
		}

		return create(A, B, 0, A.size() - 1, 0, B.size() - 1);
	}

	public TreeNode create(ArrayList<Integer> In, ArrayList<Integer> Po, int inStart, int inEnd, int poStart,
			int poEnd) {

		if (poStart > poEnd) {
			return null;
		}

		int rootValue = Po.get(poEnd);
		TreeNode node = new TreeNode(rootValue);
		int indx = map.get(rootValue);
		int sizeOfRST = inEnd - indx;

		node.left = create(In, Po, inStart, indx - 1, poStart, poEnd - sizeOfRST - 1);
		node.right = create(In, Po, indx + 1, inEnd, poEnd - sizeOfRST, poEnd);

		return node;

	}
}
