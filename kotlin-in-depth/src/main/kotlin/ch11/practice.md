# 11장 정리 문제

1. 연산자 오버로딩이란 무엇이고, 코틀린에서는 어떤 관습을 사용해 연산자 오버로딩을 사용하는가?

    - 연산자 오버로딩은 +, -, *, / 등 코틀린 내장 연산자에 대해 새로운 의미를 부여할 수 있게 해주는 언어 기능이다.

2. 표준 위임 구현을 설명하라.

    - lazy() 함수는 다중 스레드 환경에서 지연 계산 프로퍼티의 동작을 미세하게 제어하기 위해 세 가지 다른 버전을 갖고 있다.
      - LazyThreadSafetyMode 이넘 상수를 통해 세 가지 기본 구현중 하나를 선택할 수 있다.
      - SYNCHRONIZED: 프로퍼티 접근을 동기화한다. 따라서 한번에 한 스레드만 프로퍼티 값을 초기화 할 수 있다(이 구현이 디폴트다).
      - PUBLICATION: 초기화 함수가 여러 번 호출될 수 있지만 가장 처음 도착하는 결과가 프로퍼티 값이 되도록 프로퍼티 접근을 동기화한다.
      - NONE: 프로퍼티 접근을 동기화하지 않는다. 이 방식을 선택한다면 다중 스레드 환경에서 프로퍼티의 올바른 동작을 보장할 수 없다.
    - 초기화 함수가 예외를 던지면 프로퍼티가 초기화 되지 않는다. 이런 경우 프로퍼티에 다시 접근하려 시도하면 또 다시 초기화 함수가 호출된다.
    - kotlin.properties.Delegates 의 표준 위임들
        - notNull()
            - 프로퍼티 초기화를 미루면서 널이 아닌 프로퍼티를 정의할 수 있게 해준다.
            - 의미는 기본적으로 lateinit 프로퍼티와 같다.
            - 보통은 lateinit 쪽이 더 간결하고 성능도 좋다. 하지만 lateinit 은 원시 타입에 적용할 수 없기 때문에 그런 경우에 쓸 수 있다.
        - observable()
            - 프로퍼티 값이 변경될 때 통지를 받을 수 있다.
            - 새 값이 이전 값과 같더라도 통지가 온다. 필요하다면 두 값이 같은지 람다가 직접 검사해야 한다.
        - vetoable()
            - 이 함수는 초깃값과 Boolean 을 반환하는 람다를 인자로 받는다.
            - 프로퍼티 값을 변경하려고 시도할 때마다 값을 변경하기 직전에 이 람다가 호출되고, 람다가 true 를 반환하면 실제 값 변경이 일어난다.
            - 람다가 false 를 반환하면 값이 바뀌지 않고 그대로 남는다.
        - observable() 과 vetoable() 이 제공하는 변경 전과 변경 후 통지를 함께 조합하고 싶다면 ObservableProperty 를 상속해서 beforeChange() 와 afterChange() 함수를 오버라이드하면 된다.

3. 프로퍼티 위임의 관습은 무엇인가? 커스텀 위임 구현의 한 가지 예를 들어보라.

    - 커스텀 위임 만들기
    - 읽기 함수의 이름은 getValue 여야 하고, 다음 두가지 파라미터를 받는다.
        - receiver: 수신 객체 값이 들어있고, 위임된 프로퍼티의 수신 객체와 같은 타입(또는 상위 타입)이어야 한다.
        - property: 프로퍼티 선언을 표현하는 리플렉션이 들어있다. KProperty<*> 이거나 상위 타입이어야 한다.
        - 두 파라미터의 이름은 실제로는 중요하지 않고 타입만 중요하다. getValue() 함수의 반환 타입은 반드시 위임 프로퍼티의 타입과 같아야(또는 하위 타입이어야) 한다.
    - var 프로퍼티에 해당하는 읽고 쓸 수 있는 프로퍼티의 경우, getValue() 외에도 프로퍼티에 값을 저장할 때 호출될 setValue() 함수를 정의해야 한다.
    - 이 함수의 반환 타입은 Unit 이어야 하며, 세가지 파라미터를 받는다.
        - receiver: getValue() 와 동일
        - property: getValue() 와 동일
        - newValue: 프로퍼티에 저장할 새 값이다. 프로퍼티 자체와 같은 타입(또는 상위 타입)이어야 한다.
    - 읽기 전용 커스텀 위임을 정의하고 싶다면 kotlin.properties 패키지의 ReadOnlyProperty 인터페이스를 사용하라.
    - 읽기 쓰기 커스텀 위임을 정의하고 싶다면 kotlin.properties 패키지의 ReadWriteProperty 인터페이스를 사용하라.
    - **getValue() / setValue() 함수를 멤버 함수로 정의할 수도 있지만 확장 함수로 정의해도 된다.**

4. 런타임에 (리플렉션을 써서) 위임 값에 접근하는 방법을 설명하라.

    - 책 452페이지 

5. 고차 함수를 사용해 DSL 을 설계하는 방법을 설명하라.

    - ???

6. @DslMarker 의 의미를 설명하라.

    - 암시적 수신 객체의 영역을 제한할 수 있게 해주는 메타 애너테이션이다.
    - 특정 DSL 을 구분하는 마커 역할을 하는 애너테이션을 정의할 때 쓰인다.
    - this shadowing 을 방지한다.