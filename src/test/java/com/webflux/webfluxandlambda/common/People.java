package com.webflux.webfluxandlambda.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class People {
    String name;
    int age;

    public People(String name){
        this.name = name;
        this.age = 0;
    }
}
