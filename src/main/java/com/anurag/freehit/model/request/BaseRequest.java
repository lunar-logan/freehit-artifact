package com.anurag.freehit.model.request;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BaseRequest implements Serializable {

    // this counter is used to assign every request a unique id
    private static final AtomicLong ctr = new AtomicLong(0L);

    protected BaseRequest() {
        this.id = ctr.incrementAndGet();
    }

    public long getId() {
        return id;
    }

    private final long id;
}
