/*You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

Example:

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]

the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
*/

int[][] rotateImage(int[][] a) {
    int length = a.length;

    int[][] result = new int[length][length];

    for(int i = 0; i < length; i++) {
        for (int j = length - 1; j > -1; j--) {
            result[i][length-j-1] = a[j][i];
        }
    }

    return result;
}
