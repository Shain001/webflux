package com.webflux;

import com.webflux.subscriber.DemoSubscriber;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        DemoSubscriber demoSubscriber = new DemoSubscriber();
        publisher.subscribe(demoSubscriber);

        IntStream.range(0, 300).peek(num -> {
            System.out.println(Thread.currentThread().getName() + "producing " + num);
            publisher.submit(num);})
                .max();

        publisher.close();
    }
}