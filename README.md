# study toby spring

- 토비의 스프링 코드 저장소입니다.
- 각 챕터의 환경 설정은 도커로 구성되어 있으며, docker 폴더 밑에 각 챕터별로 docker-compose.yml 파일을 실행(docker-compose up -d)해서 챕터별 코드를 실행 해볼 수 있습니다.
- 스프링 버전은 스프링부트 2.4.5 버전으로 구성하였고, 책과의 차이점들은 아래 정리되어 있습니다. 

## ch1. 오브젝트와 의존관계
- 도커 mysql:8.0 이미지를 사용했습니다.
- mysql-connector 8.x 버전을 사용하였고, 책에서 처럼 jar 파일을 직접 넣지 않고 gradle 설정에 추가하였습니다.
  ~~~ groovy
  implementation 'mysql:mysql-connector-java:8.0.23'
  ~~~~
- mysql 8.x 버전부터 드라이버 클래스가 변경 되어서 수정했습니다. 
  ~~~ java
  Class.forName("com.mysql.cj.jdbc.Driver");
  ~~~