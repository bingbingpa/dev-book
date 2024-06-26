# 1주차 1장 ~ 2장(2024.05.30)

### 비지니스 도메인의 문제

- 비즈니스를 잘 이해했다 = 돈을 많이 벌고 있다.
- 대부분 돈을 많이 벌고 있지 않음
- 돈 벌고 있는 대부분도 왜 돈이 벌렸는지 잘 모름
- 사업 당사자도 비즈니스로서의 도메인을 잘 이해하지 못함
- 따라서 개발자가 비지니스를 잘 이해한다는 건 원래 불가능함

### 개발자가 비즈니스에서 알 수 있는 것(이해는 불가)

- 관찰해보니 그 일을 실제하고 있음
- 비지니스 경쟁자가 어떤 일을 하고 있음
- 비지니스 관련 법령이나 암묵지로 해야할 일이 있음
- 비지니스 전개에 관련된 권한을 가진 사람이 그렇다고 함

### 비지니스의 구분

- 크게 돈 되는 부분 - 핵심 하위 도메인
- 작데 돈 되는 부분 - 일반 하위 도메인
- 돈 벌려면 해야하는 부분 - 지원 하위 도메인
- 뭐가 왜 돈 되는지 사업 당사자도 잘 모름
- 핵심 하위 도메인이라고 생각했던게 도메인 자체가 아니었음
- 일반 하위 도메인이라고 생각한 부분으로 회사가 돌아감
  - 쇼핑몰로 돈벌려고 했는데 AWS 로 돈벌고 있음
- 지원 하위 도메인이라고 생각한 부분으로 회사가 돌아감
  - cs 게시판에 답변을 잘하다보니 유명해져서 cs 회사가 독립됨

### 하위 도메인을 개발하는 방법

- 돈을 벌려면 (개발)비용을 최적화해야 함
- 비용이 절약되는 구조가 케바케임
  - 애니팡
    - 사장과 CTO 가 한게임 출신
    - 전부 CTO 가 개발하고 전직원이 리소스랑 뷰만 만듬
- 예산으로 계획하기: 개발팀 예산, 외주 예산 책정
- 개발팀 우선 배정 방법
  - 개발팀 규모에 따라 핵심-일반-지원 순으로 자원 배정
  - 규모가 모자른 만큼 외주 사용 - 외주 예산을 넘어가면?...
- 외주 우선 배정 방법
  - 외주 예산으로 지원-일반-핵심 순으로 자원 배정
  - 남은 것을 개발팀이 처리 - 개발팀 여력이 부족하다면?
- 위의 해소 방법: 도메인 줄이기, 개발팀 갈아넣기..., 외주업체 갈아넣기...

### 핵심 하위 도메인의 기술적인 측면

- 비즈니스의 핵심 도메인이 기술적인 차별성이 아닌 경우가 대부분
  - 누구나 납품할 수 있는 제품이지만 난 사장의 사촌?!!!
- 기술적 우위나 차별성은 다양하다.
  - 어떤걸 우위라고 할 수 있을까?!
- 마케팅과 결합된 기술력이 더 중요한 경우도 많다.

### 핵심 하위 도메인의 내제화 허상

- 국내 기업 대부분은 핵심 도메인 구현에 외주업체를 사용함
- 은행권을 비롯해 고도화된 도메인도 대부분 SI 업체가 구현함
- 주요 기업들의 잉여자본금 운영도 외부 투자사에 위임함
- 핵심 도메인 개발팀 내부에도 많은 외주 인원들이 상주하는게 현실
- 핵심 도메인은 돈을 벌어야하기 때문에 고도화된 기술을 사용할수록 대응이 느려져 오히려 모순적임. 핵심 도메인이야 말로 sass 나 외주의 경연장

### 유비쿼터스 언어

- 비지니스 도메인의 언어가 투명한 것은 아님
- 솔루션은 도메인을 옮기는 것이 아니라 새로운 방식으로 문제를 해결함
- 도메인과 관련되어 있지만 반드시 도메인에 존재하는 용어인 것은 아님
- 도메인 전문가가 IT 서비스에 대한 이해가 없는 경우는 흔함
- 도메인이 IT 에서 표현되는 방식에 따라 완전히 새로운 용어도 필요함
- 일반적으로 IT 프로젝트를 도메인 전문가가 주도할 수 없으므로 결국 유비쿼터스 언어는 도메인이 IT 에 수용되는 형태로 정의됨

