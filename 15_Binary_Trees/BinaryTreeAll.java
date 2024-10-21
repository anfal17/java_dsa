import java.util.*;

public class BinaryTreeAll {
    
    //static class helps nested classes ot instantiate objects without instantialting objects of oute rclass

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) {
            if(root == null){
                return ;
            }
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if(root == null){
                return ;
            }
            inorder(root.left);
            System.out.print(root.data+ " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if(root == null){
                return ;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+ " ");
        }

        //level order - BFS
        //use queue - FIFO

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            
            q.add(root);
            q.add(null); //for next level

            while(!q.isEmpty()){
                Node curNode = q.remove();

                if(curNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        //added after each level
                        q.add(null); //to also print again in next level
                    }
                } else {
                    System.out.print(curNode.data + " ");
                    if(curNode.left != null ){
                        q.add(curNode.left);
                    }
                    if(curNode.right != null){
                        q.add(curNode.right);
                    }
                }
            }  
        }
        
        //linear time - n nodes - n times visited nodes --> O(n)
        //height of tree = root to max deep leaf (interms of nodes and edges) edges--;
        //using recursion ==> 
        //parents height = max(left child, rightchild) + 1

        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        //count of nodes
        //visiting all nodes
        //finding left subtree node socunt and then right
        //lc + rc+ 1
        //tc - O(n)
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }

            int lc = countNodes(root.left);
            int rc = countNodes(root.right);
            return lc+rc+ 1;
        }

        //sum of nodes
        //recursively calculates for all the roots
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }
    }
    
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("root --> "+ root.data);

        tree.preorder(root);
        System.out.println();

        tree.inorder(root);
        System.out.println();

        tree.postorder(root);
        System.out.println();

        tree.levelOrder(root);
        System.out.println();

        System.out.println(tree.height(root));

        System.out.println(tree.countNodes(root));

        System.out.println(tree.sumOfNodes(root));
        
    }

    
}
