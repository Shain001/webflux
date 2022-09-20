package com.webflux.webfluxandlambda.javaFunctionals;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ConsumerDemo {
    @Test
    public void testConsumer(){
        // This is using lambda to call static method
        Consumer<String> printer = System.out::println;
        Consumer<String> printerWithExtraMessage = str -> System.out.println(str + "This cannot use ::println");
        Consumer<String> printerToUpperCase = str -> {
            str = str.toUpperCase();
            System.out.println(str);
        };

        String input = "test printer";
        printer.accept(input);
        printerWithExtraMessage.accept(input);
        printerToUpperCase.accept(input);
    }

    @Test
    public void testConsumerAndThen(){
        Consumer<String> first = s -> s = s + " added by first consumer";
        Consumer<String> second = s -> s = s + " added by second consumer";
        Consumer<String> third = System.out::println;

        String initial = "initial message";

        // Wrongly Thinking, you thought it would sout initial xx + first xx + added xx ..
        // But it turns out to print initial message only, why is that?
        // Because this is CONSUMER instead of UNARYOperator.
        // Consumer doesn't have return value, so the flow of this line of code is that the same input "initial message"
        // is being sent to three different consumers.
        // Check the next example to prove;
        first.andThen(second).andThen(third).accept(initial);

        Consumer<String> firstPrinter = s -> System.out.println("consumered by first, accepted String: " + s);
        Consumer<String> secondPrinter = s -> System.out.println("consumered by second, accepted String: " + s);
        firstPrinter.andThen(secondPrinter).accept(initial);
    }
}
