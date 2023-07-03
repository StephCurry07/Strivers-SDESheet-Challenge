import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagtraversal {
/******** Used lvlsize hehe...its nice ********/
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
		List<Integer> list = new ArrayList<>();
		Queue<BinaryTreeNode<Integer>> q = new LinkedList();
		if(root == null)
			return list;
		q.offer(root);
		int lvl = 0;
		while(!q.isEmpty()){
			int lvl_size = q.size();
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < lvl_size; i++){
				BinaryTreeNode<Integer> node = q.poll();
				temp.add(node.data);
				if(node.left != null)
					q.offer(node.left);
				if(node.right != null)
					q.offer(node.right);
			}
			if(lvl % 2 == 0){
				list.addAll(temp);
			}
			else{
				Collections.reverse(temp);
				list.addAll(temp);
			}
			lvl++;
		}
		return list;
	}
}
