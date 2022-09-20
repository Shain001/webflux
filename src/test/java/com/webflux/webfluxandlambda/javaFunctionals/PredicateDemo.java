package com.webflux.webfluxandlambda.javaFunctionals;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class PredicateDemo {
    @Test
    public void predicateTest(){
        Predicate<Integer> isPositive = input -> input > 0;
        Predicate<Integer> isNegative = input -> input < 0;
        // test "test" function
        System.out.println(isPositive.test(5));
        // test and()
        System.out.println(isPositive.and(isNegative).test(5));
        // test or()
        System.out.println(isPositive.or(isNegative).test(5));
    }
}
