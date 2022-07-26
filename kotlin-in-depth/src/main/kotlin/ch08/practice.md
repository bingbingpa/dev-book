# 8장 정리 문제

1. 코틀린에서 하위 클래스를 어떻게 정의하는가? 클래스를 상속할 수 있게 만들려면 어떤 조건을 만족시켜야 하는가?

    - 클래스를 정의하면서 주생성자 뒤에 : 을 넣고 그 뒤에 상위 클래스가 될 클래스의 이름을 넣으면 된다.
    - 어떤 클래스를 상속하려면 대상 클래스에 open 키워드를 붙여야 한다.

2. 자바와 코틀린 클래스 상속의 차이점을 설명하라.

    - 코틀린 함수와 프로퍼티는 기본적으로 final 이며, 하위 클래스에서 오버라이드하게 허용하려면 open 을 명시해야 한다.
    - 자바에서 메서드나 프로퍼티는 암시적으로 open 이기 때문에 오버라이드를 막으려면 final 변경자를 사용해 이 사실을 명시해야 한다.
    - 코틀린에서는 멤버를 오버라이드하는 경우에 override 키워드를 앞에 붙여야만 한다. 이 키워드를 붙이지 않으면 컴파일러가 오류를 발생시킨다.
    - 자바에서는 @Override 애너테이션을 붙이는 편을 권장하기는 하지만, 오버라이드하는 메서드에 꼭 표시를 하지 않아도 된다.

3. 어떤 클래스가 다른 클래스를 상속할 때, 이 클래스의 인스턴스가 초기화되는 과정을 설명하라.
상위 클래스 초기화를 자바에서는 어떻게 강제하는가? 코틀린의 상위 클래스 초기화 방식과 자바의 방식을 비교하라.

   - 상위 클래스로부터 하위 클래스 순서로 초기화가 진행된다.
   - 자바에서는 생성자 본문에서 super 키워드를 통해 상위 클래스의 생성자를 호출한다. 
   - 코틀린
     - 상위클래스 이름 뒤에 있는 괄호가 생성자 호출을 구성한다.
     - 자식 클래스에서 부생성자를 사용하고 싶다면 위임 호출을 생성자 시그니처 바로 뒤에 위치시켜야 한다. 
     - 이때 super 키워드를 통해 상위 클래스의 생성자를 위임 호출한다.

4. is/as/as? 연산자의 목적을 설명하라. 자바의 타입 체크 및 타입 캐스트와 이들을 비교하라.

   - is 연산자는 왼쪽 피연산자가 오른쪽에 주어진 타입인 경우 true 를 반환한다.
   - is 나 !is 연산자의 왼쪽 피연산자와 정적 타입이 오른쪽에 오는 타입의 상위 타입인 경우에만 두 연산자를 사용할 수 있다.
   - 자바의 instanceof 연산자는 null 에 대해 항상 false 를 반환하지만, is 의 결과는 연산자 오른쪽에 있는 타입이 널이 될 수 있는지 여부에 따라 결과가 달라진다.
     - null 값은 모든 널이 될 수 있는 타입의 인스턴스로 간주되지만, 모든 널이 될 수 없는 타입의 인스턴스는 아닌 것으로 간주된다.
   - as/as? 는 스마트 캐스트를 쓸 수 없는 경우에도 명시적인 연산자를 사용해 어떤 값의 타입을 강제로 변환 할 수 있다.
     - 객체의 실제 타입이 변환하려는 대상 타입과 일치하지 않을 때 as 는 예외를 던지지만 as? 는 null 을 돌려준다.
     - 자바에서는 캐스팅을 해도 항상 널로 남지만, 코틀린에서는 대상 타입의 널 가능성에 따라 예외가 발생할 수도 있고 널이 될수도 있다.

5. Any 클래스에 정의된 공통 메서드 이름을 나열하라. 각 메서드를 구현할 때 지켜야 할 기본 지침을 설명하라.

    - equals(), hashCode(), toString()
    - equals() 의 요구 사항
      - 널이 아닌 객체가 널과 같을 수 없다.
      - 동등성 연산은 반사적이어야 한다. 즉, 모든 객체는 자기 자신과 동등해야 한다.
      - 동등성 연산은 대칭적이어야 한다. 즉, a == b 이면 b == a 여야 한다.
      - 동등성 연산은 추이적이어야 한다. 즉, a == b 이고 b == c 이면 a == c 여야 한다.

6. 추상 클래스와 추상 클래스 멤버란 무엇인가? 추상 클래스나 추상 클래스 멤버를 처리하는 규칙은 무엇인가?

    - 추상클래스는 직접 인스턴스화할 수 없고 다른 클래스의 상위 클래스 역할만 할 수 있는 클래스
    - 추상 멤버는 타입, 파라미터, 반환 타입 등 함수나 프로퍼티의 기본적인 모습을 정의하지만 세부 구현을 생략한 멤버다.
    - 비추상 클래스가 추상적인 부모 클래스로부터 이런 멤버를 상속할 때는 반드시 멤버를 오버라이드해서 구현을 제공해야 한다.

7. 추상 클래스와 인터페이스는 어떤 차이가 있는가? 코틀린과 자바 인터페이스를 비교하라.

    - 추상 클래스와 달리 인터페이스에 대한 생성자는 금지돼 있다.
    - 인터페이스는 다중 상속을 할 수 있다. 
    - 자바의 인터페이스는 implements 키워드를 쓰지만, 코틀린에서는 모든 상속을 똑같은 기호(:)를 사용해 표시한다.

8. 인터페이스 상속을 어떤 식으로 하는지 설명하라. 클래스 멤버를 오버라이딩할 때와 인터페이스 멤버를 오버라이딩할 때는 어떤 차이가 있는지 설명하라.

    - 인터페이스 멤버를 상속해 구현할 때 override 키워드를 추가해야 한다.
    - 인터페이스의 구현은 암시적으로 열려 있는 것으로 간주된다. 따라서 상속하는 클래스에서 이런 멤버를 오버라이드 할 수 있다. 
    - 클래스의 멤버를 오버라이드 하기 위해서는 해당 멤버가 open 이어야 한다.

9. 봉인된 클래스 계층은 무엇인가? 자바를 사용한다면 봉인된 클래스 계층을 어떤 식으로 상속 할 수 있겠는가?

    - ???

10. 코틀린에서 클래스 위임이 어떻게 작동하는지 설명하라.

    - 상위 인터페이스 이름 바로 뒤에 by 키워드를 붙이고 그 다음에 위임할 인스턴스를 쓰면 된다.
    - 클래스는 인터페이스 멤버를 구현할 때만 위임을 쓸 수 있다.