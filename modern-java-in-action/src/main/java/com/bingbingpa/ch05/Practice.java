package com.bingbingpa.ch05;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Practice {
    
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // 질의 1 : 2011년부터 발생한 모든 거래를 찾아 값으로 정렬(작은 값에서 큰 값).
        List<Transaction> q1 = transactions.stream()
            .filter(transaction -> transaction.getYear() >=2011)
            .sorted(comparing(Transaction::getValue))
            .collect(toList());
        System.out.println("q1 ========================= " + q1);

        // 질의 2: 거래자가 근무하는 모든 고유 도시는?
        List<String> q2 = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .distinct()
            .collect(toList());
        System.out.println("q2 ========================= " + q2);
        // 질의 3: Cambridge의 모든 거래자를 찾아 이름으로 정렬. 
        List<Trader> q3 = transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .collect(toList());
        System.out.println("q3 ========================= " + q3);
        // 질의 4: 알파벳 순으로 정렬된 모든 거래자의 이름 문자열을 반환
        String q4 = transactions.stream() 
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (n1,n2) -> n1+n2);
        System.out.println("q4 ========================= " + q4); 
        // 질의 5: Milan에 거주하는 거래자가 잇는가? 
        boolean q5 = transactions.stream() 
            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("q5 ========================= " + q5);
        // 질의 6: Cambridge에 사는 거래자의 모든 거래내역 출력.
        transactions.stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .map(Transaction::getValue)
            .forEach(System.out::println);
        // 질의 7: 모든 거래에서 최고값은 얼마인가?
        int q7 = transactions.stream()
            .map(Transaction::getValue)
            .reduce(0, Integer::max);
            System.out.println("q7 ========================= " + q7); 

    }
}