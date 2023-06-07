import java.util.ArrayList;
import java.util.Arrays; // 追加
import java.util.List;

public class HighAndLowGame {

    private int earnedCoinCount; // 獲得コイン枚数
    private int maxWinCoin = 10000; // 最大獲得コイン数
    private int deckSetCount = 1; // カードセット

    public HighAndLowGame(int earnedCoinCount, int deckSetCount) {
        this.earnedCoinCount = earnedCoinCount;
        this.deckSetCount = deckSetCount;
    }

    public int execute() {
        List<Integer> cardList = new ArrayList<>();

        cardList.add(getCard(cardList));

        if (earnedCoinCount >= maxWinCoin) {
            return earnedCoinCount;
        }

        System.out.println("Your winCoin is " + earnedCoinCount);

        System.out.println("Playing High And Low? y / n");
        String choice = GameUtils.getInputString();
        if (choice.equalsIgnoreCase("n")) {
            return earnedCoinCount;
        } else if (!choice.equalsIgnoreCase("y")) {
            System.out.println("Input error...Please retype!");
            return execute();
        }

        System.out.println("High or Low? h / l");
        String guess = GameUtils.getInputString();
        if (!guess.equalsIgnoreCase("h") && !guess.equalsIgnoreCase("l")) {
            System.out.println("Input error...Please retype!");
            return execute();
        }

        cardList.add(getCard(cardList));
        boolean result = judgeCard(cardList, guess.equalsIgnoreCase("h"));

        if (result) {
            earnedCoinCount *= 2;
        } else {
            earnedCoinCount = 0;
        }

        return execute();
    }

    private int getCard(List<Integer> cardList) {
        List<List<Integer>> setDeck = new ArrayList<>();
        List<Integer> onePair = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (int i = 0; i < this.deckSetCount; i++) {
            setDeck.add(i, onePair);
        }

        int cardA;

        while (true) {
            int randNumA1 = GameUtils.getRandomInt(2);
            int randNumA2 = GameUtils.getRandomInt(10);
            cardA = setDeck.get(randNumA1).get(randNumA2);

            int count = 0;
            for (int value : cardList) {
                if (cardA == value) {
                    count++;
                }
            }
            if (count < this.deckSetCount) {
                break;
            }
        }

        cardList.add(cardA);
        int lastIdx = cardList.size() - 1;
        int showValue = cardList.get(lastIdx);

        System.out.println("pick card --" + showValue + "--");

        return cardA;
    }

    private boolean judgeCard(List<Integer> cardList, boolean pickChoice) { // pickChoice → High:true , Low:false

        /**
         * 1. cardListの最後2つの数字を取り出す。
         * 最後の数字を[A], 1つ前を[B]とする
         */
        int num = cardList.size();
        int lastCard = cardList.get(num - 1); //[A]
        int penultimateCard = cardList.get(num - 2); //[B]
        // 2. 結果を判定する
        if (lastCard == penultimateCard) { // [A] = [B]の場合
            // 負けとなり、falseを返却する
            return false;
        }
        /**
         * [A] > [B]の場合
         *   勝ちとなり、trueを返却する
         * [A] < [B]の場合
         *   負けとなり、falseを返却する
         */
        boolean flg = (lastCard > penultimateCard) ? true : false; // ここが基準
        if (pickChoice == flg) {
            return true;
        }
        return false;
    }
}
