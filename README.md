# study toby spring


### 1장. 오브젝트와 의존관계

- DAO(Data Access Object) : DB 를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트 
- 자바빈 : 자바빈은 원래 비주얼 툴에서 조작 가능한 컴포넌트를 말하지만 최근에는 다음 두 가지 관례를 따라 만들어진 오브젝트를 가리키고 간단히 빈이라고 부르기도 한다. 
    - 디폴트 생성자 : 자바빈은 파라미터가 없는 디폴트 생성자를 갖고 있어야 한다. 툴이나 프레임워크에서 리플렉션을 이용해 오브젝트를 생성하기 때문에 필요하다. 
    - 프로퍼티 : 자바빈이 노출하는 이름을 가진 속성을 프로퍼티라고 한다. 프로퍼티는 set 으로 시작하는 수정자 메소드(setter) 와 get 으로 시작하는 접근자 메소드(getter) 를 이용해 수정 또는 조회 할 수 있다.
- 템플릿 메소드 패턴 
    - 변하지 않는 기능은 슈퍼클래스에 만들어주고 자주 변경되며 확장할 기능은 서브클래스에서 만들도록 한다.
    - 슈퍼클래스에서는 미리 추상 메소드 또는 오버라이드 가능한 메소드를 정의해두고 이를 활용해 코드의 기본 알고리즘을 담고 있는 템플릿 메소드를 만든다. 
    - 서브클래스에서는 추상 메소드를 구현하거나, 훅 메소드를 오버라이드하는 방법을 이용해 기능의 일부를 확장한다. 
- 팩토리 메소드 패턴 
    - 슈퍼클래스 코드에서는 서브클래스에서 구현할 메소드를 호출해서 필요한 타입의 오브젝트를 가져와 사용한다. 
    - 서브클래스는 다양한 방법으로 오브젝트를 생성하는 메소드를 재정의할 수 있다. 
    - 이렇게 서브클래스에서 오브젝트 생성 방법과 클래스를 결정할 수 있도록 미리 정의해둔 메소드를 팩토리 메소드라고 하고, 이 방식을 통해 오브젝트 생성 방법을 나머지 로직, 즉 슈퍼클래스의 기본 코드에서 독립
    시키는 방법을 팩토리 메소드 패턴이라고 한다.
- 클래스 사이에 관계가 만들어진다는 것은 한 클래스가 인터페이스 없이 다른 클래스를 직업 사용한다는 뜻이다. 따라서 클래스가 아니라 오브젝트와 오브젝트 사이의 관계를 설정해줘야 한다. 
- 개방 폐쇄 원칙 : 클래스나 모듈은 확장에는 열려 있어야 하고 변경에는 닫혀 있어야 한다. 
    - 응집도가 높다는 건 하나의 모듈, 클래스가 하나의 책임 또는 관심사에만 집중되어 있다는 뜻이다.
    - 높은 응집도는 클래스 레벨뿐 아니라, 패키지, 컴포넌트, 모듈에 이르기까지 그 대상의 크기가 달라도 동일한 원리로 적용될 수 있다. 
    - 책임과 관심사가 다른 오브젝트 또는 모듈과는 낮은 결합도, 즉 느슨하게 열결된 형태를 유지하는 것이 바람직하다. 
    - 낮은 결합도란 결국, 하나의 변경이 발생할 때 마치 파문이 이는 것처럼 여타 모듈과 객체로 변경에 대한 요구가 전파되지 않는 상태를 말한다. 
- 전략 패턴 
    - 자신의 기능 맥락(context) 에서, 피룡에 따라 변경이 필요한 알고리즘 클래스를 필요에 따라 바꿔서 사용할 수 있게 하는 디자인 패턴이다. 
- 객체의 생성 방법을 결정하고 그렇게 만들어진 오브젝트를 돌려주는 일을 하는 오브젝트를 **팩토리**라고 부른다. 
- 스프링이 제어권을 가지고 직접 만들고 관계를 부여하는 오브젝트를 빈(bean)이라고 부른다.
    - 자바빈 또는 엔터프라이즈 자바빈에서 말하는 빈과 비슷한 오브젝트 단위의 애플리케이션 컴포넌트를 말한다.
    - 동시에 스프링 빈은 스프링 컨테이너가 생성과 관계설정, 사용 등을 제어해주는 제어의 역전이 적용된 오브젝트를 가리키는 말이다. 
- 스프링에서는 빈의 생성과 관계설정 같은 제어를 담당하는 IoC 오브젝트를 **빈 팩토리**라고 부른다. 보통 빈 팩토리보다는 이를 좀 더 확장한 **애플리케이션 컨텍스트**를 주로 사용한다.
- @Configuration : 스프링이 빈 팩토리를 위한 오브젝트 설정을 담당하는 클래스라고 인식하도록 한다. 
- getBean() : ApplicationContext 가 관리하는 오브젝트를 요청하는 메소드 
- applicationContext 는 애플리케이션에서 IoC를 적용해서 관리할 모든 오브젝트에 대한 생성과 관계설정을 담당한다.