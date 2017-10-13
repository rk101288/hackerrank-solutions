/**
 * Created by ricks on 9/17/17.
 */
public class BST {
    public static void main(String[] args) {

    }

    boolean checkBST(Node root) {
        return false;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        void insert(int value, Node node) {
            if(value < node.data) {
                if(node.left == null) {
                    node.left = new Node(data);
                } else {
                    insert(value, node.left);
                }
            } else {
                if(node.right == null) {
                    node.right = new Node(data);
                } else {
                    insert(value, node.right);
                }
            }
        }

        boolean isBST (Node root, Integer min, Integer max) {
            if(root == null) {
                return false;
            }

            if(root.data < min || root.data > max) {
                return false;
            }

            Boolean rightCondition = isBST(root.right, root.data + 1, max);
            Boolean leftCondition = isBST(root.left, min, root.data - 1);

            return rightCondition && leftCondition;
        }
    }
}
