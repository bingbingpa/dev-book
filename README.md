study-modern-java

## ch03 람다 표현식

- 람다 표현식은 익명 함수의 일종이다. 이름은 없지만, 파라미터 리스트, 바디, 반환 형식을 가지며 예외를 던질 수 있다. 
- 함수형 인터페이스는 하나의 추상 메서드만을 정의하는 인터페이스이다.
- 재네릭 파라미터에는 참조형만 사용할 수 있다. 
- 기본형을 참조형으로 변환하는 기능을 박싱. 참조형을 기본형으로 변한하는 반대 동작을 언박싱. 박싱과 언방식이 자동으로 이루어지는 오토박싱.
- **람다 표현식은 한 번만 할당할 수 있는 지역 변수를 캡처할 수 있다.**
- 자바 컴파일러는 람다 표현식이 사용된 콘텍스트를 활용해서 람다의 파라미터 형식을 추론한다. 

## ch06 스트림으로 데이터 수집 

- Collection : 데이터의 집합, 그룹을 의미하며 크게 List, Set, Queue 3가지 상위 인터페이스로 분류 할 수 있다. 그리고 여기에 Collection 인터페이스를 상속받고 있지 않지만 Map도 Collection으로 분류 된다.
- Collect : Collector를 매개변수로 하는 스트림의 최종 연산
- Collector : collect에서 필요한 메서드를 정의해 놓은 인터페이스 
- Collectors 클래스는 다양한 기능의 Collector를 구현한 클래스를 제공한다.
	- 변환 : mappring(), toList(), toSet(), toMap(), toCollection(), .... 
	- 통계 : counting(), summingInt(), averagingInt(), maxBy(), minBy(), summarizingInt(), ...
	- 문자열 결합 : joining()
	- 리듀싱 - reducing()
	- 그룹화와 분할 : groupingBy(), partitioningBy(), collectingAndThen()
	
- **collect와 reduce의 차이점** : collect 메서드는 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 메서드인 반면 reduce는 두 값을 하나로 도출하는 불변형 연산이다. 가변 컨테이너 관련 작업이면서 병렬성을 확보하려면 collect 메서드로 리듀싱 연산을 구현하는 것이 바람직하다. 
 
 
