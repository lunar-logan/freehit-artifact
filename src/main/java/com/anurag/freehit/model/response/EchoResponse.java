package com.anurag.freehit.model.response;

import java.util.Map;

public class EchoResponse extends BaseResponse {
    private static final long serialVersionUID = -6258885830680372817L;

    public static EchoResponse valueOf(Map data, boolean success, String message) {
        EchoResponse response = new EchoResponse();
        response.setData(data);
        response.setSuccessful(success);
        response.setMessage(message);
        return response;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "EchoResponse{" +
                "data=" + data +
                ", successful=" + successful +
                ", message='" + message + '\'' +
                '}';
    }

    private Map data;
}
