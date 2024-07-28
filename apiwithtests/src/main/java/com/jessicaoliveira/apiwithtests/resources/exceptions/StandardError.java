package com.jessicaoliveira.apiwithtests.resources.exceptions;

import java.time.LocalDateTime;

public class StandardError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    // Construtor com todos os argumentos
    public StandardError(LocalDateTime timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    // Construtor sem argumentos (padrão)
    public StandardError() {
    }

    // Getters e Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
