import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int firstNumber;
    private int secondNumber;

    private AbstractOperation operation;

    private ArrayList<Integer> results = new ArrayList<Integer>();

    public Calculator(AbstractOperation operation) {
        this.operation = operation;
    }

    public Calculator() {
    }

    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public ArrayList<Integer> getResults() {
        return this.results;
    }

    public void removeResult(){
        if (!results.isEmpty()) {
            this.results.removeFirst();  // 가장 먼저 저장된 데이터를 삭제
        } else {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }

    public double calculate() {
        double answer = 0;
        answer = operation.operate(this.firstNumber, this.secondNumber);
        return answer;
    }

}
