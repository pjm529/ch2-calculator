package lv3;

// NumberOperator 인터페이스를 상속받아 Double형으로 구현
public class DoubleOperator implements NumberOperator<Double> {

    @Override
    public Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    public Double subtract(Double num1, Double num2) {
        return num1 - num2;
    }

    @Override
    public Double multiply(Double num1, Double num2) {
        return num1 * num2;
    }

    @Override
    public Double divide(Double num1, Double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("\n! 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다 !\n");
        }
        return num1 / num2;
    }
}