### 도메인 커뮤니케이션

- 도메인지식에서 코드로 단반향으로 흐르는 것처럼 묘사됨
- 실제로는 개발팀의 흡수단 도메인을 바탕으로 작성된 서비스를 도메인팀이 사용한 피드백을 바탕으로 수정됨
- 애자일 이론에서도 강조하듯 가장 확실한 커뮤니케이션은 제품 출시임
- 유비쿼터스 언어는 그저 커뮤니케이션시 같은 의미의 단어를 다른 형태로 혼란스럽게 사용하지 않게 도와주는 정도임
- 도메인 지식이 코드에 잘 전달 되었는지를 확인할 방법은 제품을 도메인측에서 사용해보는 수 밖에 없음
- 게다가 도메인쪽에서 판단하는 것은 도메인이 잘 전달되었나가 아님. 기존 도메인이 잘 표현되었는지는 중요하지 않음
  완전히 다르게 표현되었거나 다른 기능을 제공한다 하더라도 그게 도메인 내에서 가치를 발휘하는가가 관심사임

# 2주차 3장 ~ 6장(2024.06.06)

### 바운디드 컨텍스트

- 용도, 목적, 범위, 쓸모
- 모델의 경계, 모델의 적용 가능성, 고유모델의 정의가 가능한 범위
- 용어, 원칙, 규칙이 컨텍스트별로만 일관성 유지
- 필연적으로 컨텍스트 사이 컨트렉트가 어렵고, 충돌하며, 일관성이 없음
- 컨텍스트의 크기도 제각각인 경우 더욱 컨트렉트가 어려움
- 애당초 유기적인 결과물을 분리할 수 있나?
- 개발자가 분리할 수 있나? - 개발자의 이해로 현실 왜곡
- 지도처럼 본질이 하나인 것에 대한 다양한 모델 구현 시 문제

#### 실질적인 컨텍스트 분리

- 얼마나 안정적인 컨트렉트가 성립 하는지로 분리
- 트랜잭션이 단일 디비에서 이뤄지나?
- 외주나 외부서비스로 바꿀 수 있나?

### 빈약한 도메인 모델과 풍성한 도메인 모델

- 추천책 - 디자인 패턴의 아름다움(제이펌)
- 트랜잭션 스크립트나 도메인 모델 등은 너무 추상적이거나 자세한 정의
- 실제 코드의 형태에서는 큰 차이가 없음
  - 스프링: 엔티티(레포지토리) - 서비스 - 컨트롤러
- 도메인에 풍성한 부분은 서비스의 구현부임
- 빈약한 도메인모델 : 서비스가 레포지토리 제어를 중심으로 작성됨
- 풍성한 도메인모델 : 서비스가 도메인객체를 중심으로 작성되고 레포지토리를 필요한 만큼 활용함
- 빈약한 도메인모델의 서비스에서 도메인 문제와 레포지토리 문제를 분리된 코드로 관리하는가

### 값 객체와 엔티티

- 값 객체
  - 객체 통신용 메시지
  - 연산용 값
  - 도메인 비즈니스 로직계산을 위한 값
- 엔티티가 값 객체 사용
  - 속성이 도메인의 값 또는 도메인 로직 분산
  - 엔티티 상태 갱신 = 새 값 객체 생성
- 엔티티는 변화되는 상태를 관리함
  - 엔티티 내부 상태 간의 시계열 불일치 문제 발생
  - 다른 엔티티와 연동시 시계을 불일치는 더욱 복잡하게 발생

### 애그리게이트 루트 vs 도메인 이벤트

- 엔티티 간의 의존성이 단방향인가
  - 아무에게도 의존되지 않는 엔티티가 종단점(마지막 호스트. ex: 자바의 main 함수는 어디에서도 참조하지 않는다.)
  - 타 엔티티가 의존하는 엔티티가 진입점이 되면 관련된 객체 통신이 불가능함
