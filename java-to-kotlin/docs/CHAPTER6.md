# CHAPTER 6 자바에서 코틀린 컬렉션으로

- 상태 변이는 어떤 장소의 상태가 다른 장소에서 예상하는 상태와 일치하지 않을 수 있으므로 생기는 여러 문제의 근원이다.
- UnmodifiableList 는 원본이 결코 변경되지 않음을 보장하지는 못하며, 래퍼를 통해 변경되지 않도록 보장하는 역할만 할 수 있다.
- 자바 10 에는 컬렉션을 AbstractImmutableList 으로 복사해주는 List.copyOf(collection)이 생겼고, 이렇게 만든 객체는 변경이 불가능하며 원본 컬렉션의 변경과도 무관하다.
- 코틀린에 있는 MutableList 는 List 의 하위 타입이며, List 는 다시 Collection 의 하위 타입이다.
- **공유된 컬렉션을 변경하지 말라!!!**
  - 외부에 노출할때는 불변으로!
  - ~~~kotlin
    private val listA = mutableListOf(0)
    val listB get() = listA as List<Int>
    ~~~
  - 이런 짓은 하지 말자.(다운 캐스팅 하면서 LSP 를 위반한다.)
    - ~~~kotlin
      some.listB as MutableList<Int>
      ~~~
- 성능을 위해 컬렉션을 가변 컬렉션으로 공유해야 한다면 이름을 주의 깊게 붙이자.(accumulator 등이 좋은 이름이다) 그리고 공유 범위를 최대한 제한하라.
- **불변 컬렉션 인터페이스를 사용하는 것만으로 불변 컬렉션을 달성할 수 없다.**
  - ch6/MutableListToList.kt 참고
- 어떤 자바 코드가 가변 컬렉션에 의존한다면 코틀린이 자바 코드에서 가정하는 불변 조건(공유된 컬렉션을 변경하지 말라)을 깨는 일은 없는지 더 조심해야 한다.
- stream() 은 대용량 연산을 위해 lazy 연산을 하는데 이걸 바로 kotlin 의 연산 체이닝?으로 바꿔야 할지는 고민해봐야 한다. 
  - 자바에서 코틀린으로 변환할때 stream() 을 asSequence() 를 사용해서 변환해야 할지 고민이 필요하다. 함부로 stream() 을 지우면 안된다!