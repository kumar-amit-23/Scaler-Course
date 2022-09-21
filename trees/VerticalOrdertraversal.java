package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
*/
public class VerticalOrdertraversal {
	class Pair{
        TreeNode node;
        int level;

        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    
        int min = 0;
        int max = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(A,0);
        queue.add(p);

        while(!queue.isEmpty()){
            Pair temp = queue.poll();

            if(map.containsKey(temp.level)){
            	ArrayList<Integer> list = map.get(temp.level);
            	list.add(temp.node.val);
                map.put(temp.level, list);
            }else {
            	ArrayList<Integer> list = new ArrayList<>();
            	list.add(temp.node.val);
            	map.put(temp.level, list);
            }
            
            if(temp.node.left != null) {
            	min = Math.min(min, temp.level - 1);
            	p = new Pair(temp.node.left, temp.level - 1);
            	queue.add(p);
            }
            
            if(temp.node.right != null) {
            	max = Math.max(max, temp.level + 1);
            	p = new Pair(temp.node.right, temp.level + 1);
            	queue.add(p);
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = min; i<=max; i++){
            ans.add(map.get(i));
        }

        return ans;
        
        
    }

}
