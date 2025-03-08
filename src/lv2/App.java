package lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    // 상수로 문자열 관리
    private static final String EXIT_COMMAND = "exit";
    private static final List<String> OPERATOR_LIST = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    private static final List<String> YN_LIST = new ArrayList<>(Arrays.asList("Y", "N", "y", "n"));

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("계산기를 시작합니다.");
            System.out.println("계산기는 exit 입력 시 종료됩니다.");


            while (true) {
                try {
                    int num1 = getPositiveInteger(br, "첫번째 양의 정수를 입력해주세요 : ");
                    int num2 = getPositiveInteger(br, "두번째 양의 정수를 입력해주세요 : ");
                    String operator = getValidOperator(br);

                    // calculator 의 calculate 사용
                    calculator.calculate(num1, num2, operator);
                    int result = calculator.getResult();
                    System.out.printf("%d %s %d = %d \n", num1, operator, num2, result);

                    String resultYn = getYesNoInput(br, "기존 저장된 결과 값들을 보시겠습니까? (Y/N) : ");
                    if (resultYn.equalsIgnoreCase("Y")) {
                        int i = 1;
                        for (Result res : calculator.getResultList()) {
                            System.out.println(i++ + ". " + res.toString());
                        }
                    }

                    String removeYn = getYesNoInput(br, "기존 저장된 결과 값을 삭제하시겠습니까? (Y/N) : ");
                    if (removeYn.equalsIgnoreCase("Y")) {
                        while (true) {
                            System.out.print("삭제할 결과 번호를 입력하세요 : ");
                            int index = Integer.parseInt(readInput(br));
                            int resultSize = calculator.getResultList().size();

                            if (index <= 0 || index > resultSize) {
                                System.out.println("\n! 올바른 결과 번호를 입력해주세요 !\n");
                                continue;
                            }
                            calculator.removeResult(index);
                            System.out.println("결과 값 삭제가 완료되었습니다.");
                            break;
                        }
                    }

                    String continueYn = getYesNoInput(br, "계속 계산하시겠습니까? (Y/N) : ");
                    if (continueYn.equalsIgnoreCase("N")) {
                        break;
                    }

                    System.out.println(); // 개행 처리
                } catch (NumberFormatException e) {
                    System.out.println("\n! 정수를 입력해주세요 !\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("\n! 올바른 사칙연산 기호를 입력해주세요 !\n");
                } catch (ArithmeticException e) {
                    System.out.println("\n! 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다 !\n");
                }
            }
            System.out.println("계산기가 종료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 입력을 읽고, exit 입력 시 프로그램 종료
    private static String readInput(BufferedReader br) throws IOException {
        String input = br.readLine().trim();
        if (input.equalsIgnoreCase(EXIT_COMMAND)) {
            System.out.println("계산기가 종료되었습니다.");
            System.exit(0);
        }
        return input;
    }

    // 양의 정수를 입력받는 메서드 (exit 입력 가능)
    private static int getPositiveInteger(BufferedReader br, String prompt) throws IOException {
        int number = -1;
        while (number < 0) {
            System.out.print(prompt);
            String input = readInput(br);
            try {
                number = Integer.parseInt(input);
                if (number < 0) {
                    System.out.println("\n! 양의 정수를 입력해주세요 !\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n! 양의 정수를 입력해주세요 !\n");
            }
        }
        return number;
    }

    // 올바른 사칙연산 기호를 입력받는 메서드 (exit 입력 가능)
    private static String getValidOperator(BufferedReader br) throws IOException {
        String operator = "";
        while (!OPERATOR_LIST.contains(operator)) {
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");
            operator = readInput(br);
        }
        return operator;
    }

    // Y/N 입력을 받는 메서드 (exit 입력 가능)
    private static String getYesNoInput(BufferedReader br, String prompt) throws IOException {
        String input = "";
        while (!YN_LIST.contains(input)) {
            System.out.print(prompt);
            input = readInput(br);
        }
        return input;
    }
}
