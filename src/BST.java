import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Beckett Porter
 * @version: 04/5/24
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val)
    {
        return searchRecursively(root, val);
    }

    // Helper method used to recursively find if the tree has the desired value or not
    public boolean searchRecursively(BSTNode node, int searchVal)
    {
        if (node == null)
        {
            return false;
        }
        if (node.getVal() == searchVal)
        {
            return true;
        }
        if (node.getVal() > searchVal)
        {
            return searchRecursively(node.getLeft(), searchVal);
        }
        return searchRecursively(node.getRight(), searchVal);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> returnArray = new ArrayList<>();
        inorderRecursively(root, returnArray);
        return returnArray;
    }

    // Recursive helper method to get the inOrder traversal of the tree
    private void inorderRecursively(BSTNode node, ArrayList<BSTNode> ar)
    {
        if (node != null)
        {
            inorderRecursively(node.getLeft(), ar);
            ar.add(node);
            inorderRecursively(node.getRight(), ar);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> returnArray = new ArrayList<>();
        preorderRecursively(root, returnArray);
        return returnArray;
    }

    // Recursive helper method to get the preOrder traversal of the tree
    private void preorderRecursively(BSTNode node, ArrayList<BSTNode> ar)
    {
        if (node != null)
        {
            ar.add(node);
            preorderRecursively(node.getLeft(), ar);
            preorderRecursively(node.getRight(), ar);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> returnArray = new ArrayList<>();
        postorderRecursively(root, returnArray);
        return returnArray;
    }

    // Recursive helper method to get the postOrder traversal of the tree
    private void postorderRecursively(BSTNode node, ArrayList<BSTNode> ar)
    {
        if (node != null)
        {
            postorderRecursively(node.getLeft(), ar);
            postorderRecursively(node.getRight(), ar);
            ar.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    // Method to call insertRecursively and start the recursion with the input int val and root node
    public void insert(int val) {
        if (!search(val))
        {
            insertRecursively(root, val);
        }
    }

    // Recursive helper method that inserts a new node with the initial input value into the tree
    private void insertRecursively(BSTNode node, int val)
    {
        if (val < node.getVal())
        {
            if (node.getLeft() == null)
            {
                node.setLeft(new BSTNode(val));
            }
            else
            {
                insertRecursively(node.getLeft(), val);
            }
        }
        else if (val > node.getVal())
        {
            if (node.getRight() == null)
            {
                node.setRight(new BSTNode(val));
            }
            else
            {
                insertRecursively(node.getRight(), val);
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
