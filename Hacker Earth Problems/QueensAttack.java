import AkPackage.*;
import java.util.*;

public class QueensAttack {

    static class Position {
        int row, col;
        static boolean obstacle[][];
        public Position(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String args[]) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new QueensAttack());
        while (!lines.isEmpty()) {
            int arr[] = InputOutput.arrayFromString(lines.remove(0)), // board size and k
                    queenPos[] = InputOutput.arrayFromString(lines.remove(0));

            List<ArrayList<Integer>> pieces = new ArrayList<>();

            for (int i = 0; i < arr[1]; i++)
                pieces.add(InputOutput.ArrayListFromString(lines.remove(0)));

            System.out.println("\nFor input: ");
            pieces.forEach(x -> System.out.print(x + " "));
            System.out.println("\nAns is: " + queenAttack(arr[0], arr[1], queenPos[0], queenPos[1], pieces));
        }
    }

    public static int queenAttack(int n, int k, int rq, int cq, List<ArrayList<Integer>> obstacles) {
        Position queen = new Position(rq, cq);
        Position.obstacle = new boolean[n+1][n+1];

        obstacles.forEach(x -> Position.obstacle[x.get(0)][x.get(1)] = true);

        System.out.println(Arrays.deepToString(Position.obstacle));

        return recurr(obstacles, new Position(queen.row + 1, queen.col), n, "up")
                + recurr(obstacles, new Position(queen.row - 1, queen.col), n, "down")
                + recurr(obstacles, new Position(queen.row, queen.col - 1), n, "left")
                + recurr(obstacles, new Position(queen.row, queen.col + 1), n, "right")
                + recurr(obstacles, new Position(queen.row + 1, queen.col + 1), n, "upright")
                + recurr(obstacles, new Position(queen.row - 1, queen.col + 1), n, "downright")
                + recurr(obstacles, new Position(queen.row - 1, queen.col - 1), n, "downleft")
                + recurr(obstacles, new Position(queen.row + 1, queen.col - 1), n, "upleft");
    }

    public static int recurr(List<ArrayList<Integer>> obstacles, Position pos, int n, String direction) {
        if (check(pos, n, obstacles))
            return 0;
        else if (direction.compareTo("up") == 0)
            return recurr(obstacles,new Position(pos.row + 1, pos.col), n, direction) + 1;
        else if (direction.compareTo("down") == 0)
            return recurr(obstacles,new Position(pos.row - 1, pos.col), n, direction) + 1;
        else if (direction.compareTo("left") == 0)
            return recurr(obstacles,new Position(pos.row, pos.col - 1), n, direction) + 1;
        else if (direction.compareTo("right") == 0)
            return recurr(obstacles,new Position(pos.row, pos.col + 1), n, direction) + 1;
        else if (direction.compareTo("upright") == 0)
            return recurr(obstacles,new Position(pos.row + 1, pos.col + 1), n, direction) + 1;
        else if (direction.compareTo("downright") == 0)
            return recurr(obstacles,new Position(pos.row - 1, pos.col + 1), n, direction) + 1;
        else if (direction.compareTo("downleft") == 0)
            return recurr(obstacles,new Position(pos.row - 1, pos.col - 1), n, direction) + 1;
        else if (direction.compareTo("upleft") == 0)
            return recurr(obstacles,new Position(pos.row + 1, pos.col - 1), n, direction) + 1;

        else
            return 0;
    }

    public static boolean check(Position pos, int size, List<ArrayList<Integer>> obstacles) {
        return  pos.row <= 0 || pos.row > size || pos.col <= 0 || pos.col > size || Position.obstacle[pos.row][pos.col];
    }

}