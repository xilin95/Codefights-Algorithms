//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }

Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
    Tree binaryTree = restoreBinaryTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    // To check output
    inorderTraversal(binaryTree);
    System.out.println("");
    preorderTraversal(binaryTree);

    return binaryTree;
}

// Need to recursively pick the root each step
Tree<Integer> restoreBinaryTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd) {
        return null;
    }

    if(preStart == preEnd) {
        return new Tree(preorder[preStart]);
    }

    // first element in pre-order is the root, then we know how many elements are to its left and right using the inorder array
    int inorderIndex = 0;
    for (int i = inStart; i <= inEnd; i++) {
        if(inorder[i] == preorder[preStart]) {
            inorderIndex = i;
        }
    }

    int countLeftNodes = inorderIndex - inStart;
    int countRightnodes = inEnd - inorderIndex;

    Tree root = new Tree(preorder[preStart]);
    root.left = restoreBinaryTreeHelper(preorder, preStart + 1, preStart + countLeftNodes, inorder, inStart, inorderIndex - 1);
    root.right = restoreBinaryTreeHelper(preorder, preStart + countLeftNodes + 1, preEnd, inorder, inorderIndex + 1, inEnd);

    return root;
}

// Add an in-order and pre-order traversal methods to verify output
void inorderTraversal(Tree<Integer> root) {
    // First left, then root, then right
    if (root != null) {
        if (root.left != null) {
            inorderTraversal(root.left);
        }

        System.out.print(root.value + " ");

        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }
}

void preorderTraversal(Tree<Integer> root) {
    // First root, then left, then right
    if (root != null) {
        System.out.print(root.value + " ");

        if(root.left != null) {
            preorderTraversal(root.left);
        }

        if(root.right != null) {
            preorderTraversal(root.right);
        }
    }
}
