import java.util.Scanner;

public class CardPickGame {

    private int maxBetCoin = 100; // 最大ベット枚数
    private int deckSetCount = 2; // カードセット数
    private int possessionCoin; // 所持コイン数

    public static void main(String[] args) {
        CardPickGame game = new CardPickGame(400); // インスタンス生成時に所持コイン枚数を設定する
    }

    public CardPickGame(int possessionCoin) {
        this.possessionCoin = possessionCoin;
        execute();
    }

    private boolean judgeCard(int getCardResult) {
        if (getCardResult >= 11) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }

    public void execute() {
        while (true) {
            int currentCoin = checkPossessionCoin();
            if (currentCoin == 0) {
                // 所持コインが0の場合
                return;
            } else if (currentCoin == -1) {
                // ゲーム開始
                acceptBetCoin();
            } else {
                // 処理終了
                return;
            }
        }
    }

    public int checkPossessionCoin() {
        if (possessionCoin == 0) {
            return 0;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have " + possessionCoin + " Coin, Start the game? y / n");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
                // ゲーム開始
                return -1;
            } else if (userInput.equalsIgnoreCase("n")) {
                // 処理終了
                return possessionCoin;
            } else {
                System.out.println("Please enter y or n.");
                return checkPossessionCoin(); // 再帰的にメソッドを呼び出す
            }
        }
    }

    public void acceptBetCoin() {
        int betCoinLimit = Math.min(maxBetCoin, possessionCoin);
        System.out.println("Please bet Coin 1 ~ " + betCoinLimit);
        Scanner scanner = new Scanner(System.in);
        int betCoin = scanner.nextInt();
        if (betCoin > 0 && betCoin <= betCoinLimit) {
            int remainingCoin = possessionCoin - betCoin;
            int cardTotal = getCard();

            if (judgeCard(cardTotal)) {
                // Trueの場合
                int winCoin = betCoin * 2;
                int newCoin = remainingCoin + winCoin;
                System.out.println("You Win! Get " + newCoin + " Coin!");
                possessionCoin = newCoin;
            }
        } else {
            System.out.println("Please enter a valid bet coin.");
            acceptBetCoin();
        }
    }

    public int getCard() {
        int deckSize = 10; // デッキの枚数
        int card1 = GameUtils.getRandomInt(deckSize + 1);
        int card2 = GameUtils.getRandomInt(deckSize + 1);
        int total = card1 + card2;

        // カードと合計値を表示
        System.out.println("Cards drawn are " + card1 + " and " + card2 + ", total is " + total + ".");

        return total; // 合計値を返却
    }
}
