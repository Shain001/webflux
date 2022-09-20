package com.webflux.webfluxandlambda.javaFunctionals;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class SupplierDemo {
    @Test
    public void testSupplier(){
        Supplier<Integer> supplier = () -> 2;
        System.out.println(supplier.get());
    }
}
