import java.util.Scanner;

abstract class AbstractOperation {
    public abstract double operate(int  firstNumber, int  secondNumber);
}
class AddOperation  extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
class SubtractOperation  extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
class MultiplyOperation  extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
class DivideOperation  extends AbstractOperation {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) firstNumber / secondNumber;
    }
}

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        while (true) {
            try {
                Parser parser = new Parser();
                Scanner scanner = new Scanner(System.in);

                System.out.println("첫번째 숫자를 입력해주세요!");
                String firstInput = scanner.nextLine();
                parser.parseFirstNum(firstInput);

                System.out.println("연산자를 입력해주세요!");
                String operator = scanner.nextLine();
                parser.parseOperator(operator);

                System.out.println("두번째 숫자를 입력해주세요!");
                String secondInput = scanner.nextLine();
                parser.parseSecondNum(secondInput);

                System.out.println("연산 결과 : " + parser.executeCalculator());
                calculator.getResults().add(parser.executeCalculator());

                System.out.println("첫 번째 결과를 삭제하시겠습니까? (yes 입력 시 삭제)");
                String removeInput = scanner.nextLine();
                if (removeInput.equals("yes")) {
                    calculator.removeResult();
                    System.out.println("첫 번째 결과가 삭제되었습니다.");
                }
                    System.out.println("현재 저장된 결과들: " + calculator.getResults());

            } catch (BadInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 에러가 발생했습니다: " + e.getMessage());
            }
        }

    }

}
