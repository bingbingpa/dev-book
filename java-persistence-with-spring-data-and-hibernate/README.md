# 자바 퍼시스턴스 프로그래밍 완벽 가이드

- *커틀린 투도세 저/트랜스메이트 역 | 위키북스 *

# 1부 ORM 시작하기 

### 03 도메인 모델과 메타데이터

- 도메인 모델 구현에 비즈니스 외적인 문제가 스며들지 않도록 노력을 기울여야 한다.
  - 영속성, 트랜잭션 관리, 권한 부여와 같은 관심사가 도메인 모델 클래스에 나타나지 않도록 하자. 
  - 도메인 모델 구현은 그것과 무관한 API 의존해서는 안 되는 중요한 코드이다.
- 잘게 세분화되고 풍부한 도메인 모델을 지원하는 것은 하이버네이트의 주요 목표이다.
  - 일반적으로 잘게 세분화된 객체를 사용한다는 것은 테이블보다 클래스의 수가 더 많다는 것을 의미한다.

### 04 스프링 데이터 JPA 다루기

- CrudRepository 는 기술에 종속되지 않는 일반화된 영속성 인터페이스로서 rdb 뿐만 아니라 NoSQL 디비에도 사용할 수 있다.
- JpaRepository 는 영속성 컨텍스트를 플러시하고 레코드를 일괄 삭제하는 등 JPA 관련 메서드를 제공한다.

# 2부 매핑 전략

### 05 영속성 클래스 매핑

- 엔지니어의 역할은 시스템이 다뤄야 할 문제 환경인 **애플리케이션 도메인**과 이 시스템을 구축할 소프트웨어 및 기술인 **솔루션 도메인**을 연결하는 것이다.
- 스프링 데이터 JPA 의 주요 목표는 잘게 세분화되고 풍부한 도메인 모델을 지원하는 것이다.
  - **잘게 세분화**된다는 것은 간단하게 말하면 테이블보다 클래스의 수가 더 많다는 뜻이다.
- 동일성(==)은 두 개의 참조가 동일한 메모리 위치를 가리키는 경우
- 동등성은 equals() 메서드에 의해 정의되는 개념으로, 두 인스턴스가 같은 값, 즉 같은 상태를 갖는다는 뜻 
- 데이터베이스 동일성은 관계형 데이터베이스에서 저장된 객체가 동일한 테이블과 기본키 값을 공유하면 동일한 것이다.
- 모든 엔티티 클래스에는 @Id 프로퍼티가 있어야 하고, 이를 통해 JPA 가 데이터베이스 동일성을 애플리케이션에 노출한다.
- @GeneratedValue 가 없으면 JPA 공급자는 인스턴스를 저장하기 전에 식별자 값을 생성하고 할당하는 작업을 사용자가 처리한다고 가정한다.
- 좋은 기본키는 절대 널이 될 수 없고, 고유하며, 변경되지 않는다.

# 3부 트랜잭션 방식의 데이터 처리

# 4부 스프링을 이용한 자바 영속성 애플리케이션 구축

# 5부 MongoDB 와 Neo4j 를 활용한 자바 영속성 애플리케이션 구축

# 6부 쿼리 작성과 자바 영속성 애플리케이션 테스트