### mvn 

- groupId : 패키지 구조 
- artifactId : 프로젝트 이름. 나중에 jar 파일로 만들어질 이름
- mvn validate : pom.xml에 문제가 있는지 확인 
- 웹페이지에서 maven central 이라고 해서 필요한 의존성 추가 
- mvn compile : 필요한 의존성을 maven이 다운로드 하고 컴파일 해준다. 
- build는 shade 플러그인으로 한다. 
- compile은 단순하게 클래스 파일만 만들어 주고 package는 Jar 아카이빙까지까지 해준다.   

### h2 db

- 연결 url을 jdbc:h2:mem:"디비명"으로 생성시 메모리db를 사용해서 파일이 만들어 지지 않는다. 파일db를 사용할 경우에는 jdbc:h2:~/"디비명"을 사용한다. 파일db를 사용할 경우 home디렉토리에 h2 db 파일이 생성된다.

### git

- git commit -m "first" 
- git push -u origin master 

### 3-tier Architecture

- Presentation(Front-end) : 사용자와 소통하는 부분 
- Business(Back-end) : 사용자와 소통한 결과. 사용자가 요청한 것을 처리하는 부분 
  - Layered Architecture
    - UI Layer 
    - Application Layer
    - Domain Layer
    - Infrastructure Layer 
- Data Source(Database) : 처리한 것들을 저장하는 곳 
