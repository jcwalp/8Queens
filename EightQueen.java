import java.util.ArrayList;

public class EightQueen {

    final int numOfQueens = 8;
    ArrayList<GameState> states = new ArrayList<>();

    public void printSolution(int board[][]){
        for (GameState a : states){
            a.printState();
            System.out.println();
        }


    }

    public boolean isSafe(int board[][], int row, int col){
        int i, j;

        for (i = 0; i < col; i++){
            if (board[row][i] == 1){
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 1){
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < numOfQueens; i++, j--){
            if (board[i][j] == 1){
                return false;
            }
        }
        return true;

    }

    boolean solveQueen(int board[][], int col){
        if (col >= numOfQueens){
            return true;
        }

        for (int i = 0; i < numOfQueens; i++){
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveQueen(board, col + 1)) {
                    states.add(new GameState(board));
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    boolean solveQs(){
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0 ,0}
        };

        if (!solveQueen(board, 0)){
            System.out.println("no solution");
            return false;
        }
        printSolution(board);
        return true;
    }


    public static void main(String[] args){
        EightQueen q = new EightQueen();
        q.solveQs();
    }

}
