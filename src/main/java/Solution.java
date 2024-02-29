import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean even = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            even = !even;
            int size = q.size();
            if(even){
                int prev = Integer.MIN_VALUE;
                for(int i = 0; i < size; i++){
                    TreeNode cur = q.poll();
                    int curVal = cur.val;
                    if(curVal % 2 == 0){
                        return false;
                    }
                    if(prev != Integer.MIN_VALUE && prev >= curVal){
                        return false;
                    }
                    prev = curVal;
                    if(cur.left != null){
                        q.offer(cur.left);
                    }
                    if(cur.right != null){
                        q.offer(cur.right);
                    }
                }
            }else {
                int prev = Integer.MIN_VALUE;
                for(int i = 0; i < size; i++){
                    TreeNode cur = q.poll();
                    int curVal = cur.val;
                    if(curVal % 2 == 1){
                        return false;
                    }
                    if(prev != Integer.MIN_VALUE && prev <= curVal){
                        return false;
                    }
                    prev = curVal;
                    if(cur.left != null){
                        q.offer(cur.left);
                    }
                    if(cur.right != null){
                        q.offer(cur.right);
                    }
                }
            }

        }

        return true;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}