# CHAPTER 15 캡슐화한 컬렉션에서 타입 별명으로

- 자바 컬렉션 인터페이스는 객체 지향이라는 뿌리를 따라서 근본적으로 가변적이다. 반면 코틀린은 컬렉션을 값 타입으로 다룬다.
- 코틀린은 정적 함수를 더 쉽게 발견할 수 있게 도와주는 확장 함수와 불변 컬렉션을 제공하기 때문에, 도메인 모델을 컬렉션 타입으로 나누고 연산을 도메인 모델과 분리하는 쪽이 더 편하다.