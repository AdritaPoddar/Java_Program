/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode n,int lvl){
            node=n;
            level=lvl;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
         ArrayList<Integer> ans=new ArrayList<>();
        //base case
        if(root==null){
            return ans;
        }
        
        TreeMap<Integer,Integer> leftMap=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            TreeNode frontNode=temp.node;
            int lvl=temp.level;
            
           
                leftMap.put(lvl,frontNode.val);
            
            
            if(frontNode.left!=null){
                q.add(new Pair(frontNode.left,lvl+1));
            }
            if(frontNode.right!=null){
                q.add(new Pair(frontNode.right,lvl+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:leftMap.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}