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

private static int result = 0;
private static int remaining = 0;

int kthLargestInBST(Tree<Integer> t, int k) {
    // Requires pre-order traveral of the tree
    // Will need a counter to keep track of number of nodes left to be traversed
    remaining = k;
    kthLargestInBSTHelper(t);
    return result;
}

void kthLargestInBSTHelper(Tree<Integer> t) {

    if (t.left != null) {
        kthLargestInBSTHelper(t.left);
    }

    remaining--;

    if (remaining == 0) {
        result = t.value;
        return;
    }

    if (t.right != null) {
        kthLargestInBSTHelper(t.right);
    }

}
