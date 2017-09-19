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
boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    return hasPathWithGivenSumHelper(t, s);
}

boolean hasPathWithGivenSumHelper(Tree<Integer> t, int remaining) {
    if (t == null) {
        if(remaining == 0) {
            return true;
        }
    } else {
        int currentRemaining = remaining - t.value;
        // At a leaf node
        if(t.left == null && t.right == null && currentRemaining == 0) {
            return true;
        }

        boolean onLeft = false;
        boolean onRight = false;
        if(t.left != null) {
            onLeft = hasPathWithGivenSumHelper(t.left, currentRemaining);
        }

        if(t.right != null) {
            onRight = hasPathWithGivenSumHelper(t.right, currentRemaining);
        }

        return onLeft || onRight;
        // return hasPathWithGivenSumHelper(t.left, remaining - t.value) || hasPathWithGivenSumHelper(t.right, remaining - t.value);

    }



    return false;
}
