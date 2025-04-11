package edu.dio.spring_security_projeto.handler;

public class BusinessException extends RuntimeException {
    private final int statusCode;

    public BusinessException(String mensagem, int statusCode) {
        super(mensagem);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}