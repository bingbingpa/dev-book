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
    - OAS 는 JSON Schema 사양을 기반으로 모든 데이터를 표현한다.
    - 쿼리 파라미터 묘사
      - parameters 속성은 리스트이거나 배열이며, YAML 에서는 배열이나 리스트에 속하는 개별 원소들은 대시(-)로 시작한다.
        - name: 실제 경로상(products?free-query={free query})에서 보이는 파라미터의 이름
        - in: 파라미터가 어디에 위치하는지를 의미한다. 이번의 경우에는, query 파라미터임을 나타내고, 이는 경로의 맨 뒤에 ?(물음표) 다음에 위치한다는 의미이다.
        ~~~ oas
        openapi: "3.0.0"
            info:
                title: 쇼핑 API
                version: "1.0"
            paths:
                /products: # 리소스
                    get: # 액션의 HTTP 메서드
                        summary: 상품 조회 # 액션의 짧은 설명
                        description: |
                            카탈로그에서 비정형 질의 파라미터로 
                            조회한 상품들
                        parameters:
                        - name: free-query # 파라미터 이름
                          description: | # 파라미터 설명 
                            상품의 이름(name), 참조값(reference), 또는 상품 설명의 일부(partial description)
                          in: query # 파라미터의 위치
                          required: false # 파라미터의 필수여부
                          schema: # 파라미터의 데이터 구조 설명
                            type: string # 파라미터의 타입(string)
                        responses:
                            "200":
                            description: |
                                비정형 질의 파라미터에 부합하는 상품들
        ~~~
    - JSON Schema 를 통한 데이터 묘사
      - properties: 프로퍼티들에 대해 기술
      - required : 필수인 속성
      ~~~ oas
      type: object
      description: A product
      required: # 필수인 속성들
        - reference
        - name
        - price
        - supplier
      properties: # 프로퍼티들에 대한 설명
        reference:
            type: string
            description: Product`s unique identifier
            example: ISBN-92930293
        name:
            ...
        price:
            ...
        description:
            ...
        supplier: # 프로퍼티 중에서 오브젝트 타입에 대한 설명
            type: object
            description: Product`s supplier
            required:
                - deference
                - name
            properties:
                reference:
                    ...
      ~~~
    - 리스폰스 묘사
      - content: 리스폰스 바디의 미디어 타입
      - schema: 리스폰스 바디의 JSON 스키마
      - type: 리스폰스 바디의 타입
      - items: 리스폰스 바디 타입의 아이템 Schema
      ~~~ oas
      responses:
          "200":
          description: |
              비정형 질의 파라미터에 부합하는 상품들
          content: # 리스폰스 바디의 정의
              application/json: # 리스폰스 바디의 미디어 타입
                  schema: 리스폰스 바디의 JSON 스키마
                      type: array # 리스폰스 타입은 배열이다
                      description: 상품의 배열 
                      required:
                          - reference
                          - name
                          - price
                          - supplier
                      properties:
                          reference:
                              description: 상품을 식별하는 고유 ID
                              type: string
                          name:
                              ...
                          ...
      ~~~
    - 바디 파라미터 묘사
      ~~~ oas
      requestBody:
        description: 상품의 정보
        content:
            applictaion/json:
                schema: # 바디 파라미터의 스키마
                    required:
                        - name
                        - price
                        - supplierReference
                    properties:
                        name:
                            type: string
                        price:
                            type: number
                        description:
                            type: string
                        supplierReference:
                            type: string
      ~~~
    - OAS 에서 API 를 효율적으로 묘사하기
      - 컴포넌트 재사용하기
        - 스키마, 파라미터, 리스폰스등을 재사용 할 수 있고, **$ref** 속성으로 사전에 정의된 스키마의 경로를 적어주면 된다.
        ~~~ oas
        openapi: "3.0.0"
        [...]
        components: # 재사용 가능한 컴포넌트
            schemas: # 재사용 가능한 스키마
                product: # 재사용 가능한 스키마의 이름
                    type: object
                    description: 상품
                    required:
                    [...]
        paths:
            /products: 
                post:
                    summary: 상품 추가
                    description: 상품을 카탈로그에 추가한다.
                    responses:
                        "200":
                        description: 카탈로그에 상품이 추가됨
                        content:
                            application/json:
                                schema: 
                                    $ref: "#/components/schemas/product" # 사전에 정의된 스키마를 참조
    
        ~~~
      - 패스 파라미터(Path Parameter) 묘사하기
        - /products/{productId} 경로에서 productId 를 변수로 취급하는데 이를 **패스 파라미터**라고 한다. 
        ~~~ oas
        paths:
            /products:
            [...]
            /products/{productId}: # 상품 리소스와 파라미터
                description: 상품
                delete: # 상품 삭제 액션
                    summary: 상품 삭제
                    prametes: # 상품 삭제 액션의 파라미터들
                        - name: productId # 패스 파라미터의 이름
                          in: path # 파라미터의 위 치
                          required: true # 파라미터의 필수 여부
                          description: 상품의 식별자
                          schema:
                            type: string
        ~~~
        - 패스파라미터 역시 컴포넌트로 재사용 가능하다.
        ~~~ oas
        components:
            prameters:
                productId:
                    [...] # 패스 파라미터 정의
        paths:
            /products:
            [...]
            /products/{productId}: # 상품 리소스의 경로와 패스 파라미터
            /delete:
                parameters:
                    - $ref: #/compotents/parameters/productId # 사전 정의된 파라미터 참조
        ~~~
