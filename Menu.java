import java.util.Scanner;

public class Menu {
    private Console console = new Console();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            console.clear();
            System.out.println("Меню:\n" + "1. Старт\n" + "2. Правила\n" + "3. Стоп\n" + "Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    showRules();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Попробуйте еще раз.\n");
            }
        }
        scanner.close(); 
    }

    private void startGame() {
        Game game = new Game();
        game.start();
    }

    private void showRules() {
        console.clear();
        System.out.println("Правила:\n");
        System.out.println("1) Игрок (@) должен дойти до выхода (!).\n");
        System.out.println("2) Для передвижения используйте клавиши 'w', 'a', 's', 'd'.\n");
        System.out.println("3) Нажмите Enter, чтобы вернуться в меню.\n");
        scanner.nextLine();
    }
}