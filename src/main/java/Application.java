import domain.Cards;


public class Application {
    public static void main(String[] args) {
        runCase("10,K");      // 예상 결과: 20 (10 + 10)
        runCase("A,9");       // 예상 결과: 20 (11 + 9)
        runCase("2,3,4");     // 예상 결과: 9 (2 + 3 + 4)
    }

    private static void runCase(String testCase) {
        int sum = Cards.from(testCase).calculateSum();
        System.out.println(testCase + " ==> " + sum);
    }
}