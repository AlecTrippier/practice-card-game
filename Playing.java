public class Playing {

    private static String username = ""; // ユーザー名
    private static int possessionCoin = 1000; // 所持コイン（初期値）

    public static void main(String[] args) {
        System.out.println("Welcome !");
        System.out.println("Enter your username");

        username = GameUtils.getInputString();

        if (!GameUtils.checkPattern(username)) {
            System.out.println("Does not match condition of the username");
            main(args); // ユーザー名入力の処理に戻る
        } else {
            System.out.println("Hello " + username);

            CardPickGame game = new CardPickGame(possessionCoin);
            possessionCoin = execute(game);

            System.out.println(username + " Possession : " + possessionCoin + "Coin");
        }
    }

    private static int execute(CardPickGame game) {
        return game.execute();
    }
}
