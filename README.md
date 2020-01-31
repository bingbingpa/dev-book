# 오브젝트 - 코드로 이해하는 객체지향 설계

## 01 객체, 설계 
 
 - 객체 사이의 의존성이 과한 경우를 가리켜 결합도(coupling)가 높다고 말한다. 반대로 객체들이 합리적인 수준으로 의존할 경우에는 결합도가 낮다고 말한다. 두 객체 사이의 결합도가 높으면 높을수록 함계 변경될 확률도 높아지기 때문에 변경하기 어려워진다. 따라서 **설계의 목표는 객체 사이의 결합도를 낮춰 변경이 용이한 설계를 만드는 것이다.**
 - 개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것을 캡슐화(encapsulation)라고 부른다. 캡슐화의 목적은 변경하기 쉬운 객체를 만드는 것이고, 캡슐화를 통해 객체 내부로의 접근을 제한하면 객체와 객체 사이의 결합도를 낮출 수 있기 때문에 설계를 좀 더 쉽게 변경할 수 있게 된다. 
- **객체 내부의 상태를 캡슐화하고 객체 간에 오직 메시지를 통해서만 상호작용하도록 만들어야 한다.**
- 밀접하게 연관된 작업만을 수행하고 연관성 없는 작업은 다른 객체에게 위임하는 객체를 가리켜 응집도(cohesion)가 높다고 말한다. 자신의 데이터를 스스로 처리하는 자율적인 객체를 만들면 결합도를 낮출 수 있을뿐더러 응집도를 높일 수 있다. 
- 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍하는 방식을 객체지향 프로그래밍(object-Oriented Programming)이라고 부른다.   
- **설계란 코드를 배치하는 것이다.**

## 02 객체지향 프로그래밍

- 진정한 객체지향 패러다임으로의 전환은 클래스가 아닌 객체에 초점을 맞출 때에만 얻을 수 있다.
	- 어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지 고민하라. 
	- 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다.
- 의미를 좀 더 명시적이고 분명하게 표현할 수 있다면 객체를 사용해서 해당 개념을 구현하면 도메인의 의미를 풍부하게 표현 할 수 있다. (Money 클래스)  
- 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 **TEMPLATE METHOD 패턴**이라고 부른다.
- 생성자의 파라미터 목록을 이용해 초기화에 필요한 정보를 전달하도록 강제하면 올바른 상태를 가진 객체의 생성을 보장할 수 있다.
- 상속을 구현 상속(implementation inheritance)과 인터페이스 상속(interface inheritance)으로 분류할 수 있다. 
	- 순수하게 코드를 재사용하기 위한 목적으로 사용하는 것을 구현 상속이라고 부른다.
	- 다형적인 협력을 위해 부모 클래스와 자식 클래스가 인터페이스를 공유할 수 있도록 상속을 이용하는 것을 인터페이스 상속이라고 부른다. 
	- 상속은 구현 상속이 아니라 인터페이스 상속을 위해 사용해야 한다. 
	- 구현을 재사용할 목적으로 상속을 사용하면 변경에 취약한 코드를 낳게 될 확률이 높다. 
- 상속은 코드를 재사용할 수 있는 가장 널리 알려진 방법이지만 캡슐화의 측면에서 합성이 더 좋은 방법이다. 
- 유연한 객체지향 프로그램을 위해서는 컴파일 시간 의존성과 실행 시간 의존성이 달라야 한다. 하지만 그럴수록 코드만으로 이해 할 수 있는 복잡도는 높아진다.  

## 03 역할, 책임, 협력

- 객체지향 패러다임의 관점에서 핵심은 역할(role), 책임(responsibility), 협력(collaboration)이다. 
- 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용을 **협력**이라고 한다. 객체가 협력에 참여하기 위해 수행하는 로직은 **책임**이라고 부른다. 객체들이 협력 안에서 수행하는 책임들이 모여 객체가 수행하는 **역할**을 구성한다. 
- 객체의 책임은 하는 것(doing)과 아는것(knowing)의 두 가지 범주로 나누어 볼 수 있다. 
- 객체에게 책임을 할당하는 데 필요한 메시지를 먼저 식별하고 메시지를 처리할 객체를 나중에 선택한다.
- 역할은 다른 것으로 교체할 수 있는 책임의 집합으로 일종의 슬롯으로 생각할 수 있다.
- 동일한 책임을 수행하는 역할을 기반으로 두 개의 협력을 하나로 통합 할 수 있고, 역할을 이용하면 불필요한 중복 코드를 제거할 수 있다. 
- 협력에 적합한 책임을 수행하는 대상이 한 종류라면 간단하게 객체로 간주한다. 만약 여러 종류의 객체들이 참여할 수 있다면 역할이라고 부르면 된다. 
- 동일한 역할을 수행하는 하나 이상의 객체들이 존재 할 수 있다. 이것은 협력 관점에서 동일한 역할을 수행하는 객체들은 서로 대체 가능하다는 것을 의미한다. 
- 객체는 다양한 역할을 가질 수 있다. 객체는 협력에 참여할 때 협력 안에서 하나의 역할로 보여진다. 객체가 다른 협력에 참여할 때는 다른 역할로 보여진다. 

## 04 설계 품질과 트레이드 오프 

