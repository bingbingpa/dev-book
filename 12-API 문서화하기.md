### 12. API 문서화하기
- 참조 문서
- 사용자 가이드
- 구현 명세
- 변경이력
    #### 12.1 참조 문서 만들기
    - **ReDoc**: OpenAPI 사양 파일을 기반 참조 문서를 생성하는 데 사용되는 도구
        - redoc-cli([https://github.com/Rebilly/ReDoc/tree/master/cli](https://github.com/Rebilly/ReDoc/tree/master/cli))
        - redoc-cli serve <OpenAPI 파일 경로> --options.showExtensions
        - 독립형 HTML 문서로 만들기 : redoc-cli bundle <OpenAPI 파일 경로> --options.showExtensions
    - 참조 문서는 단순히 최소 정보만 제공해서는 안된다. 참조 문서는 기술적, 기능적으로 유용한 설명과 예제를 제공해야 한다.
    - 사람이 읽을 수 있는 설명에는 속성의 역할과 다른 속성들과의 관계, 속성의 사용 시기 등 속성의 성격이 설명되어 있다.
    #### 12.2 사용자 안내서 작성하기
    - 유즈케이스 문서화 하기
        - PlantUML([http://plantuml.com](http://plantuml.com))
        - openAPI 명세파일에 마크 다운 형태로 작성하기
        ~~~ oas
        [...]
        info:
            title: Banking API
            version: "1.0.0"
            description: |
                Banking API 는 계좌 정보 조회와 받는 계좌 정보, 송금 관리 등의 기능이 가능합니다.
                # 사용예시 
                ## 특정계좌 혹은 기존에 보냈던 계좌로 금액 송금하기
                _송금하기_기능은 이용자가...
                
                ![그림](http://developer.bain....)
      
                ## 예약 송금, 자동 송금 취소하기
                - 송금 목록 조회
                - 송금 취소하기
        [...]
        ~~~
    - 표준 OpenAPI 명세 파서는 x- 로 시작하는 모든 속성들은 모두 무시한다.
    #### 12.3 문서의 개정과 폐기
    - OpenAPI 명세에 따르면, **deprecated** 플래그는 데이터 모델의 파라미터, 목표, 속성에 사용할 수 있다. 여기서는 더 이상 사용되지 않는 요소에 대한 설명은 대신 사용할 수 있는 항목을 나타낸다.