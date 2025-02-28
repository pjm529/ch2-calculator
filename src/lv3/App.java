package lv3;

public class App {
    public static void main(String[] args) {
        // Double 로 구현 상황에 따라 다양한 타입으로 사용 가능
        CalculatorController<Double> controller = new CalculatorController<>(Double::parseDouble, new DoubleOperator());
        controller.run();
    }
}