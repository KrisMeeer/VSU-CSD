import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightMoves {

    public List<int[]> findReachableCells(int[][] field, int x, int y, int movesLeft) {
        List<int[]> reachableCells = new ArrayList<>();
        findReachableCells(field, x, y, movesLeft, reachableCells);
        return reachableCells;
    }

    private void findReachableCells(int[][] field, int x, int y, int movesLeft, List<int[]> reachableCells) {
        if (x < 0 || x >= field.length || y < 0 || y >= field[0].length || field[x][y] == 1) {
            return;
        }
        reachableCells.add(new int[]{x, y});
        if (movesLeft == 0) {
            return;
        }
        int[][] moves = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        for (int[] move : moves) {
            findReachableCells(field, x + move[0], y + move[1], movesLeft - 1, reachableCells);
        }
    }
}
