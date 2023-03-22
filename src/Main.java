import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int randomRange = 100;
    private static int attemptsMaximum = 10;
    private static Random rand = new Random();
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Добро пожаловать в игру угадай число!");
        System.out.println("-------------------------------------\n");
        boolean isActiveGame = true;
        while(isActiveGame){
            isActiveGame = Menu();
        }
    }
    static boolean Menu(){
        int switchMode = 0;
        System.out.println("Меню:\n" +
                "1) Играть\n" +
                "2) Настройки\n" +
                "3) Выйти");
        System.out.print("Выберите пункт, введя значение с клавиатуры: ");
        switchMode = scan.nextInt();
        switch(switchMode){
            case 1:
                Game();
                break;
            case 2:
                Settings();
                break;
            case 3:
                String status;
                System.out.print("Вы точно хотите выйти из игры? y/n: ");
                status = scan.next();
                if(status.equals("y") || status.equals("yes")){
                    System.out.println("Завершение работы.");
                    return false;
                }
                else {
                    return true;
                }
            default:
                System.out.println("Выберите один из пунктов меню!");
                break;
                }
                return true;
        }
    static void Game(){
        int randomNumber = rand.nextInt(randomRange);
        System.out.println("\nЧисло загадано! Попробуйте угадать его!");
        System.out.println("Максимальное количество попыток: " + attemptsMaximum);
        System.out.println("Диапазон значений: " + randomRange);
        int attempts = 0;
        int guessNumber;
        while(attempts <= attemptsMaximum){
            System.out.print("Введите число: ");
            guessNumber = scan.nextInt();
            if(guessNumber <= 100 && guessNumber >= 0){
                if(guessNumber > randomNumber){
                    System.out.println("Ваше число БОЛЬШЕ загаданного!");
                    attempts++;
                }
                else if (guessNumber < randomNumber){
                    System.out.println("Ваше число МЕНЬШЕ загаданного!");
                    attempts++;
                }
                else{
                    System.out.println("Поздравляем! Вы угадали число " + randomNumber);
                    return;
                }
            }
            else{
                System.out.println("Введите число от 0 до 100! Попробуйте еще раз!");
            }
        }
        System.out.println("Ваше число попыток к сожалению истекло. Вы проиграли!");
    }

    static void Settings(){
        boolean isSettingsActive = true;
        while(isSettingsActive){
            System.out.println("Настройки:\n" +
                    "1) Уровень сложности\n" +
                    "2) Диапазон значений\n" +
                    "3) Выйти");
            System.out.print("Выбор опции: ");
            int switchMode = scan.nextInt();
            switch(switchMode){
                case 1:
                    int level;
                    System.out.println("Выберите уровень сложности:\n" +
                            "1) Легкий - 15 попыток\n" +
                            "2) Средний - 10 попыток\n" +
                            "3) Сложный - 7 попыток");
                    System.out.print("Выбор: ");
                    level = scan.nextInt();
                    switch (level){
                        case 1:
                            attemptsMaximum = 15;
                            System.out.println("Ваш выбор сохранен. Максимальнре число попыток = " + attemptsMaximum);
                            break;
                        case 2:
                            attemptsMaximum = 10;
                            System.out.println("Ваш выбор сохранен. Максимальнре число попыток = " + attemptsMaximum);
                            break;
                        case 3:
                            attemptsMaximum = 7;
                            System.out.println("Ваш выбор сохранен. Максимальнре число попыток = " + attemptsMaximum);
                            break;
                        default:
                            System.out.println("Выберите надлежащий уровень сложности!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Введите значение желаемого диапазона значений: ");
                    randomRange = scan.nextInt();
                    System.out.println("Значение успешно перезаписано!");
                    break;
                case 3:
                    String status;
                    System.out.print("Вы точно хотите выйти из настроек? y/n: ");
                    status = scan.next();
                    if(status.equals("y") || status.equals("yes")){
                        isSettingsActive = false;
                    }
                    else {
                        isSettingsActive = true;
                    }
            }
        }
    }
}