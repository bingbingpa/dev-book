### 4. API 명세 포맷을 이용한 API 디자인
- OAS(OpenAPI Specification) 는 널리 사용되는 REST 명세 포맷이다.
    #### 4.1 API 명세 포맷이란 무엇인가?
    - **API 명세**는 API 의 세부사항을 표현하기 위한 데이터 포맷이다.
    - OAS 는 프로그래밍 언어에 상관없이 사용하는 REST API 명세 포맷이다. 
    - OAS 문서는 YAML 이나 JSON 으로 작성할 수 있는데, 저자는 읽고 쓰기 좋은 YAML 을 추천!
        - YAML 에서 큰따옴표는 속성과 값에서 허용되지 않는다.
        - JSON 의 구조는 중괄호({})와 쉼표(,)로 구분 지어지지만 YAML 에서는 줄바꿈과 들여쓰기로 대체된다.
        - 배열에서 쓰던 대괄호([])와 쉼표(,)들은 YAML 에서는 대시(-)와 줄바꿈으로 대체된다.
        - JSON 과 다르게 YAML 은 문장의 시작에 해시마크(#)를 넣어 주석 처리가 가능하다.
    - **intellij 에서 swagger 를 검색해서 플러그인을 설치하면 OSA 문서를 작성하고 바로 html 파일로 볼 수 있다.**
    - OAS 포맷은 프로그래밍 인터페이스를 어떤 코드를 작성할 필요 없이 만들어 낼 수 있는 API 디자인 도구들이 있다!
    - API 명세 포맷은 API 목표와 컨셉, 데이터를 프로그래밍 가능한 표현으로 설계할 때 사용해야 한다.
    #### 4.2 OAS 를 통한 API 리소스와 액션 설명
    - OAS 문서 생성 
        - 명세의 버전과 API 버전의 숫자는 반드시 큰따옴표로 둘러 싸야 한다. 
        - 예시)
            ~~~ oas
            openapi : "3.0.0"  # OAS 버전
            info: # API 일반 정보
                title: Shopping API
                version: "1.0"
            paths: {} # 빈 경로
            ~~~
    - 리소스 설명 
        - description 이 필수는 아니다. 하지만 API 리소스에 대한 설명을 제공하면 API 의 전체 수명주기동안 유용하게 쓰일 수 있다.
        - **OAS 문서에서 설명하는 리소스는 반드시 동작을 포함하고 있어야 한다.** 그렇지 않다면 문서는 유효하지 않다.
        - 예시)
            ~~~ oas
            openapi : "3.0.0"  
            info: 
                title: Shopping API
                version: "1.0"
            paths: # API 의 리소스
                /products: # 리소스의 경로
                    description: 상품 카탈로그 # 리소스의 설명
            ~~~ 
    - 리소스의 동작 설명
        - summary 속성은 액션에 대한 짧은 설명이며, 구체적인 사항은 없다.
        - YAML 에서 string 속성을 여러행으로 작성 할 때 반드시 **파이프(|)** 문자로 시작해야 한다.
        - OAS 문서에서 동작은 반드시 적어도 하나의 response 속성을 가지고 있어야 한다.
        - 예시)
            ~~~ oas
            openapi: "3.0.0"
            info:
                title: 쇼핑 API
                version: "1.0"
            paths:
                /products: # 리소스
                    description: 상품 카탈로그
                    get: # 액션의 HTTP 메서드
                        summary: 상품 조회 # 액션의 짧은 설명
                        description: |
                            카탈로그에서 비정형 질의 파라미터로 
                            조회한 상품들
                        responses: # 액션 리스폰스 리스트
                            "200": # 200 OK HTTP 상태 리스폰스
                                description: |
                                    비정형 질의에 일치하는 상품들
                    post:
                        summary: 상품 추가
                        description: |
                            상품 정보 파라미터에 해당하는
                            상품을 카탈로그에 추가
                        responses:
                        "200":
                            description: 카탈로그에 상품이 추가됨
            ~~~
    #### 4.3 OpenAPI 와 JSON Schema 로 API 데이터 표현하기
