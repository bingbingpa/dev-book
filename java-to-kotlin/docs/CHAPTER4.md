# CHAPTER 4 옵셔널에서 널이 될 수 있는 타입으로

- 코틀린에서 Optional 을 쓰면 안 되는 한 가지 이유는 널 가능성을 지원하기 위해 구체적으로 설계된 언어 기능을 쓰지 못하게 된다는 점에 있다.
  - 코틀린의 타입 시스템에서 T 는 T? 의 하위 타입이다. 그래서 널이 될 수 없는 String 타입의 값을 이 타입을 널이 될 수 있는 String 이 필요한 곳에 항상 쓸 수 있다.
  - 하지만 자바에서 T 는 Optional\<T> 의 하위 타입이 아니다.
    - String 값을 선택적인 값을 저장하는 변수에 대입하기 위해서는 먼저 Optional 로 String 을 감싸야 한다.
  - 널 가능성을 사용하면 선택적인 값을 선택적이지 않은 값으로 쉽게 변경할 수 있지만, Optional 을 사용하면 아이러니하게도 이런 변경이 쉽지 않다.
- 이터레이션과 for 루프
  - 다음 중 어느 하나에 해당하면 for 루프 사용을 허용한다.
    - Iterable 를 확장한 타입
    - Iterable 를 반환하는 iterator() 메서드를 제공하는 타입
      - 꼭 반환할 필요도 없다. operator fun hasNext(): Boolean 과 operator fun next(): T 를 제공하는 타입이면 된다.
    - Iterable 를 반환하는 T.iterator() 확장 함수가 영역 안에 정의된 T 타입
- 자바 orElseThrow 와 코틀린 !! 는 값을 돌려주지만 값이 없으면 예외를 던진다.
- `takeIf`는 술어가 true 면 수신 객체를 반환하고 true 가 아니면 null 을 반환한다.