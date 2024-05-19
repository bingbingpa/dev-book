# OpenAPI 와 스웨거를 활용한 실전 API 설계

- *조시 포널랫, 루카스 로젠스톡 저/오명운 역 | 책만*

## 1장 API 와 OpenAPI 소개

- API 는 각 서비스가 제공할 수 있는 것이 무엇이고, 다른 서비스와 어떻게 상호작용할 수 있는지를 정의한다.
- 'API 설계자'의 역할은 사용자로부터 피드백을 받아서 변경사항에 대해 미리 협의 할 수 있도록 API 를 설계하는 것이다.
- OpenAPI
    - HTTP 기반 API 를 설명하는 방식을 정해놓은 규격이다.
    - YAML 이나 JSON 파일 형식으로 작성된다.
- 어디서부터 REST 이고 어디까지가 HTTP 인지 명확하게 경계를 짓기는 어렵지만, HTTP 는 프로토콜이고 REST 는 API 를 기술하는 한 방식이라고 이해하자.
- 실무 현장에서는 HTTP 기반 API 를 설계할 때 요구사항과 표준 또는 REST 원칙 준수 사이에서 트레이드오프를 고려한 현명한 결정을 내려야 한다.

## 3장 OpenAPI 정의서 첫인상

- OpenAPI 는 YAML 과 JSON 두 가지 모두 지원한다.
- YAML 은 JSON 의 슈퍼세트라서 JSON 이 필요한 곳에서는 JSON 을 사용할 수 있다.

## 4장 스웨거 에디터로 OpenAPI 정의서 작성

- 스웨커 데이터는 OpenAPI 정의서 작성을 도와주는 도구다.
- 작성한 YAML 문서가 OpenAPI 정의서로 인식되려면 가장 먼저 `openapi` 필드가 포함돼 있어야 한다. 사용할 OpenAPI 명세 버전을 openapi 필드 값으로 지정한다.

## 5장 API 응답 기술하기

- nullable 키워드를 사용할 수 있다.
- 모든 스키마는 type 필드를 가지며 기본 JSON 타입인 object, array, string, number, boolean, integer, null 을 값으로 지정할 수있다.
  - integer 는 정수값만 number 는 음수, 소수점이 있는 값도 가능
- type 이 array 인 배열 스키마는 배열 원소를 기술하기 위해 **items** 프로퍼티를 반드시 포함해야 하며, items 의 배열 원소에 대한
스키마를 items 의 값으로 지정한다.
- type 이 number 인 숫자 스키마는 minimum, maximum 필드로 최소/최대값을 지정할 수 있다.
- type 이 string 인 문자열 스키마는 patterns 필드에 정규 표현식을 지정할 수 있다.