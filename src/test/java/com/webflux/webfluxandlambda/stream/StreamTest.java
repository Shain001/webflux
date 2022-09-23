package com.webflux.webfluxandlambda.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void testStreamOrder_onlyStateless() {
        String demo = "This is Shain";
        Stream.of(demo.split(" "))
                .peek(System.out::print)
                .forEach(s -> System.out.print(s.length() + " "));

        // result: This4 is2 Shain5
        // 当所有的中间操作都是"无状态"操作时， 流的执行顺序为 一个元素一个元素的执行， 即让第一个元素走完整个pipeline， 然后处理第二个
    }

    @Test
    public void testStreamOrder_mixed(){
        String demo = "This is Shain";
        Stream.of(demo.split(" "))
                .peek(System.out::print)
                .sorted()
                .forEach(s -> System.out.print(s.length() + " "));
        // result: ThisisShain5 4 2
        // 当中间操作既有 "无状态" 又有 "有状态" 时， 执行顺序为先把有状态的执行完， 再去执行无状态的。
    }

    @Test
    public void testStreamOrder_mixed2(){
        String demo = "This is Shain";
        Stream.of(demo.split(" "))
                .peek(System.out::print)
                .peek(s -> System.out.print(s.length()))
                .sorted()
                .peek(System.out::print)
                .forEach(s -> System.out.print(s.length() + " "));
        // This4is2Shain5 Shain5 This4 is2
        // 而 无状态/有状态 操作 之间的执行顺序 依然是一个一个元素的执行
    }


}
