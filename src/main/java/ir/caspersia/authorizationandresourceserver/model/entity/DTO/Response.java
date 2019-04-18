package ir.caspersia.authorizationandresourceserver.model.entity.DTO;

import ir.caspersia.authorizationandresourceserver.common.Common;

import java.sql.Timestamp;


public class Response<T> {

    private Timestamp timestamp = Common.now();
    private int       status;
    private String    error;
    private T         message;
    private String    path;

    public Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(200);
        response.setError("OK");
        return response;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Response<T> setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Response<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public Response<T> setError(String error) {
        this.error = error;
        return this;
    }

    public T getMessage() {
        return message;
    }

    public Response<T> setMessage(T message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Response<T> setPath(String path) {
        this.path = path;
        return this;
    }
}