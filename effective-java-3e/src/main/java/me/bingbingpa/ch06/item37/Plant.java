package me.bingbingpa.ch06.item37;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    private final String name;
    private final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("바질",    LifeCycle.ANNUAL),
                new Plant("캐러웨이", LifeCycle.BIENNIAL),
                new Plant("딜",      LifeCycle.ANNUAL),
                new Plant("라벤더",   LifeCycle.PERENNIAL),
                new Plant("파슬리",   LifeCycle.BIENNIAL),
                new Plant("로즈마리", LifeCycle.PERENNIAL)
        };

        Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println("plantsByLifeCycle = " + plantsByLifeCycle);

        // EnumMap 이 아닌 고유한 맵 구현체를 사용했기 때문에 EnumMap 을 써서 얻는 공간과 성능 이점이 사라진다.
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle))
        );

        // EnumMap 을 이용해 데이터와 열거 타입을 매핑
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), toSet()))
        );

    }
}
