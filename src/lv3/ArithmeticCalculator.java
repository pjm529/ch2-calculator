package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number & Comparable<T>> {

    // 계산 결과들을 Result 객체로 저장하는 리스트
    private final List<Result<T>> resultList = new ArrayList<>();
    private final NumberOperator<T> numberOperator;

    public ArithmeticCalculator(NumberOperator<T> numberOperator) {
        this.numberOperator = numberOperator;
    }

    /**
     * 두 피연산자와 연산자 기호를 받아 계산 후, 결과를 Result 객체로 저장.
     */
    public void calculate(T num1, T num2, OperatorType opType) {
        // 사칙연산 기호에 맞는 OperatorType 이 없을 경우 Exception
        if (opType == null) {
            throw new IllegalArgumentException("\n! 올바른 사칙연산 기호를 입력해주세요 !\n");
        }

        // 계산
        T value = opType.apply(num1, num2, numberOperator);

        // 계산 결과를 result 객체로 생성 후 add
        Result<T> result = new Result<>(num1, num2, value, opType);
        resultList.add(result);
    }

    // 가장 최근 계산 결과를 반환
    public Result<T> getResult() {
        if (!resultList.isEmpty()) {
            return resultList.get(resultList.size() - 1);
        }
        return null;
    }

    public List<Result<T>> getResultList() {
        return resultList;
    }

    // 사용자에게는 1부터 시작하는 번호로 결과를 삭제
    public void removeResult(int index) {
        resultList.remove(index - 1);
    }

    public List<Result<T>> getSearchList(T searchValue) {
        //  입력된 searchValue 보다 큰 결과들을 반환
        return resultList.stream()
                .filter(res -> res.getResult().compareTo(searchValue) > 0) // compareTo를 활용하여 비교 연산
                .collect(Collectors.toList());
    }
}