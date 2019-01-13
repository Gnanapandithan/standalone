package com.demo.small.service;

import com.demo.small.event.SimpleEvent;
import com.demo.small.model.Hello;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

@ApplicationScoped
public class SimpleService {
    public SimpleService() {
    }

    private  Hello hello;
    private Event<SimpleEvent> simpleEventEvent;

    @Inject
    public SimpleService(Hello hello, Event<SimpleEvent> simpleEventEvent) {
        this.hello = hello;
        this.simpleEventEvent = simpleEventEvent;
        System.out.println(" SimpleService init..");
    }

    public void onAsyncEvent(@ObservesAsync SimpleEvent simpleEvent) {
        this.hello.greet();
    }
    public void fireAsyncEvent() {
        this.simpleEventEvent.fireAsync(new SimpleEvent());
    }
}
