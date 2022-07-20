class nodeavl {
    int height;
    nodeavl left, right;
    String key;
    String email;
    String phone;
    String address;

    public nodeavl(String key, String email, String phone, String address) {
        this.key = key;
        this.email = email;
        this.phone = phone;
        this.address = address;
        height = 1;
        this.left = null;
        this.right = null;
    }

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(key);
        System.out.print(", ");
        System.out.print(email);
        System.out.print(", ");
        System.out.print(phone);
        System.out.print(", ");
        System.out.print(address);
        System.out.print("} ");
        System.out.println("");
    }
}

public class AVLTree {
    nodeavl root;
    phoneBook ph;

    public int getheight() {
        return height(root);
    }

    public int height(nodeavl N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    public void print() {
        long st = System.nanoTime();
        printTree(root, "", true);
        long end = System.nanoTime();
        System.out.println("Elapsed Time in print in nano seconds: " + (end - st));
    }

    private void printTree(nodeavl currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += " ";
            } else {
                System.out.print("L----");
                indent += "| ";
            }
            System.out.println(currPtr.key);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }

    public int getnuberNode() {
        return countNode(root);
    }

    public int countNode(nodeavl root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    nodeavl rightRotate(nodeavl y) {
        nodeavl x = y.left;
        nodeavl T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    nodeavl leftRotate(nodeavl x) {
        nodeavl y = x.right;
        nodeavl T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public int getBalance(nodeavl N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    nodeavl insert(nodeavl node, String key, String email, String phone, String address) {
        long st = System.nanoTime();
        if (node == null) {
            return (new nodeavl(key, email, phone, address));
        }
        if (key.compareToIgnoreCase(node.key) < 0) {
            node.left = insert(node.left, key, email, phone, address);
        } else if (key.compareToIgnoreCase(node.key) > 0) {
            node.right = insert(node.right, key, email, phone, address);
        } else {
            return node;
        }
        node.height = 1 + max(height(node.left),
                height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && key.compareToIgnoreCase(node.left.key) < 0) {
            return rightRotate(node);
        }
        if (balance < -1 && key.compareToIgnoreCase(node.right.key) > 0) {
            return leftRotate(node);
        }
        if (balance > 1 && key.compareToIgnoreCase(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key.compareToIgnoreCase(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        long end = System.nanoTime();
        System.out.println("Elapsed Time in insertion in nano seconds: " + (end - st));
        return node;
    }

    public void insAVL(String key, String email, String phone, String address) {
        root = insert(root, key, email, phone, address);
    }

    public void INOrder(nodeavl node) {
        if (node != null) {
            INOrder(node.left);
            System.out.println(node.key + " ");
            INOrder(node.right);
        }
    }

    public void inorderAVL() {
        INOrder(root);
    }

    nodeavl minValueNode(nodeavl node) {
        nodeavl current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    nodeavl deleteNode(nodeavl root, String key) {
        if (root == null) {
            System.out.println("node is empty");
            return root;
        }
        if (key.compareToIgnoreCase(root.key) < 0) {
            root.left = deleteNode(root.left, key);
        } else if (key.compareToIgnoreCase(root.key) > 0) {
            root.right = deleteNode(root.right, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                nodeavl temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                nodeavl temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }
        if (root == null)
            return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void deleteAvl(String key) {
        long st = System.nanoTime();
        root = deleteNode(root, key);
        long end = System.nanoTime();
        System.out.println("Elapsed Time in deletion in nano seconds: " + (end - st));
    }

    public void SearchAVl(String key) {
        long st = System.nanoTime();
        search(root, key);
        long end = System.nanoTime();
        System.out.println("Elapsed Time in search in nano seconds: " + (end - st));
    }

    public nodeavl search(nodeavl root, String key) {
        if (root == null) {
            System.out.println("NOT FOUND");
            return root;
        }
        if (root.key.compareToIgnoreCase(key) < 0) {
            return search(root.right, key);
        } else if (root.key.compareToIgnoreCase(key) == 0) {
            System.out.println("found :" + key);
            root.displayNode();
            return root;
        } else {
            return search(root.left, key);
        }

    }
}