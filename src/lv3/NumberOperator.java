package lv3;

// 제너릭을 활용한 인터페이스
public interface NumberOperator<T extends Number> {
    T add(T num1, T num2);

    T subtract(T num1, T num2);

    T multiply(T num1, T num2);

    T divide(T num1, T num2);
}
