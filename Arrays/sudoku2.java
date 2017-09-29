/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that
each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle
 according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid
can only contain the numbers 1 through 9 one time.
*/

boolean sudoku2(char[][] grid) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (grid[i][j] != '.') {
               if (!isValid(i, j, grid)) {
                return false;
                }
            }
        }
    }

    return true;
}


// check if grid[i][j] is valid
// i = row, j = column
boolean isValid(int i, int j, char[][] grid) {
    // check if grid[i][j] is unique in i's row
    for (int column = 0; column < 9; column++) {
        // another number in the same row, different column has same value
        if (column != j && grid[i][column] == grid[i][j]) {
            return false;
        }
    }

    // check if grid[i][j] is unique in j's column
    for (int row = 0; row < 9; row++) {
        if(row != i && grid[row][j] == grid[i][j]) {
            return false;
        }
    }

    // check if grid[i][j] is unique in the 3 x 3 subgrid
    // find out which 3 x 3 subgrid grid[i][j] belongs to
    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
        for (int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++) {
            if (row != i && column != j && grid[row][column] == grid[i][j]) {
                return false;
            }
        }
    }

    return true;
}
