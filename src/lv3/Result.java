package lv3;

public class Result<T extends Number & Comparable<T>> {
    private final T num1;
    private final T num2;
    private final T result;
    private final OperatorType operatorType;

    public Result(T num1, T num2, T value, OperatorType operatorType) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = value;
        this.operatorType = operatorType;
    }

    public T getNum1() {
        return num1;
    }

    public T getNum2() {
        return num2;
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return num1 + " " + operatorType.getOperator() + " " + num2 + " = " + result;
    }

}