import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Pattern;

public class GameUtils {
    private static final String REGEX_ALPHABET = "^[A-Za-z]{4,12}$"; // アルファベットのみで4~12文字

    private GameUtils() {

    }

    public static String getInputString() {

        String input = null; // 入力された文字列を格納する変数

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // System.out.print("文字列を入力してください");

            input = br.readLine(); // ユーザーからの入力を代入する

        } catch (IOException e) {
            System.out.println("Does not match condition of the username");
            return getInputString();
        }

        return input;

    }

    public static int getInputInt() {

        System.out.print("値を入力してください");
        int input = 0;

        try {
            String inputString = getInputString();
            input = Integer.parseInt(inputString);

        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer!");
            return getInputInt();
        }
        return input;
    }

    public static int getRandomInt(int maxValue) {

        Random random = new Random();

        return random.nextInt(maxValue);

    }

    public static boolean checkPattern(String targetStr) {
        if (targetStr == null || targetStr.isEmpty()) {
            return false;
        }

        return Pattern.matches(REGEX_ALPHABET, targetStr);

    }

}