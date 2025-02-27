package lv2;

public class Result {
    private int num1;
    private int num2;
    private String operator;
    private int result;

    public Result(int num1, int num2, String operator, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
    }

    @Override
    public String toString() {
        return num1 + " " + operator + " " + num2 + " = " + result;
    }
}
