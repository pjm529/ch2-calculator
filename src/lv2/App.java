package lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        // 사칙연산 기호 List
        List<String> operatorList = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        List<String> ynList = new ArrayList<>(Arrays.asList("Y", "N", "y", "n"));
        Calculator calculator = new Calculator();

        // 입력기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String exitStr = "";
        int num1, num2, i, result;
        String operator, resultYn, removeYn;

        System.out.println("계산기를 시작합니다.");

        while (!exitStr.equals("exit")) { // exit 를 입력받을 때 까지 실행
            try {
                num1 = -1;
                num2 = -1;

                while (num1 < 0) { // 양의 정수를 입력 받을 때 까지
                    System.out.print("첫번째 양의 정수를 입력해주세요 : ");
                    num1 = Integer.parseInt(br.readLine());
                }

                while (num2 < 0) { // 양의 정수를 입력 받을 때 까지
                    System.out.print("두번째 양의 정수를 입력해주세요 : ");
                    num2 = Integer.parseInt(br.readLine());
                }

                operator = "";
                while (!operatorList.contains(operator)) { // 올바른 사칙연산 기호를 입력 받을 때 까지
                    System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");
                    operator = br.readLine().trim();
                }

                // calculator 의 calculate 사용
                calculator.calculate(num1, num2, operator);
                result = calculator.getResult();

                // 결과
                System.out.printf("%d %s %d = %d \n", num1, operator, num2, result);


                resultYn = "";
                while (!ynList.contains(resultYn)) {
                    System.out.print("기존 저장된 결과 값들을 보시겠습니까? (Y/N) : ");
                    resultYn = br.readLine().trim();
                }

                i = 1;
                if (resultYn.toUpperCase().equals("Y")) {
                    for (Result res : calculator.getResultList()) {
                        System.out.println(i++ + ". " + res.toString());
                    }
                }

                removeYn = "";
                while (!ynList.contains(removeYn)) {
                    System.out.print("기존 저장된 결과 값을 삭제하시겠습니까? (Y/N) : ");
                    removeYn = br.readLine().trim();
                }

                if (removeYn.toUpperCase().equals("Y")) {
                    System.out.print("삭제할 결과 번호를 입력하세요 : ");
                    int index = Integer.parseInt(br.readLine());
                    calculator.removeResult(index);
                    System.out.println("결과 값 삭제가 완료되었습니다.");
                }

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
                exitStr = br.readLine().trim();

                System.out.println(); // 개행
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해주세요.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("올바른 사칙연산 기호를 입력해주세요.\n");
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.\n");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("올바른 결과 번호를 입력해주세요.\n");
            }
        }
        System.out.println("계산기가 종료되었습니다.");
        br.close();
    }
}

