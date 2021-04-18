# study toby spring

- 토비의 스프링을 현재 버전에 맞게 나름대로 작성해본 코드 저장소.
- 각 챕터의 환경 설정은 도커로 구성되어 있으며, docker 폴더 밑에 각 챕터별로 docker-compose.yml 파일을 통해서 챕터별 테스트 환경을 구성할 수 있다.
- 도커 mysql:8.0 이미지 사용.
- **스프링 버전은 스프링부트 2.4.5 버전으로 구성하였고, 책과의 차이점들은 아래에 정리.** 
- mysql-connector 8.x 버전을 사용하였고, 책에서 처럼 jar 파일을 직접 넣지 않고 gradle 설정에 추가.
  ~~~ groovy
  implementation 'mysql:mysql-connector-java:8.0.23'
  ~~~~

## ch1. 오브젝트와 의존관계
- mysql 8.x 버전부터 드라이버 클래스가 변경 되어서 수정. 
  ~~~ java
  Class.forName("com.mysql.cj.jdbc.Driver");
  ~~~
- SimpleDriverDataSource 대신 HikariDataSource 를 사용하였고, 관련 의존성을 추가.
  ~~~ groovy
  implementation group: 'com.zaxxer', name: 'HikariCP', version: '4.0.3'
  ~~~
- 책에는 없지만 매번 테스트 마다 테이블을 delete 하는 것이 번거로워 모든 UserDao 에 delete 메소드 추가.
- xml 로 설정하는 부분은 코드에 포함하지 않았다.
- step1: 초난감 DAO
- step2: 중복 코드의 메소드 추출(connection 정보 메소드로 추출)
- step3: 상속을 통한 확장
- step4: 상속 제거, 클래스로 분리(관심사 분리)
- step5: 인터페이스 도입
- step6: 팩토리 클래스 적용(IoC)
- step7: 스프링 설정 적용(@Configuration, @Bean)
- step8: DataSource 적용 