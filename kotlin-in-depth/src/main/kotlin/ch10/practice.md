# 10장 정리 문제

1. 새로운 애너테이션을 어떻게 정의하는가? 코틀린 애너테이션 구문과 자바 구문을 비교하라.

    - 클래스 앞에 annotation 이라는 변경자를 붙인다.
    - 자바 애너테이션은 인터페이스로 구성되지만, 코틀린 애너테이션은 특별한 종류의 클래스로 구성된다.
    - 일반 클래스와 달리 애너테이션 클래스에는 멤버나 부생성자, 초기화 코드가 없다.
    - 자바와 달리 코틀린 애너테이션을 식에 적용할 수도 있다.

2. 코틀린 코드에 애너테이션을 어떻게 붙일 수 있는가?

    - @구문을 사용한다.
    - 다른 애너테이션을 인자로 사용하는 경우에는 @ 접두사를 안붙여도 된다.

3. 코틀린이 제공하는 내장 애너테이션을 설명하라.

    - @Retention: 애너테이션이 저장되고 유지되는 방식을 제어한다.
    - @Repeatable: 이 애너테이션이 붙은 애너테이션을 같은 언어 요소에 두 번 이상 반복 적용할 수 있다.
    - @MustBeDocumented: 애너테이션을 문서에 꼭 포함시키라는 뜻이다.
    - @Target: 애너테이션을 어떤 언어 요소에 붙일 수 있는지 지정한다.
    - @StrictFp: 부동소수점 연산의 정밀도를 제한해서 여러 다른 플랫폼 간의 부동소수점 연산 이식성을 높여준다.
    - @Synchronized: 애너테이션이 붙은 함수나 프로퍼티 접근자의 본문에 진입하기 전에 모니터(monitor)를 획득하고 본문 수행 후 모니터를 해제하게 한다.
    - @Volatile: 애너테이션이 붙은 뒷받침하는 필드를 변경하는 내용을 즉시 다른 스레드에서 관찰할 수 있게 해준다.
    - @Transient: 애너테이션이 붙은 필드를 직렬화 메커니즘이 무시한다.

4. 애너테이션의 사용 지점 대상은 무엇인가?(애너테이션 정의의) @Target 메타 애너테이션과 사용 지점 대상 사이에는 어떤 연관이 있는가?

    - 디폴트로 코틀린 애터테이션은 RUNTIME 으로 유지 시점이 정의된다.
    - 타겟이 식일 경우에는 애너테이션에 대해 BINARY 나 RUNTIME 을 지정하지 못한다.

5. 코틀린 리플렉션 API 를 구성하는 기본 타입들은 무엇인가?

    - 모든 리플렉션 타입은 KAnnotatedElement 의 자손이다.
    - 타입들: KParameter, KType, KClassifier, KClass\<T>, KTypeParameter, KDeclarationContainer, KCallable\<out R> 

6. 클래스 리터럴과 호출 가능 참조 구문을 설명하라.

    - KClass 타입은 자바 언어의 Class 타입에 해당하는 코틀린 클래스다. 클래스 이름 뒤에 ::class 붙여서 클래스 리터럴을 만든다. 
    - 리플렉션 API 에서는 KCallable\<out R> 이라는 제네릭 인터페이스를 통해 호출 가능 요소를 표현한다.

7. KClass API 를 설명하라. KClass 와 자바의 Class 인스턴스를 어떻게 상호 변환하는가?

   - 자바 클래스 인스턴스를 KClass 로 변환: Class.forName("java.lang.String").kotlin
   - KClass 크래스를 자바 클래스로 변환: String::class.java
   - 대상 클래스에 어떤 변경자가 붙어 있는지를 알아내는 API
   - isAbstract, isCompanion, isData, isFinal, isOpen, isSealed
   - visibility 프로퍼티
      - 가시성 수준을 돌려준다(PUBLIC, PROTECTED, INTERNAL, PRIVATE)
      - 코틀린 소스코드에서 가시성을 표현할 수 없다면 visibility 값이 null 이다.
   - simpleName 프로퍼티: 소스코드에서 사용되는 간단한 이름을 반환한다. 클래스 이름이 없다면 결과는 null 이다.
   - qualifiedName 프로퍼티: 클래스의 전체 이름 조회. 전체 이름에는 클래스가 포함된 패키지의 전체 경로가 들어간다.
   - isInstance() 함수: 주어진 객체가 이 함수의 수신 객체가 표현하는 클래스의 인스턴스인지 알려준다.
   - 멤버 선언에 접근하는 API
      - constructors: 주생성자와 부생성자들을 KFunction 타입의 인스턴스로 돌려준다.
      - members: KCallable 인스턴스로 표현되는 멤버 함수와 프로퍼티 표현의 컬렉션을 돌려준다. 이 컬렉션 안에는 상위 타입에서 상속한 모든 멤버도 함께 포함된다.
      - nestedClasses: 내포된 클래스와 객체들로 이뤄진 컬렉션이다. 동반 객체도 포함된다.
      - typeParameters: KTypeParameter 에 의해 표현되는 타입 파라미터로 이뤄진 리스트다(대상 클래스가 제네릭 타입이 아닌 경우 이 리스트는 빈 리스트다)
   - KClass 가 객체 선언을 표현하는 경우 constructors 프로퍼티는 항상 빈 컬렉션을 반환한다.
      - 실제 인스턴스를 얻고 싶으면 objectInstance 프로퍼티를 사용해야 한다.
      - KClass 인스턴스가 객체를 표현하지 않으면 objectInstance 프로퍼티도 null 이다.
   - supertype 프로퍼티는 클래스가 직접 상속한 상위 타입만 돌려준다.

8. KCallable API 를 설명하라.

   - KCallable 이 제공하는 멤버
   - KClass 와 마찬가지로 어떤 변경자가 붙어있는지 알아 낼 수 있는 프로퍼티들이 존재한다.
      - isAbstract, isFinal, isOpen, isSuspend, visibility
   - 프로퍼티나 함수의 시그니처를 표현하는 프로퍼티가 속한 그룹
      - val name: String
      - val typeParameters: List\<KTypeParameter>
      - val parameters: List\<KParameter>
      - val returnType: KType
   - KParameter 인터페이스는 멤버 및 확장 선언의 수신 객체나 함수/생성자의 파라미터에 대한 정보를 포함한다.
      - index, isOptional, isVararg, name, type, kind
      - isOptional 프로퍼티는 파라미터에 디폴트 값이 있는지 여부를 돌려준다. 하지만 디폴트 값 자체를 알 수는 없다.
      - kind 프로퍼티는 KParameter 인스턴스가 일반적인 값에 해당하는지, 아니면 디스패치나 확장의 수신 객체인지를 알려준다.
         - INSTANCE: 멤버 선언의 디스패치 수신 객체
         - EXTENSION_RECEIVER: 확장 선언의 확장 수신 객체
         - VALUE: 일반적인 값
   - KCallable 에는 이 호출 가능 요소가 표현하는 호출 가능한 선언을 동적으로 호출할 수 있게 해주는 call() 멤버 함수가 들어있다.
      - 함수로부터 만들어진 호출 가능 요소인 경우 call() 은 함수를 호출한다.
      - 호출 가능 요소가 프로퍼티게터라면 게터가 호출된다.
   - KFunction: 함수나 생성자를 표현한다. 함수에 적용 가능한 변경자 검사를 위한 프로퍼티들을 가지고 있다.
      - isInfix, isInline, isOperator, isSuspend