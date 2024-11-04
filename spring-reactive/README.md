# 스프링으로 시작하는 리액티브 프로그래밍

- *황정식 지음 | 비제이퍼블릭(BJ퍼블릭)*
- [예제코드](https://github.com/bjpublic/Spring-Reactive/blob/main/README.md)

<br>

### [CHAPTER 01 ~ 03 reactive streams 개념 정리와 spring webMVC 와 webFlux 코드 비교](https://bingbingpa.github.io/reactive-streams/)

### [CHAPTER 05 ~ 06 Reactor 특징과 마블다이어그램](https://bingbingpa.github.io/reactor-marble-diagram/)

### [CHAPTER 07 Cold Sequence 와 Hot Sequence](https://bingbingpa.github.io/cold-sequence-hot-sequence/)

### 📘 스프링으로 시작하는 리액티브 프로그래밍 챕터 8 Backpressure

- Backpressure 란?
  - Backpressure 는 우리말로 배압 또는 역압이라고 한다. 현실 세계의 배압이라는 용어는 배관으로 유입되는 가스나 액체 등의 흐름을 제어하기 위해
    역으로 가해지는 압력을 의미한다.
    - 예를 들면, 콘서트장에 관객들이 줄지어 차례차례 입장할 수 있도록 안전요원들이 관객들을 통제하는 것
  - 리액티브 프로그래밍에서의 배압, 즉 Backpressure 는 콘서트장에서 관객의 입장을 통제하는 안전요원에 비유할 수 있다.
  - **Publisher 가 끊임없이 emit 하는 무수히 많은 데이터를 적절하게 제어하여 데이터 처리에 과부하가 걸리지 않도록 제어하는 것이 Backpressure 의 역할이다.**

- Reactor 에서 제공하는 Backpressure 전략 종류

  | 종류        | 설명                                                                                  |
    |-----------|-------------------------------------------------------------------------------------|
  | IGNORE 전략 | Backpressure 를 적용하지 않는다.                                                            |
  | ERROR 전략  | Downstream 으로 전달할 데이터가 버퍼에 가득 찰 경우, Exception 발생                                    |
  | DROP 전략   | Downstream 으로 전달할 데이터가 버퍼에 가득 찰 경우, 버퍼 밖에서 대기하는 먼저 emit 된 데이터부터 Drop                |
  | LATEST 전략 | Downstream 으로 전달할 데이터가 버퍼에 가득 찰 경우, 버퍼 밖에서 대기하는 가장 최근에(나중에) emit 된 데이터부터 버퍼에 채우는 전략 |
  | BUFFER 전략 | Downstream 으로 전달할 데이터가 버퍼에 가득 찰 경우, 버퍼 안에 있는 데이터 부터 Drop 시키는 전략                     |