- 엔티티 종단점은 애그리게이트 루트 후보
- 도메인 이벤트를 사용할 때도 애그리게이트 루트 후보용으로 디자인되어야함
- 애그리게이트에서 외부에 알려질 도메인은 종단점(루트)뿐임
  - ex) 애플리케이션 계층에서는 티켓만 노출
- 이 루트만 충분한 설명과 긴 이름으로 짓는 게 좋음(타 컨텍스트 충돌)
  - ex) 영업팀의 '리드'와 마케팅의 '리드'가 충돌하는것처럼 충분한 설명과 긴 이름으로!

# 3주차 7장 ~ 9장(2024.06.13)

### 이벤트 소싱

- DDD 의 실제 구현은 애그리게이트임
- 애그리게이트는 불변식에 의한 갱신, 수정, 생성에 대한 것임
- 조회는 애당초 DDD 의 고려사항이 아님
- 현실에서 조회 정책은 다양함
- 시계열 상태에 대한 조회를 지원하는 패턴이 이벤트 소싱
  - 은행계좌의 예에서 로그의 결과는 잔고임
  - 헌데 계좌에서는 그 로그 자체가 필요한 정보임
  - 잔고와 계좌 내역 자체가 서로 다른 가치를 지님
  - 이벤트소싱을 할지말지는 로그 자체가 도메인 인지 여부
  - 페이스북 좋아요, 공유의 예
    - 집계: 좋아요, 공유 수
    - 로그: 좋아요, 공유를 누른 사람과 나아가 그 순서와 시간

### 이벤트 소싱과 이벤트 스토어

- 실제 구현은 동기, 비동기 상황에 따라 매우 복잡함
- 데이터 중심 애플리케이션 설계에 이벤트 소싱편 참고
- 이벤트 소싱은 기본적으로 이벤트와 명령을 구분함
  - 이벤트는 불변이고 이벤트 수신자는 거부할 수 없음
  - 이벤트 생성 시점에 정합, 유효, 사실이어야 함
  - 수신자는 비동기 처리 가능, 생성자는 동기적 검증
- 티켓 예약 예
  - 예약이벤트 발생 전 동기적인 좌석상태 검증필요
  - 변경이나 취소는 또 다른 이벤트임
  - 이벤트가 불변, 사실이라 동기관리가 어려우므로 이벤트를 분할함
    - 가예약 이벤트와 유효한 좌석에 대한 예약확정 이벤트로 분할
    - 이를 통해 좌석상태를 비동기로 처리

### CQRS

- 일기 중심으로 사고할 것
  - 단일 원본 쓰기가 다양한 읽기로 프로젝션 됨
  - 읽기는 여러 원본으로부터 쉐이핑되고 프로젝션 됨
  - 쓰기: 반드시 기억해야 할 모델
  - 읽기: 소비될 목적을 중심으로 방법을 강구함(모델에 관심x)
- 애그리게이트는 물론 DDD 전체는 CUD 의 불변식을 보장하는 게 목적
- 프로젝션에 대한 가이드가 없으므로 CQRS 를 결합하여 프로젝션을 보강
- 반드시 코드 구현은 아님(db 의 view 를 여러개 만든 게 시초)
- 분산시스템, 이벤트주도설계, 이벤트소싱, 비동기화와 결합하여 수 많은 변종이 탄생함

### 커뮤니케이션

- 바운디드컨텍스트란?
  - 이 코드를 두 팀이 관리하면 싸운다.(code conflict)
  - 도메인이 같을 지라도 심지어 하나의 애그리게이트로 파악되는 불변식이 있어도 일단 안싸우게 쪼개야 한다.
  - 하나이었어야 할 것도 나눴으니 중복이 발생하거나 도메인로직 상의 불일치나 정합성 위험이 생길 수 있음
  - 그래도 쪼개고 어떻게든 동기화 비용을 치루거나 수준을 낮춘 정합성을 사용하더라도 안싸우는게 전체에게 더 득이 되냐
- 커뮤니케이션 패턴은 바운디드 컨텍스트 사이의 통신이자 다른 팀 사이의 통신 방법임
