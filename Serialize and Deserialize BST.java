public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder("");
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(q.size() > 0) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] s = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        for(int i = 1; i < s.length; i++) {
            TreeNode parent = q.poll();
            if(!s[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(s[i]));
                q.add(parent.left);
            }
            i++;
            if(i < s.length && !s[i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(s[i]));
                q.add(parent.right);
            }
        }
        
        return root;
    }
}