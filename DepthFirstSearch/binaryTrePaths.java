public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new LinkedList<>();

        if(root == null) return paths;
        
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }

         return paths;
        
    }


// Mine: 21ms 
List<String> path = new ArrayList<>();
        if (root == null) return path;
        
        // if (root.left != null) 
        List<String> leftPaths = binaryTreePaths(root.left);
        //if (root.right != null) 
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for (String leftPath: leftPaths) {
            path.add(root.val + "->" + leftPath);
        }
        for (String rightPath: rightPaths) {
            path.add(root.val + "->" + rightPath);
        }
        
        if (path == null || path.size() == 0) path.add("" + root.val);
        System.out.println(path);
        return path;
// optimize to check whether it has no child -> 16ms 12%
public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        if (root == null) return path;
        if (root.left == null && root.right == null) {
            path.add(""+ root.val);
        }
        
        // if (root.left != null) 
        List<String> leftPaths = binaryTreePaths(root.left);
        //if (root.right != null) 
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for (String leftPath: leftPaths) {
            path.add(root.val + "->" + leftPath);
        }
        for (String rightPath: rightPaths) {
            path.add(root.val + "->" + rightPath);
        }
        return path;

        // Mine 2nd time: 53%
class Solution {
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return paths;
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        
        getPath(root, path);
        return paths;
    }
    
    private void getPath(TreeNode root, StringBuilder currPath) {
        if (root.left == null && root.right == null) {
            paths.add(currPath.toString());
            return;
        }
        
        if (root.left == null) {
            currPath.append("->" + Integer.toString(root.right.val));
            // currPath.append(root.right.val);
            getPath(root.right, currPath);
            return;
        }
        
        if (root.right == null) {
            currPath.append("->" + Integer.toString(root.left.val));
            // currPath.append(root.left.val);
            getPath(root.left, currPath);
            return;
        }
        
        currPath.append("->");
        StringBuilder left = new StringBuilder(currPath);
        getPath(root.left, left.append(root.left.val));
        StringBuilder right = new StringBuilder(currPath);
        getPath(root.right, right.append(root.right.val));
        return;
    }
}
        
// Iteration : 91% ~ 10ms 
public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        helper(root, String.valueOf(root.val), paths);
        return paths;
    }
    
    private void helper(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        
        if (root.left != null) 
            helper(root.left, path + "->" + String.valueOf(root.left.val), paths);
        if (root.right != null)
            helper(root.right, path+ "->" + String.valueOf(root.right.val), paths);
    }
