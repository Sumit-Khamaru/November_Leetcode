import java.util.Arrays;

public class WhereWillTheBallFall {

/*
We can visualize it as a zig-zag bowling game where the grid represents the bowling surface. Every column is a different lane.
The balls thrown from the first row of every lane, travel in a zig-zag direction based on the walls in the grid.
if the ball reaches the last row we return the col no, else we return -1

Approach :
    we are using the DFS approach to simulating the actual flow of the ball
    now 2 cases arrived : where the ball stuck and when it moved
    the first thing that we see the ball moves diagonally :
        now if the cell value is 1 the ball moves right if it -1 it moves left
        now if the adjacent cell has the same value as current cell then the ball can move to the next diagonal else it stuck,
        so we have to check for adjacent cell ( for 1 col + 1) and (for -1 col -1 )

        base Condition :
        when we reach at the last row we return the col


 */
//    T.C. = O(m * n) m = no of rows and n = no of cols the recursive fun called for each N cols || if the ball is no stuck then the fun call happens for m rows.
//    S.C. = O(m) auxiliary stack space where m the depth of the recursive calls
    public static int[] findBall(int[][] grid) {
        int[] res = new int[grid.length];
        // we run a loop to generate all the balls states
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = findBallDrop(0, i, grid);
        }
        return res;
    }

    private static int findBallDrop(int row, int col, int[][] grid) {
        if(row == grid.length) {
            return col;
        }
        // of the current cell value id +1 then the ball move to right side then we need to check the right adjacent cell
        // next-col = col + 1 or col - 1 we check is the next col == current col then ball can move else it makes a "V" shape and the ball stuck
        int nextCol = col + grid[row][col];
        if(nextCol < 0 || nextCol > grid[0].length || grid[row][col] != grid[row][nextCol]) {
            return -1;
        }
        return findBallDrop(row + 1, nextCol, grid);
    }


    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(findBall(grid)));
    }
}
