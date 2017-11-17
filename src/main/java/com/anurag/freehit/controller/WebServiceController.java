package com.anurag.freehit.controller;

import com.anurag.freehit.model.response.EchoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

@RestController
public class WebServiceController {

    @GetMapping(value = "/delay", produces = "application/json")
    public Mono<EchoResponse> echo(@RequestParam long delay, @RequestHeader HttpHeaders headers) {
        return Mono.fromCallable(headers::toSingleValueMap)
                .map(data -> EchoResponse.valueOf(data, true, ""))
                .delaySubscription(Duration.ofMillis(delay))
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(value = "/randomDelay", produces = "application/json")
    public Mono<EchoResponse> randomDelay(@RequestParam long minDelay, @RequestParam long maxDelay, @RequestHeader HttpHeaders headers) {
        return Mono.fromCallable(headers::toSingleValueMap)
                .map(data -> EchoResponse.valueOf(data, true, ""))
                .delaySubscription(Duration.ofMillis(getRandomDelay(minDelay, maxDelay)))
                .subscribeOn(Schedulers.elastic());
    }

    private long getRandomDelay(long s, long e) {
        if (s > e) {
            long t = e;
            e = s;
            s = t;
        }
        return (long) (s + (e - s + 1) * Math.random());
    }

    @Autowired
    public WebServiceController(Random rng) {
        this.rng = rng;
    }

    private final Random rng;
}
