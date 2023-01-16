package com.drei.os.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long timestamp;
    private Integer status;
    private String error;

    public StandardError(Long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public StandardError() {
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
