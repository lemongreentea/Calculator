import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public static void validCheck(String input, String regex, String word) throws BadInputException {
        if(input.equals("exit")){
            System.out.println("프로그램을 종료합니다.");
            System.exit(1);
        }else if(!Pattern.matches(regex, input)){
            throw new BadInputException(word);
        }
    }

    public Parser parseFirstNum(String firstInput) throws BadInputException {
        validCheck(firstInput,NUMBER_REG,"숫자");
        calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws BadInputException {
        validCheck(secondInput,NUMBER_REG,"숫자");
        calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws BadInputException {
        validCheck(operationInput,OPERATION_REG,"연산자");

        switch (operationInput) {
            case "+":
                calculator.setOperation(new AddOperation());
                break;
            case "-":
                calculator.setOperation(new SubtractOperation());
                break;
            case "*":
                calculator.setOperation(new MultiplyOperation());
                break;
            case "/":
                calculator.setOperation(new DivideOperation());
                break;
            default:
                throw new BadInputException("연산자");
        }

        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}
