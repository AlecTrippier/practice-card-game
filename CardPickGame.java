public class CardPickGame{

    private int maxBetCoin = 100; //最大ベット枚数
    private int deckSetCount = 2; //カードセット数
    private int possessionCoin ; //所持コイン数

    public CardPickGame(int possessionCoin) {
        this.possessionCoin = possessionCoin;
        execute();
    }

    public int getCard() {
        int deckSize = deckSetCount * 10; // デッキの枚数
        int card1 = GameUtils.getRandomInt(deckSize + 1);
        int card2 = GameUtils.getRandomInt(deckSize + 1);
        int total = card1 + card2;

        //カードと合計値を表示
        System.out.println("Cards drawn are " + card1 + " and " + card2 + ", total is " + total + ".");

        return total; //合計値を返却
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
        int total = getCard();
        judgeCard(total);
    }

}