public class Maze {
    private final int[][] MAZE;
    private final int HEIGHT;
    private final int WIDTH;

    public Maze(int[][] maze) {
        this.MAZE = maze;
        this.HEIGHT = maze.length; // высота (длина) сетки - длина внешнего массива
        this.WIDTH = maze[0].length; // ширина границ - длина (любого) вложенного массива
    }

    public void print(Player player) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == player.getRow() && j == player.getCol()) {
                    System.out.print("@ "); // игрок
                } else if (MAZE[i][j] == 1) {
                    System.out.print("# "); // стены
                } else if (MAZE[i][j] == 2) {
                    System.out.print("! "); // выход
                } else {
                    System.out.print("  "); // пустое пространство
                }
            }
            System.out.println();
        }
    }

    public int getCell(int row, int col) {
        return MAZE[row][col];
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
