public class ExeTest {

    public static void main(String[] args) {
        String inputString = GameUtils.getInputString();
        int inputInt = GameUtils.getInputInt();
        int randomInt = GameUtils.getRandomInt(5);
        boolean result = GameUtils.checkPattern("test");
        System.out.println(inputString);
        System.out.println(inputInt);
        System.out.println(randomInt);
        System.out.println(result);
    }

}
