package com.webflux.subscriber;


import java.util.concurrent.Flow;

public class DemoSubscriber implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("subscribe success");
        this.subscription = subscription;
        this.subscription.request(5);
    }

    @Override
    public void onNext(Integer o) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("consuming item: " + o);
        subscription.request(5);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("got error");
    }

    @Override
    public void onComplete() {
        System.out.println("consume end");
    }
}
