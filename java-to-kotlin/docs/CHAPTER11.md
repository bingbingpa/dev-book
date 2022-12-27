# CHAPTER 11 메서드에서 프로퍼티로

- 코틀린은 자바 클래스의 공개 필드에 접근하는 코드를 생성하지만, 코틀린 컴파일러가 (바이트코드에서) 공개 필드를 직접 정의하는 경우는 없다.
  - 정말 공개 필드가 필요하다면 @JvmField 라는 특별한 애너테이션을 사용해야 한다.
  - 코틀린 설계자들이 이렇게 결정한 이유는 클라이언트에 영향을 끼치지 않고 표현을 변경할 수 있도록 접근자 사용을 권장하기 위함이다.
- 프로퍼티 vs 메서드
  - 호출된 시점에 따라 결과가 달라진다면 함수를 사용
  - 계산 비용이 많이 든다면 함수
- 지연 프로퍼티를 사용하면 특정 함수를 사용하는 인스턴스와 그렇지 않은 인스턴스의 계산 비용을 다르게 할 수 있다.
  - ~~~kotlin
    data class PersonWithProperties(
        val givenName: String,
        val familyName: String,
        val dateOfBirth: LocalDate,
    ) {
        val hash: ByteArray by lazy {
            someSlowHashOf(givenName, familyName, dateOfBirth.toString())
        }
    }
    ~~~