- 훌륭한 객체 지향 설계는 데이터가 아니라 책임에 초점을 맞춰야 한다. 
- 데이터 중심의 설계란 객체 내부에 저장되는 데이터를 기반으로 시스템을 분할하는 방법이다. 
- 변경될 가능성이 높은 부분을 **구현**이라고 부르고 상대적으로 안정적인 부분을 **인터페이스**라고 부른다. 
- **캡슐화**는 외부에서 알 필요가 없는 부분을 감춤으로써 대상을 단순화하는 추상화의 한 종류다.
- 일반적으로 좋은 설계란 높은 응집도와 낮은 결합도를 가진 모듈로 구성된 설계를 의미한다. 
- 단일 책임 원칙(Single Responsibility Principle, SRP) : 클래스는 단 한 가지의 변경 이유만 가져야 한다. 
- 객체는 스스로의 상태를 책임져야 하며 외부에서는 인터페이스에 정의된 메서드를 통해서만 상태에 접근할 수 있어야 한다. 
- 객체를 설계할 때는 이 객체가 어떤 데이터를 포함해야 하는지와 데이터에 대해 수행해야 하는 오퍼레이션은 무엇인지 생각해야 한다. 
- 데이터 중심의 설계는 본질적으로 너무 이른 시기에 데이터에 관해 결정하도록 강요한다. 
- 데이터 중심의 설계에서는 협력이라는 문맥을 고려하지 않고 객체를 고립시킨 채 오퍼레이션을 결정한다. 
- 데이터 중심의 설계에서의 초점은 객체의 외부가 아니라 내부로 향하기 때문에 내부에 너무 많은 것을 녹여내면서 외부로 노출하게 되고 이는 추후에 객체 외에 것들에도 많은 변경을 야기하게 된다.  
- 데이터 중심의 설계는 행동보다 데이터를 먼저 결정하고 협력이라는 문맥을 벗아나 고립된 객체의 상태에 초점을 맞추기 때문에 캠슐화를 위반하기 쉽고, 요소들 사이의 결합도가 높아지며, 코드를 변경하기 어려워진다. 

## 05 책임 할당하기

- 데이터보다 행동을 먼저 결정하라. 
- 협력이라는 문맥 안에서 책임을 결정하라. 
- 객체를 결정하기 전에 객체가 수신할 메시지를 먼저 결정한다. 
- 메시지는 메시지를 수신할 객체가 아니라 메시지를 전송할 객체의 의도를 반영해서 결정해야 한다. 
- 책임을 수행하는데 필요한 정보를 가지고 있는 객체에게 할당하라.
- 설계의 전체적인 결합도가 낮게 유지되도록 책임을 할당하라. 
- 낮은 응집도가 초래하는 문제를 해결하기 위해서는 변경의 이유에 따라 클래스를 분리해야 한다. 
- 설계를 개선하는 작업은 변경의 이유가 하나 이상인 클래스를 찾는 것으로부터 시작하는 것이 좋다. 
- 자신이 소유하고 있는 데이터를 자기 스스로 처리하도록 만드는 것이 자율적인 객체를 만드는 지름길이다. 

## 06 메시지와 인스턴스 

- 훌륭한 객체지향 코드를 얻기 위해서는 클래스가 아니라 객체를 지향해야 한다. 다시 말해 렵력 안에서 객체가 수행하는 책임에 초점을 맞춰야 한다. 
- 한 객체가 다른 객체에게 도움을 요청하는 것을 **메시지 전송(message sending)**또는 **메시지 패싱(message passing)**이라고 부른다.
- 메시지를 수신했을 때 실제로 실행되는 함수 또는 프로시저를 **메서드**라고 부른다.
- 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합을 **퍼블릭 인터페이스**라고 부른다. 
- 퍼블릭 인터페이스에 포함된 메시지를 **오퍼레이션(operation)**이라고 부른다. 오퍼레이션은 수행 가능한 어떤 행동에 대한 추상화다.
- 오퍼레이션(또는 메서드)의 이름과 파라미터 목록을 합쳐 **시그니처(signature)**라고 부른다.
- 디미터 법칙(Law of Demeter)이란 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하는 것이다.
- 디미터 법칙을 따르도록 코드를 개선하면 메시지 전송자는 더 이상 메시지 수신자의 내부 구조에 대해 묻지 않고, 자신이 원하는 것이 무엇인지를 명시하고 단순히 수행하도록 요청한다.
- 절차적인 코드는 정보를 얻은 후에 결정한다. 객체지향 코드는 객체에게 그것을 하도록 시킨다. 
- 어떻게 하느냐가 아니라 무엇을 하느냐에 따라 메서드의 이름을 짓는 패턴을 **의도를 드러내는 선택자(Intention Revealing Selector)**라고 부른다. 
- 어떤 절차를 묶어 호출 가능하도록 이름을 부여한 기능 모듈을 **루틴(routine)**이라고 한다.
- 프로시저는 정해진 절차에 따라 내부의 상태를 변경하는 루틴의 한 종류다.
- 함수는 어떤 절차에 따라 필요한 값을 계산해서 반환하는 루틴의 한 종류다.

## 07 객체 분해 

- 불필요한 정보를 제거하고 현재의 문제 해결에 필요한 핵심만 남기는 작업을 **추상화**라고 부른다.
- **프로시저 추상화**는 소프트웨어가 무엇을 해야 하는지를 추상화한다.
- **데이터 추상화**는 소프트웨어가 무엇을 알아야 하는지를 추상화한다. 