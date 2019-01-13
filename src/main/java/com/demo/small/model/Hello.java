package com.demo.small.model;

import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Hello {


    @Asynchronous
    @Retry(delay = 200,retryOn = NullPointerException.class, maxRetries = 2)
    @Fallback(fallbackMethod = "sayHello")
    public Future<String> greet() {
        System.out.println("Hello World....");
        String s = null;
        s.length();
        return CompletableFuture.completedFuture("Hello");

    }

    private Future<String> sayHello() {
        System.out.println(" !! Fallback Hello World....");
        return CompletableFuture.completedFuture("FallBack-Hello");
    }
}
