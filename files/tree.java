class Node{
    int value;
    Node left;
    Node right;

    Node(int val){
        value = val;
        left = right = null;
    }
}

class T{
    // preorder traversal --> [value of root node][preorder of left subtree][preorder of right subtree]
    public static void preorder(Node root){
        if(root == null)return ;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // inorder traversal --> [inorder of left subtree][value of root node][inorder of right subtree]
    public static void inorder(Node root){
        if(root == null)return ;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    // postorder traversal --> [postorder of left subtree][postorder of right subtree][value of root node]
    public static void postorder(Node root){
        if(root == null)return ;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    /*  height of a null tree = 0
        height of single node tree =  1 ...

        height = 1+ max of heights of left and right subtrees
    */
    public static int height(Node root){
        if(root == null) return 0;
        int a= height(root.left);
        int b = height(root.right);
        if(a<b)a=b;
        return 1+a;
    }

    // search, search at current node, and recursively search on left and right subtrees
    public static boolean search (Node root, int value){
        if(root == null) return false;
        if(root.value == value) return true;

        return search(root.left, value) || search(root.right, value);
    }

    public static void main(String[] args){

        // NODES IN SOME EXAMPLE TREE
        
        //Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n7 = new Node(7);
        Node n20 = new Node(20);
        Node n64 = new Node(64);
        Node n77 = new Node(77);
        Node n88 = new Node(88);
        Node n101 = new Node(101);
        Node n200 = new Node(200);
        /*Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);*/

        // LINKING THE NODES IN THE TREE
        n77.left = n20;
        n77.right = n101;
        n20.left = n1; n20.right = n64;
        n1.right = n7;
        n101.left = n88;
        n101.left = n200;

        // TESTING OUR OPERATIONS WE WROTE ABOVE
        System.out.print("pre order : ");
        preorder(n77);
        System.out.print("\nin order : ");
        inorder(n77);
        System.out.print("\npost order : ");
        postorder(n77);
        System.out.print("height of tree : " + height(n77) + "\n");
        System.out.print("searching for 64 : " + search(n77,64) + "\n");
        System.out.print("searching for 78 : " + search(n77,78) + "\n");
        
    }

}
