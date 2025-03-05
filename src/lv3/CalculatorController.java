package lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class CalculatorController<T extends Number & Comparable<T>> {

    private final ArithmeticCalculator<T> calculator;
    private final InputHandler<T> inputHandler;

    // 생성자 주입
    public CalculatorController(Function<String, T> converter, NumberOperator<T> operator) {
        calculator = new ArithmeticCalculator<>(operator);
        inputHandler = new InputHandler<>(new BufferedReader(new InputStreamReader(System.in)), converter);
    }

    public void run() {
        System.out.println("계산기를 시작합니다.");
        System.out.println("계산기는 exit 입력 시 종료됩니다.");

        while (true) {
            try {
                T num1 = inputHandler.getValidNumber("첫번째 숫자를 입력해주세요 : ");
                T num2 = inputHandler.getValidNumber("두번째 숫자를 입력해주세요 : ");
                String operator = inputHandler.getValidOperator("사칙연산 기호를 입력하세요(+, -, *, /) : ");

                // 계산
                calculator.calculate(num1, num2, operator);
                Result<T> result = calculator.getResult();
                System.out.println(result.toString());

                String resultYn = inputHandler.getYesNoInput("기존 저장된 결과 값들을 보시겠습니까? (Y/N) : ");
                if (resultYn.equalsIgnoreCase("Y")) {
                    int i = 1;
                    for (Result<T> res : calculator.getResultList()) {
                        System.out.println(i++ + ". " + res.toString());
                    }
                }

                String removeYn = inputHandler.getYesNoInput("기존 저장된 결과 값을 삭제하시겠습니까? (Y/N) : ");
                if (removeYn.equalsIgnoreCase("Y")) {
                    while (true) {
                        System.out.print("삭제할 결과 번호를 입력하세요 : ");
                        int index = Integer.parseInt(inputHandler.readInput());
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

                String continueYn = inputHandler.getYesNoInput("계속 계산하시겠습니까? (Y/N) : ");
                if (continueYn.equalsIgnoreCase("N")) {

                    String searchYn = inputHandler.getYesNoInput("\n계산 결과 중 입력 받은 값 보다 큰 결과를 검색하시겠습니까? (Y/N) : ");
                    if (searchYn.equalsIgnoreCase("Y")) {
                        T searchValue = inputHandler.getValidNumber("검색할 숫자를 입력해주세요 : ");
                        List<Result<T>> resultList = calculator.getSearchList(searchValue);

                        if (resultList.isEmpty()) {
                            System.out.println("검색 결과가 없습니다.");
                            break;
                        }

                        int i = 1;
                        for (Result<T> res : resultList) {
                            System.out.println(i++ + ". " + res.toString());
                        }
                    }
                    break;
                }
                System.out.println(); // 개행 처리

            } catch (NumberFormatException e) {
                System.out.println("\n! 숫자 형식이 올바르지 않습니다 !\n");
            } catch (IllegalArgumentException e) {
                System.out.println("\n! 올바른 사칙연산 기호를 입력해주세요 !\n");
            } catch (ArithmeticException e) {
                System.out.println("\n! 나눗셈 연산에서 분모(두번째 숫자)에 0이 입력될 수 없습니다 !\n");
            } catch (IOException e) {
                System.out.println("입력 처리 중 오류가 발생했습니다.");
                break;
            }
        }
        System.out.println("계산기가 종료되었습니다.");
    }
}