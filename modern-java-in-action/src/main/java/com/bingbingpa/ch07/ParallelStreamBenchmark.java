package com.bingbingpa.ch07;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime) //평균 시간 측정
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) // value 는 벤치마크 수행 횟수
public class ParallelStreamBenchmark {
    private static final long N = 10_000_000L;

    public static void main(String... args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark // 벤치마크 대상 메서드
    public static long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }
}
