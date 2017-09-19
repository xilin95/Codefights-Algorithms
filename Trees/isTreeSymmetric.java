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
boolean isTreeSymmetric(Tree<Integer> t) {
    if(t == null) {
        return true;
    }

    return isTreeSymmetricHelper(t.left, t.right);
}

boolean isTreeSymmetricHelper(Tree<Integer> left, Tree<Integer> right) {    
    if(left == null && right == null) {
        return true;
    } else if(left == null || right == null) {
        return false;
    } else if (left.value != right.value) {
        return false;
    }

    return isTreeSymmetricHelper(left.right, right.left) && isTreeSymmetricHelper(left.left, right.right);
}
