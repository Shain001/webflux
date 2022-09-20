package com.webflux.webfluxandlambda.javaFunctionals;

import com.webflux.webfluxandlambda.common.People;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    @Test
    public void testBiFunction(){
        // Note: when you have more than one param, you cannot new like "People::new"
        // Why? -> since you have two params, java doesn't know the order of param that send to the constructor
        BiFunction<Integer, String, People> createPeople = (age, name) -> new People(name, age);
    }

    @Test
    public void testDefaultMethods(){
        // BiFunction 只有 andThen 方法，没有 compose 方法， 也很好理解， 因为BiFunction有两个输入， 但是compose方法只能接受一个before
    }
}
