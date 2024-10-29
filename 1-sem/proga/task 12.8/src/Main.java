import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int[][] field = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0}
        };
        System.out.println("Введите начальную координату х: ");
        int startX = scanner.nextInt();
        System.out.println("Введите начальную координату у: ");
        int startY = scanner.nextInt();
        System.out.println("Введите количество возможных ходов для коняки: ");
        int moves = scanner.nextInt();

        KnightMoves knightMoves = new KnightMoves();
        List<int[]> reachableCells = knightMoves.findReachableCells(field, startX, startY, moves);

        System.out.println("Координаты итоговых позиций коника:");
        for (int[] cell : reachableCells) {
            System.out.println("(" + cell[0] + ", " + cell[1] + ")");
        }
    }
}
