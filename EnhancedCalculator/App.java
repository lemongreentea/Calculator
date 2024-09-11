import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();
            System.out.print("사칙연산 기호를 입력하세요 ( +, -, *, / ) or 'exit' to stop: ");
            String input = sc.next();
            if (input.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            char operatorChar = input.charAt(0);
            OperatorType operator = OperatorType.fromChar(operatorChar);

            try {
                Double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("현재 저장된 결과들: " + calculator.getResults());

            System.out.print("특정 값보다 큰 결과를 조회하시겠습니까? (yes 입력 시 조회): ");
            String queryInput = sc.next();
            if (queryInput.equals("yes")) {
                System.out.print("기준 값을 입력하세요: ");
                double threshold = sc.nextDouble();
                List<Double> filteredResults = calculator.getResultsGreaterThan(threshold);
                System.out.println("기준 값보다 큰 결과들: " + filteredResults);
            }

            System.out.println("첫 번째 결과를 삭제하시겠습니까? (yes 입력 시 삭제)");
            String removeInput = sc.next();
            if (removeInput.equals("yes")) {
                calculator.removeResult();
                System.out.println("첫 번째 결과가 삭제되었습니다.");
                System.out.println("현재 저장된 결과들: " + calculator.getResults());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        }
    }
}
