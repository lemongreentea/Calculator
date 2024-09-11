import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<T> results = new ArrayList<>();

    public T calculate(T num1, T num2, OperatorType operator) {
        double result = 0;

        switch (operator) {
            case ADD:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case SUBTRACT:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                if (num2.doubleValue() == 0) {
                    throw new ArithmeticException("나눗셈에서 분모는 0일 수 없습니다.");
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
        }

        T finalResult = (T) Double.valueOf(result);
        results.add(finalResult);
        return finalResult;
    }

    public List<T> getResults() {
        return new ArrayList<>(results);
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.removeFirst();
        }
    }

    public List<T> getResultsGreaterThan(T value) {
        return results.stream()
                .filter(result -> result.doubleValue() > value.doubleValue())
                .toList();
    }
}
