study-modern-java
## ch02 동작 파라미터화 코드 전달하기 
- **동작 파라미터화(behavior parameterization)** : 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블을 의미한다. 즉 메서드가 다양한 동작을 받아서 내부적으로 다양한 동작을 수행 할 수 있다.록
- 동작 파라미터화를 통해 탐색 로직과 각 항목에 적용할 동작을 분리 할 수 있다. 
- 파라미터로 메서드 참조를 넘길 수 있다 . Apple::test 같은 형태로(Apple 클래스의 test 함수를 파라미터로 사용)
- 인터페이스를 구현한 클래스를 파라미터로 사용. ApplePredicate 인터페이스를 구현한 클래스를 new 형태로 해서 넘긴다.
    - 예) List<Apple> greenApples = filter(inventory, new AppleColorPredicate());
- 람다를 사용 할 수 있다. 
    - 예) List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

## ch03 람다(lambda) 표현식

- 람다 표현식은 메서드로 전달할 수 있는 익명 함수를 단순화한 것이라고 할 수 있다. 
- 람다 표현식은 익명 함수의 일종이다. 이름은 없지만, 파라미터 리스트, 바디, 반환 형식을 가지며 예외를 던질 수 있다. 
- 함수형 인터페이스를 인수로 받는 메서드에만 람다 표현식을 사용할 수 있다.
- 함수형 인터페이스는 하나의 추상 메서드만을 정의하는 인터페이스이다.
- 재네릭 파라미터에는 참조형만 사용할 수 있다. 
- 기본형을 참조형으로 변환하는 기능을 박싱. 참조형을 기본형으로 변한하는 반대 동작을 언박싱. 박싱과 언방식이 자동으로 이루어지는 오토박싱.
- **람다 표현식은 한 번만 할당할 수 있는 지역 변수를 캡처할 수 있다.**
- 자바 컴파일러는 람다 표현식이 사용된 콘텍스트를 활용해서 람다의 파라미터 형식을 추론한다.
- @FunctionalInterface는 함수형 인터페이스임을 가르키는 어노테이션이다. @FunctionalInterface로 인터페이스를 선언했지만 실제로 함수형 인터페이스가 아니면 컴파일러가 에러를 발생시킨다.  
- 함수형 인터페이스의 추상 메서드는 람다 표현식의 시그니처를 묘사하고 함수형 인터페이스의 추상 메서드 시그니처를 **함수 디스크립터(function descriptor)**라고 한다.
- 많은 디폴트 메서드가 있더라도 **추상 메서드가 오직 하나면** 함수형 인터페이스다.
- 메서드 참조는 특정 람다 표현식을 축약한 것이라고 생각하면 된다. 
    - 예) inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())); 
    - 메서드 참조로 변경 : inventory.sort(comparing(Apple::getWeight));
- Predicate 인터페이스는 복잡한 프레디케이트를 만들 수 있도록 negate(반전), and, or 세 가지 메서드를 제공한다. 
- Function 인터페이스는 Function 인스턴스를 반환하는 andThen, compose 두 가지 디폴트 메서드를 제공한다. 
    - andThen : 주어진 함수를 먼저 적용한 결과를 다른 함수의 입력으로 전달하는 함수를 반환한다.
        - 예) Function<Integer, Integer> f = x -> x + 1;
        - Function<Integer, Integer> g = x -> x * 2;
        - Function<Integer, Integer> h = f.andThen(g); 
        - int result = h.apply(1); (4를 반환)
    - compose : 인수로 주어진 함수를 먼저 실행한 다음에 그 결과를 외부 함수의 인수로 제공한다. 
        - 위 예제코드 결과에서 f.compose(g); 를 할경우 3을 반환 
 
