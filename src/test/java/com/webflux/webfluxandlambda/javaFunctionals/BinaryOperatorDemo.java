package com.webflux.webfluxandlambda.javaFunctionals;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    @Test
    public void testBiOperator(){
        BinaryOperator<Integer> adder = Integer::sum;
        System.out.println(adder.apply(3,4));
    }

    @Test
    public void testDefaults(){
        // 类似与 UnaryOperator, BinaryOperator 继承自 BiFunction， 所以也只有andThen
        // 至此， 只需要记住 ->
        // 1. 只有同种类型的才能相连接， i.e. function 前后是 Function， Consumer 前后是 Consumer， etc
        // 2. Binary输入的没有 compose, 但是有 andThen。

        // 两个 static 方法 minBy & maxBy, 就是传入比较器而已， 略

    }
}
