package com.demo.small;

import com.demo.small.event.SimpleEvent;
import com.demo.small.service.SimpleService;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.TimeUnit;

public class AppMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("app started..");
        SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
        SeContainer container = containerInit.initialize();

        // Fire synchronous event that triggers the code in App class.
//        container.getBeanManager().fireEvent(new SimpleEvent());
        container.select(SimpleService.class).get().fireAsyncEvent();

        TimeUnit.SECONDS.sleep(10);

        container.close();
        System.out.println(" Container is closed.....");
    }
}
