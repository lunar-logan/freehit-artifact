package com.anurag.freehit.model.response;

import java.io.Serializable;

public abstract class BaseResponse implements Serializable {
    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected boolean successful;
    protected String message;
}
