public class GameState {
    private int[][] boardState;

    public GameState(int[][] b){
        this.boardState = b;
    }

    public void printState(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(" " + boardState[i][j] + " ");
            }
            System.out.println();
        }
    }
}
