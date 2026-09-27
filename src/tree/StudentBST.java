package tree;

public class StudentBST {
    private class Node {
        int studentID;
        String name; // අවශ්‍ය නම් වෙනත් තොරතුරු එකතු කළ හැක
        Node left, right;

        public Node(int id) {
            this.studentID = id;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insert(int id) {
        root = insertRec(root, id);
    }

    private Node insertRec(Node root, int id) {
        if (root == null) {
            root = new Node(id);
            return root;
        }
        if (id < root.studentID)
            root.left = insertRec(root.left, id);
        else if (id > root.studentID)
            root.right = insertRec(root.right, id);
        return root;
    }

    public boolean search(int id) {
        return searchRec(root, id);
    }

    private boolean searchRec(Node root, int id) {
        if (root == null) return false;
        if (root.studentID == id) return true;
        return id < root.studentID ? searchRec(root.left, id) : searchRec(root.right, id);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) return root;
        if (id < root.studentID)
            root.left = deleteRec(root.left, id);
        else if (id > root.studentID)
            root.right = deleteRec(root.right, id);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.studentID = minValue(root.right);
            root.right = deleteRec(root.right, root.studentID);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.studentID;
        while (root.left != null) {
            minv = root.left.studentID;
            root = root.left;
        }
        return minv;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.studentID + " ");
            inOrderRec(root.right);
        }
    }

    public void displayStudents() {
        inOrderTraversal();
        System.out.println();
    }
}
