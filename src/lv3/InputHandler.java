package lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class InputHandler<T extends Number> {

    private static final String EXIT_COMMAND = "exit";
    private final BufferedReader br;
    private final Function<String, T> converter;

    public InputHandler(BufferedReader br, Function<String, T> converter) {
        this.br = br;
        this.converter = converter;
    }

    // 입력값 읽기 및 exit 처리
    public String readInput() throws IOException {
        String input = br.readLine().trim();
        if (input.equalsIgnoreCase(EXIT_COMMAND)) {
            System.out.println("계산기가 종료되었습니다.");
            System.exit(0);
        }
        return input;
    }

    // 양의 숫자를 입력받음 (정수, 실수 모두 지원)
    public T getValidNumber(String prompt) throws IOException {
        T number;
        while (true) {
            System.out.print(prompt);
            try {
                number = converter.apply(this.readInput());
                break;
            } catch (NumberFormatException e) {
                System.out.println("\n! 숫자를 입력해주세요 !\n");
            }
        }
        return number;
    }

    // 올바른 사칙연산 기호 입력받기
    public OperatorType getValidOperator(String prompt) throws IOException {
        OperatorType op = null;
        while(op == null) {
            System.out.print(prompt);
            op = OperatorType.findByOperator(this.readInput());
        }

        return op;
    }

    // Y/N 입력받기
    public boolean isYes(String prompt) throws IOException {
        String input = "";
        while(!"Y".equalsIgnoreCase(input) && !"N".equalsIgnoreCase(input)) {
            System.out.print(prompt);
            input = this.readInput();
        }

        if ("Y".equalsIgnoreCase(input)) {
            return true;
        }

        return false;
    }

}