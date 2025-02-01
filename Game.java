import java.util.Scanner;

public class Game {
    private Console console = new Console();
    private Maze maze;
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int mazeHeight = 15;
        int mazeWidth = 21;
        MazeGenerator generator = new MazeGenerator(mazeHeight, mazeWidth);
        int[][] generatedMaze = generator.generate();
        maze = new Maze(generatedMaze);
        player = new Player(0, 1); // старт игрока

        boolean gameRunning = true;
        while (gameRunning) {
            console.clear();
            maze.print(player);
            if (isAtExit()) {
                System.out.println("Поздравляем! Вы нашли выход!\n");
                gameRunning = false;
            } else {
                System.out.println("Используйте w/a/s/d для перемещения: ");
                char move = scanner.next().charAt(0);
                movePlayer(move);
            }
        }
        scanner.nextLine();
    }

    private void movePlayer(char move) {
        int currentRow = player.getRow();
        int currentCol = player.getCol();
        int newRow = currentRow;
        int newCol = currentCol;

        switch (move) {
            case 'w':
                newRow--;
                break;
            case 's':
                newRow++;
                break;
            case 'a':
                newCol--;
                break;
            case 'd':
                newCol++;
                break;
        }
        if (isValidMove(newRow, newCol)) {
            player.move(newRow, newCol);
        } else {
            System.out.println("Недопустимый ход.\n");
        }
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= maze.getHEIGHT() || col < 0 || col >= maze.getWIDTH()) {
            return false;
        }
        return maze.getCell(row, col) != 1;
    }

    private boolean isAtExit() {
        return maze.getCell(player.getRow(), player.getCol()) == 2;
    }
}

