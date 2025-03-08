# 스파르타 내임배움캠프 계산기 프로젝트

---

## 차례

#### [과제 내용](#과제-내용)  
#### [프로젝트 개요](#프로젝트-개요)  
#### [주요 기능](#주요-기능)
#### [디렉토리 구조](#디렉토리-구조)

---

## 사용언어
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## 개발환경
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![Badge](http://img.shields.io/badge/-Github-%23181717?style=for-the-badge&logo=GitHub&logoColor=white)

---

## 과제 내용
### Lv1.
- **양의 정수(0 포함)를 입력받기**
    - Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있음
    - 양의 정수는 각각 하나씩 전달 받음
    - 양의 정수는 적합한 타입으로 선언한 변수에 저장


- **사칙연산 기호(➕, ➖, ✖️, ➗)를 입력받기**
    - Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있음
    - 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장 (예: `charAt(0)`)


- **연산 수행 및 결과 출력**
    - 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
    - 키워드: `if`, `switch`
    - 사칙연산 기호에 맞는 연산자를 사용하여 연산 진행
    - 입력받은 연산 기호를 구분하기 위해 제어문 사용
    - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력  
      예: "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."


- **반복문을 사용하여 무한 계산 진행**
    - 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
    - 키워드: "무한으로 반복", "수정"  
      (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
    - 반복문을 사용 (예: `for`, `while` …)

### Lv2.
- **Calculator 클래스 구현**
    - 사칙연산을 수행한 후, 결과값을 반환하는 메서드를 구현
    - 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성


- **App 클래스 수정**
    - Lv1에서 구현한 App 클래스의 main 메서드에서 Calculator 클래스가 활용될 수 있도록 수정
    - 연산 수행 역할은 Calculator 클래스가 담당하고, 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됨
    - 수정 후에도 기존 Lv1의 기능들이 동일하게 동작해야 함


- **캡슐화**
    - App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하는 컬렉션 필드에 직접 접근하지 못하도록 수정
    - 간접 접근을 위해 Getter 메서드를 구현 (필드 값을 가져오기 위해)
    - 필요 시 Setter 메서드를 구현 (필드 값을 수정하기 위해)


- **결과 삭제 기능**
    - Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현
    - App 클래스의 main 메서드에서 삭제 메서드를 활용할 수 있도록 수정
    - 키워드: 컬렉션
        - 컬렉션에 값을 넣고 제거하는 방법을 이해하는 것이 중요


### Lv3.
- **연산자 타입 관리 및 제네릭 확장**
    - 현재 사칙연산 계산기는 (➕,➖,✖️,➗) 4가지 연산 타입으로 구성됨
    - **Enum 타입**을 활용하여 연산자 타입에 대한 정보를 관리
        

- **ArithmeticCalculator 클래스 제네릭화**
    - 기존 양의 정수를 처리하던 ArithmeticCalculator를 제네릭을 활용하여 다양한 타입(예: double)도 지원하도록 수정
    - 단순히 Int 타입을 double 타입으로 바꾸는 것이 아니라, 제네릭을 통해 여러 피연산자 타입을 받을 수 있도록 기능 확장


- **람다 & 스트림을 활용한 결과 조회 기능**
    - 저장된 연산 결과들 중, Scanner로 입력받은 값보다 큰 결과값들을 출력하는 조회 메서드를 구현
    - Lambda와 Stream을 활용하여, 입력된 검색 값보다 큰 결과만 필터링
     

- **추가적으로 수정이 필요한 다른 클래스나 메서드**
    - 피연산자 타입을 제네릭으로 처리하기 위해, 관련 클래스(예: Result, NumberOperator, InputHandler 등)도 제네릭 타입을 적용하여 수정해야 함
---
## 프로젝트 개요

### Lv1
- **기본 기능**:
    - 양의 정수 2개와 사칙연산 기호(+, -, *, /)를 입력받아 연산 수행
    - BufferedReader를 사용하여 입력 처리
    - 입력 검증 및 예외 처리 (정수 입력, 올바르지 않은 연산 기호, 0으로 나누기 등)
    - “exit” 입력 시 계산 종료

### Lv2
- **객체지향 개념 적용**:
    - `Calculator` 클래스를 도입해 연산 로직과 결과 저장 기능을 분리
    - 결과는 `Result` 객체로 관리되며, 리스트에 저장되고 삭제 기능도 제공
    - 캡슐화를 통해 외부에서 결과 리스트에 직접 접근하지 않고, getter/setter를 통해 간접 접근하도록 구현

### Lv3
- **최신 자바 기능 적용**:
    - **제네릭**: Double, Integer 등 다양한 Number 타입 지원
    - **Enum (OperatorType)**: 사칙연산 기호를 Enum으로 관리하여 올바른 연산 매핑
    - **람다 & 스트림**: 람다 표현식으로 간결한 파싱 및 연산 구현, 스트림 API로 결과 검색 기능 구현
    - **모듈화**: 각 기능(입력 처리, 계산, 결과 관리)을 별도 클래스에서 처리하여 유지보수 및 확장 용이

---

## 주요 기능

- **다양한 타입 지원**: 제네릭을 활용해 Double뿐 아니라 다양한 Number 타입 지원
- **Enum을 통한 연산 처리**: OperatorType Enum을 사용하여 연산 기호 관리 및 올바른 연산 매핑
- **람다 & 스트림**: 람다 표현식을 통해 파싱 및 연산 구현, 스트림 API로 결과 검색 기능 구현
- **모듈화**: 각 기능(입력, 계산, 결과 관리)을 별도 클래스에서 처리하여 유지보수 및 확장 용이

---

## 디렉토리 구조
``` plaintext
src/
├── lv1/
│   └── App.java
├── lv2/
│   ├── App.java
│   ├── Calculator.java
│   └── Result.java
└── lv3/
    ├── App.java
    ├── ArithmeticCalculator.java
    ├── CalculatorController.java
    ├── DoubleOperator.java
    ├── InputHandler.java
    ├── NumberOperator.java
    ├── OperatorType.java
    └── Result.java

```

### 블로그 : [https://pjm529.tistory.com/](https://pjm529.tistory.com/)