## ch04 스트림 
- **스트림**은 자바 8 API에 새로 추가된 기능이다. 스트림을 이용하면 선언형(즉, 데이터를 처리하는 임시 구현 코드 대신 질의로 표현)으로 컬렉션 데이터를 처리할 수 있다. 
- filter : 람다를 인수로 받아 스트림에서 특정 요소를 제외시킨다. 
- map : 람다를 이용해서 한 요소를 다른 요소로 변환하거나 정보를 추출한다. 
- limit : 정해진 개수 이상의 요소가 스트림에 저장되지 못하게 스트림 크기를 축소 truncate 한다. 
- collect : 다양한 변환 방법을 인수로 받아 스트림에 누적된 요소를 특정 결과로 변환시킨다.  
- **스트림은 단 한 번만 소비할 수 있다.**
- 컬렉션은 현재 자료구조가 포함하는 모든 값을 메모리에 저장하는 자료구조다. 즉, 컬렉션의 모든 요소는 컬렉션에 추가하기 전에 계산되어야 한다. 
- 스트림은 이론적으로 요청할 때만 요소를 계산하는 고정된 자료구조다. 

## ch05 스트림 활용 
- filter 메서드는 프레디케이트(불리언을 반환하는 함수)를 인수로 받아서 프레디케이트와 일치하는 모든 요소를 포함하는 스트림을 반환한다. 
- distinct 메서드는 고유 요소로 이루어진 스트림을 반환하는데, 고유 여부는 스트림에서 만든 객체의 hashCode, equals 로 결정된다. 
- 자바9에 추가된 takeWhile, dropWhile 
    - takeWhile : 특정한 엘리먼트까지 왔다면 멈추고 그 엘리먼트까지 반환한다. 
    - dropWhile : takeWhile 과 반대개념으로, 프레디케이트가 거짓이 되면 그 지점에서 작업을 중단하고 남은 모든 요소를 반환한다. 
- skip : 처음 n개 요소를 제외한 스트림을 반환한다. 
- flatMap : Array 나 Object 로 감싸져 있는 모든 원소를 단일 원소 스트림으로 반환해준다.
- 검색과 매칭 API : allMatch, anyMatch, noneMatch, findFirst, findAny 
- reduce : 모든 스트림 요소를 처리해서 값으로 도출한다. 

## ch06 스트림으로 데이터 수집 

- Collection : 데이터의 집합, 그룹을 의미하며 크게 List, Set, Queue 3가지 상위 인터페이스로 분류 할 수 있다. 그리고 여기에 Collection 인터페이스를 상속받고 있지 않지만 Map도 Collection으로 분류 된다.
- collect() : Collector 를 매개변수로 하는 스트림의 최종연
- Collector : collect에서 필요한 메서드를 정의해 놓은 인터페이스 
- Collectors 클래스는 다양한 기능의 Collector를 구현한 클래스를 제공한다.
	- 변환 : mapping(), toList(), toSet(), toMap(), toCollection(), .... 
	- 통계 : counting(), summingInt(), averagingInt(), maxBy(), minBy(), summarizingInt(), ...
	- 문자열 결합 : joining()
	- 리듀싱 - reducing()
	- 그룹화와 분할 : groupingBy(), partitioningBy(), collectingAndThen()
- **가변 컨테이너 관련 작업이면서 병렬성을 확보하려면 stream.reduce 보다 collect 메서드로 리듀싱 연산을 구현하는 것이 바람직하다.**
- **collect와 reduce의 차이점** : collect 메서드는 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 메서드인 반면 reduce는 두 값을 하나로 도출하는 불산변형 연산이다. 가변 컨테이너 관련 작업이면서 병렬성을 확보하려면 collect 메서드로 리듀싱 연산을 구현하는 것이 바람직하다.
- 그룹화 
    - 그룹화 함수가 반환하는 키 그리고 각 키에 대응하는 스트림의 모든 항목 리스트를 값으로 갖는 맵이 반환된다. 
    - 일반적인 분류 함수와 컬렉터를 인수로 받는다. 
        - 예) Map<Dish.Tpye, List<Dish>> caloricDishesByType = menu.stream().collect(groupingBy(**Dish::getType**, **filtering(dish -> dish.getCalories() > 500, toList())**));
    - collectingAndThen : 적용할 컬렉터와 변환 함수를 인수로 받아 다른 컬렉터를 반환한다.
 
