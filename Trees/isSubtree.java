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
boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t2 == null) {
        return true;
    } else if (t1 == null) {
        return false;
    }

    if (identical(t1, t2)) {
        return true;
    } else {
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }
}

boolean identical(Tree<Integer> t1, Tree<Integer> t2) {
    if (t1 == null && t2 == null) {
        return true;
    } else if (t1 != null && t2 != null) {
        if (t1.value.equals(t2.value) && identical(t1.left, t2.left) && identical(t1.right, t2.right)) {
            return true;
        }
    }

    return false;
}
