import java.util.Scanner;

public class Playing {

    public static void main(String[] args) {
        System.out.println("Welcome !");
        System.out.println("Enter your username");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Hello " + username);

        int earnedCoinCount = 1000;
        HighAndLowGame game = new HighAndLowGame(earnedCoinCount, 2);

        while (true) {
            System.out.println("You have " + earnedCoinCount + " Coin, Start the game? y / n");
            String startChoice = scanner.nextLine();

            if (startChoice.equalsIgnoreCase("y")) {
                System.out.println("Please bet Coin 1 ~ 100");
                int betCoin = Integer.parseInt(scanner.nextLine());

                if (betCoin < 1 || betCoin > 100) {
                    System.out.println("Invalid input. Please enter a valid bet Coin between 1 and 100.");
                    continue;
                }

                int resultCoin = game.execute();
                earnedCoinCount += resultCoin;
                System.out.println("Your winCoin is " + resultCoin);

                if (resultCoin == 0) {
                    System.out.println("You lose");
                } else {
                    System.out.println("You got " + resultCoin + " Coin !!");
                }
            } else if (startChoice.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }

        System.out.println(username + " Possession : " + earnedCoinCount + " Coin");
    }
}
