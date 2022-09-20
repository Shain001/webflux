package com.webflux.webfluxandlambda.javaFunctionals;

import com.jayway.jsonpath.internal.path.FunctionPathToken;
import com.webflux.webfluxandlambda.common.People;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo {

    @Test
    public void testFunction() {
        Function<String, People> createPeople = People::new;
        System.out.println(createPeople.apply("name"));
    }

    @Test
    public void testDefaultMethods() {
        // Look the source code, composeMethod takes "before" as param
        Function<Integer, Double> thenConvertIntToDouble = integer -> (double) integer / 2;
        Function<String, Integer> firstConvertStringToInt = str -> Integer.parseInt(str + "5");

        //Fuction Type 's default methods only accept same type as input, same as all other functional types
        // So you cannot pass Consumer to thenConvertIntToDouble.andThen() method to print the result.
        //Consumer<Double> printer = System.out::println;
        System.out.println(thenConvertIntToDouble.compose(firstConvertStringToInt).apply("5"));
        System.out.println(firstConvertStringToInt.andThen(thenConvertIntToDouble).apply("5"));

        // identity() -> Note this is a static method
        // it takes no param, only returns a function that returns its input
        Function<String, String> fun = Function.identity();
        System.out.println(fun.apply("input"));
    }
}
