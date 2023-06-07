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

    public void execute() {

        List<Integer> cardList = new ArrayList<Integer>();
        cardList = getCard(cardList);
        System.out.println(cardList);

        cardList = getCard(cardList);
        System.out.println(cardList);
        boolean result = judgeCard(cardList, true); // 第二引数は「High」を選択した状態
        System.out.println(result);

    }

    private List<Integer> getCard(List<Integer> cardList) {

        List<List<Integer>> setDeck = new ArrayList<List<Integer>>();
        List<Integer> onePair = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

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

        return cardList;
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
                    *   勝ちとなり、trueを返却する
                    * [A] < [B]の場合
                    *   負けとなり、falseを返却する
                    */
           boolean flg = (lastCard > penultimateCard) ? true : false; // ここが基準
           if (pickChoice == flg) {
           return true;
           }
           return false;
           }

}