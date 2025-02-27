package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int result;

    private List<Result> resultList = new ArrayList<>();

    public void calculate(int num1, int num2, String operator) {
        // 사칙연산 기호에 따라 분기
        this.result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException(); // 올바르지 않은 값 입력 시
        };

        this.addResult(new Result(num1, num2, operator, this.result));
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void addResult(Result result) {
        resultList.add(result);
    }

    public void removeResult(int index) {
        if (!resultList.isEmpty()) {
            resultList.remove(index - 1);
        }
    }
}
