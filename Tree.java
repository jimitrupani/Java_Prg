import java.util.Scanner;

class Node
{
    int key;
    Node left, right;
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
class Tree
{
    Node root;
    Tree(int key)
    {
        root = new Node(key);
    }
    Tree()
    {
        root = null;
    }
    // TO find a Node
    public Node find(Node root,int val) {

        Node result = null;
        if(root.left != null)
            result = find(root.left,val);
        if(root.key == val)
            return root;
        if(result ==null && root.right != null)
            result = find(root.right,val);
        return result;
    }
   //Inorder Print
    void printInorder(Node root)
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }

    public static void main(String[] args)
    {
        Tree tree = new Tree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(5);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        System.out.println("\nInorder traversal of binary tree is ");tree.printInorder(tree.root);
        System.out.println("\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any Node value : ");
        int nodeValue = scan.nextInt();
        Node found = tree.find(tree.root,nodeValue);
        if(found != null)
            System.out.println("Value present in tree");
        else {
            System.out.println("Value is not present in tree");
        }
        }
    }