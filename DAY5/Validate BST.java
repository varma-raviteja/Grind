Approach 1: Recursive Traversal with Valid Range
The idea above could be implemented as a recursion. One compares the node value with its upper and lower limits if they are available. Then one repeats the same step recursively for left and right subtrees.

Current

class Solution {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}

Complexity Analysis

Time complexity : O(N)
Space complexity : O(N)


Approach 2: Iterative Traversal with Valid Range
The above recursion could be converted into iteration, with the help of an explicit stack. DFS would be better than BFS since it works faster here.

class Solution {

    private Deque<TreeNode> stack = new LinkedList();
    private Deque<Integer> upperLimits = new LinkedList();
    private Deque<Integer> lowerLimits = new LinkedList();

    public void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }
}
Complexity Analysis

Time complexity : O(N)
Space complexity : O(N)


Approach 3: Recursive Inorder Traversal
Algorithm

Let's use the order of nodes in the inorder traversal Left -> Node -> Right.

postorder

Here the nodes are enumerated in the order you visit them, and you could follow 1-2-3-4-5 to compare different strategies.

Left -> Node -> Right order of inorder traversal means for BST that each element should be smaller than the next one.

Hence the algorithm with O(N)\mathcal{O}(N)O(N) time complexity and O(N)\mathcal{O}(N)O(N) space complexity could be simple:

Compute inorder traversal list inorder.

Check if each element in inorder is smaller than the next one.

postorder

Do we need to keep the whole inorder traversal list?

Actually, no. The last added inorder element is enough to ensure at each step that the tree is BST (or not). Hence one could merge both steps into one and reduce the used space.

Code

We can implement the algorithm recursively.
  
 class Solution {
    // We use Integer instead of int as it supports a null value.
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}


Complexity Analysis

Time complexity : O(N) in the worst case when the tree is a BST or the "bad" element is a rightmost leaf.

Space complexity : O(N) for the space on the run-time stack.



Approach 4: Iterative Inorder Traversal
Alternatively, we could implement the above algorithm iteratively.

  class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}

Complexity Analysis

Time complexity : O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.

Space complexity : O(N) to keep stack.
