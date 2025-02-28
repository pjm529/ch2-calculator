package lv3;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    // 제네릭 메서드를 통해 NumberOperator 를 활용하여 연산 수행
    public <T extends Number> T apply(T num1, T num2, NumberOperator<T> op) {

        // OperatorType 에 맞는 계산 함수 실행
        return switch (this) {
            case ADD -> op.add(num1, num2);
            case SUBTRACT -> op.subtract(num1, num2);
            case MULTIPLY -> op.multiply(num1, num2);
            case DIVIDE -> op.divide(num1, num2);
        };
    }
}