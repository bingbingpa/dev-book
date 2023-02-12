# CHAPTER 9 다중식 함수에서 단일식 함수로

- 단일식 함수를 계산에만 사용하는 관습을 택한다면, 단일식 함수를 사용하는 의도를 다른 사람들에게 알릴 수 있는 수단이 생긴다.
  - 단일식 함수가 Unit 을 반환하거나 가변 상태를 읽거나 쓰지 말아야 한다.
  - 가변 상태를 읽거나 쓰는 것에는 I/O 를 수행하는 행위도 포함된다.
- 자바의 if-else 는 문(statement)이고, 코틀린의 if-else 는 식(expression)이다.
  - 식은 값을 만들어낸다.
- let, also 같은 스코프 함수는 좋은가?
  - 코드의 트랜잭션 레벨을 하나의 스코프로 모아주기 때문에 코드가 하나의 트랜잭션으로 묶여서 더 안전하다.
  - 변수 선언이 많을 수록 메소드의 코드 레벨에서 트랜잭션은 보장할 수 없다.
  - ~~~kotlin
    fun parse(str: String) = str.split('@').also { list ->
        require(list.size == 2 && list.all { it.isNotEmpty() }) { "error" }
    }.let { (id, domain) ->
        EmailAddress(id, domain)
    }
    ~~~