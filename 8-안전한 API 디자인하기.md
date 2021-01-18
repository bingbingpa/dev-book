### 8. 안전한 API 디자인하기
- API 보안과 API 디자인의 교차점
- 접근 제어를 위한 사용자 친화적인 스코프 정의 
- 접근 제어를 충족시키기 위해 API 디자인 적용 
- 민감한 정보를 처리하기 위한 API 디자인 적용
    #### 8.1 API 보안의 개요
    - 컨슈머 등록하기
        - API 를 안전하게 만들기 위해서는 허용된 컨슈머만 API 를 사용하도록 해야 한다. 그러기 위해서 개발자들은 API 제공자의 **개발자 포털**을 사용할 수 있어야 한다. 
        - 컨슈머가 API 의 어느 스코프까지 사용할지 선택하도록 해야한다. 여기서 **스코프**란 API 에 속한 하나에서 여러 목표들을 의미한다.
        - API 개발자 포털을 제공할 수 없는 경우에는 데이터 베이스에 응용 프로그램 이름, 범위 및 자격 증명을 안전하게 저장하는 등의 방식으로 동일한 구성을 수행 할 수 있다.
    - API 사용을 위해 자격증명 가져오기
        - 인증 서버 : 최종 사용자의 인증정보를 확인한다. 인증 토큰을 생성하고, 사용자 ID, 클라이언트 ID, 허용된 스코프 등을 포함해서 반환한다. 
        - 웹 인증 프레임 워크 : Oauth 2.0 , OpenID Connect
    - API 호출하기
        - 컨슈머의 리퀘스트는 액세스 토큰으로 추가된 데이터라는 컨텍스트에 묶여 있다.
        - 리퀘스트를 액세스 토큰과 함께 호출하면, 인증 서버는 액세트 토큰이 유효한지 확인하고, 필요한 정보를 추가하여 반환한다.
        - API 서버는 액세스 토큰으로 받은 스코프에 따라 적절한 응답을 내려준다.
    #### 8.2 API 분할을 통한 접근 제어 활성화
    - 컨슈머가 접근 가능한 영역을 꼭 필요한 수준으로 제한을 둠으로써, 공격에 대한 가능성을 줄일 수 있다.(**최소 권한의 원칙**)
    - 유연하고 정제된 스코프 정의하기
        - 첫 번째 단계로 각 목표에 대한 주요 컨셉(또는 자원) 식별을 한다. 가장 먼저 목표를 대표할 수 있는 일반 명사를 식별해야 한다.
        - 두 번째로 목표의 대표 동사를 표현하기에 적합한 생성, 읽기, 수정, 삭제에 CRUD 액션을 식별해 낸다.
        - 컨셉과 액션을 이용해 스코프를 나누면 여전히 유연성을 유지하지만, 구성은 지나치게 정제되거나 복잡해지지 않는다. 
    - 단순하지만 더 굵직한 스코프로 정의하기
        - 카테고리 : 기능적 관점으로 목표들을 구조화하여 API 를 어떻게 쓰는지 컨슈머에게 도움이 되고자 하는 목적
        - 스코프 : 컨슈머가 그들에게 필요한 목표에만 접근할 수 있도록 통제하고자 하는 목적
    - API 명세 포맷으로 스코프 정의하기
        - 스코프 표현하기
        ~~~ oas
        components:
            securitySchemas:
                BankingAPIScopse: # 재사용 가능한 스코프는 components.securitySchemas 에 정의되어 있다.
                    type: oatuh2
                    flows:
                        implicit:
                            authorizationUrl: "https://auth.bankingcompany.com/authorize" # URL 은 한 줄로 표시하는 편이 좋다.
                            scopes: # 보안 스키마는 하나 이상의 스코프를 포함할 수 있다.
                                "beneficiary:create": Create beneficiaries
                                "beneficiary:read": List beneficiaries
                                "beneficiary:delete": Delete beneficiaries
                                "beneficiary:manage": Create, list, and delete beneficiaries
        ~~~
        - 목표와 스코프의 연결
        ~~~ oas
        paths:
            /beneficiaries:
                get:
                    tages:
                        - Transfer
                    description: Gets beneficiaries list
                    security: # 사용되는 보안 스키마들의 목록
                        - BankingAPIScopes: # components.securitySchemas 를 참조하여 이 목표에서 필요로 하는 스코프들의 열거
                            - "beneficiary:read"
                            - "beneficiary:manage"
                    - responses:
                        "200":
                            description: The beneficiaries list
        ~~~