package me.bingbingpa.ch04.item19;

import org.junit.jupiter.api.Test;

class SubTest {

    @Test
    void 상속용_클래스가_재정의_가능_메서드를_호출해서_발생하는_오류_테스트() {
        // instant 를 두 번 출력하리라 기대했지만, 첫 번째는 null 을 출력한다.
        // 상위 클래스의 생성자가 하위 클래스의 생성자가 인스턴스 필드를 초기화하기도 전에 override 한 메서드를 호출하기 때문이다.
        Sub sub = new Sub();
        sub.overrideMe();
    }

}