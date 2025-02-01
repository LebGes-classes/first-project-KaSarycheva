public class MazeGenerator {
    private int height;
    private int width;
    private int[][] maze;

    public MazeGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        this.maze = new int[height][width];
    }

    public int[][] generate() {
        // заполняем лабиринт стенами
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = 1; // 1 - стена
            }
        }
        // генерируем лабиринт рекурсивным обходом
        generateRecursive(1, 1);
        // делаем вход и выход
        makeEntranceAndExit();
        return maze;
    }

    private void makeEntranceAndExit() {
        maze[0][1] = 0;
        maze[height - 1][width - 2] = 2;
    }

    private void generateRecursive(int row, int col) {
        maze[row][col] = 0; // 0 - проход

        int[][] directions = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
        shuffleArray(directions);

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow > 0 && newRow < height - 1 && newCol > 0 && newCol < width - 1 && maze[newRow][newCol] == 1) {
                maze[row + dir[0] / 2][col + dir[1] / 2] = 0;
                generateRecursive(newRow, newCol);
            }
        }
    }

    private void shuffleArray(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
